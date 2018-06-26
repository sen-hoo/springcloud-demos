package com.cc.springcloud.demos.facades.belle;

import com.cc.springcloud.dto.Belle;
import org.springframework.web.bind.annotation.RequestMapping;

public interface BelleService {
    @RequestMapping("/belle/gen")
    Belle genStanderBelle();

}
