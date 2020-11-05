package org.nero.robbie.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blissleek
 * @version 1.0.0
 * @since 2020-10-28 20:10:00
 */
@RestController
@CrossOrigin
@RequestMapping("/robbie")
@Api(tags = "RobbieApiController")
public class RobbieApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobbieApiController.class);

    @ApiOperation(value = "robbie api", notes = "robbie api test", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String hello() {
        LOGGER.info("hello robbie");
        return "hello robbie";
    }
}
