package com.hei123.woolboy;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lishencai lisc@yealink.com
 * @date 2019/8/1
 * @since 1.0.0
 */
@RestController()
@RequestMapping("/woolboy")
public class testController {

    Logger logger = LoggerFactory.getLogger(testController.class);

    @GetMapping("/wx")
    public void testConnect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = "woolboy";
        String echostr = request.getParameter("echostr");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        List<String> strings = Arrays.asList(token, timestamp, nonce);
        strings.sort(String::compareTo);
        String join = String.join("", strings);
        String digest = DigestUtils.sha1Hex(join);
        if (digest.equalsIgnoreCase(signature)) {
            logger.debug("成功");
        } else {
            logger.debug("失败");
        }
        logger.debug(signature);
        logger.debug(timestamp);
        logger.debug(nonce);
        logger.debug(echostr);
        response.getWriter().write(echostr);
    }
}
