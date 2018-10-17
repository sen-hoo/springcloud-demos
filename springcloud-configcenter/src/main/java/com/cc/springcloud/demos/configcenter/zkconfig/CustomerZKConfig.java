package com.cc.springcloud.demos.configcenter.zkconfig;

import com.cc.springcloud.demos.configcenter.TestConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomerZKConfig {

    @Autowired
    private TestConfig testConfig;
    @Autowired
    private CuratorFramework client;

    @PostConstruct
    private void registListener() {
        String redisBasePath = "/configcenter/core/cache/redisconfig";
        watchNodeList(redisBasePath);
    }

    private void watchNodeList(String absPath) {
        TreeCache treeCache = new TreeCache(this.client, absPath);
        try {
            treeCache.start();
            TreeCacheListener treeCacheListener = new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
                    System.out.println("====================" + testConfig.getRedisNodeConfig() + "=====================");
                    ChildData childData = event.getData();
                    if (childData == null)
                        return ;
                    String value = null;
                    if (childData.getData() != null) {
                        value = new String(childData.getData());
                    }
                    switch (event.getType()) {
                        case NODE_UPDATED: {
                            System.out.println("config update");
                            System.out.println(testConfig.getRedisNodeConfig());
                            break ;
                        }
                        case NODE_ADDED: {
                            System.out.println("node add");
                            break;
                        }
                        case NODE_REMOVED: {
                            System.out.println("node removed");
                            break;
                        }
                        default:
                            System.out.println("Other event: " + event.getType().name());
                    }
                }


            };
            treeCache.getListenable().addListener(treeCacheListener);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
