package com.cc.springcloud.demos.services.belle.endpoints;

import com.cc.springcloud.demos.services.belle.dto.Belle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "belle")
public class BelleEndPoint {

    @RequestMapping(value = "gen")
    public Belle genStanderBelle() {
        Belle belle = new Belle("xiaoLin", 18, 165, 98, new Integer[] {83, 68, 86});
        return belle;
    }

}
