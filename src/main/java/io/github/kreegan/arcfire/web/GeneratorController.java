package io.github.kreegan.arcfire.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kreegan.arcfire.service.MerchantShopGeneratorService;
import io.github.kreegan.arcfire.util.JSONUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * REST controller for generators
 */
@RestController
@RequestMapping("generate")
public class GeneratorController {

    @Resource
    private MerchantShopGeneratorService merchantShopGeneratorService;

    @RequestMapping(value = "merchant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateMerchantShop(@RequestParam("hasMagicItems") Boolean hasMagicItems) {

        return JSONUtil.getObjectAsJSONString(merchantShopGeneratorService.generateMerchantShop(hasMagicItems));
    }

}
