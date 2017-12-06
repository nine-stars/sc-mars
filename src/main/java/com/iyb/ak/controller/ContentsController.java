package com.iyb.ak.controller;

import com.iyb.ak.entity.Contents;
import com.iyb.ak.service.ContentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangshukang on 2017/11/9.
 */


@RefreshScope
@RestController
@Slf4j
@RequestMapping(value = "/content")
public class ContentsController {

    @Autowired
    ContentsService sysPermissionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contents> getContents(HttpServletResponse response) throws Exception {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        System.out.println(request.getHeader("x-token"));
        System.out.println(request.getHeader("Cookie"));

        Cookie[] cookies = request.getCookies();

        Contents content = new Contents();
        content.setContent("admin801122+test11");

        response.setHeader("admin","admin");
        return Arrays.asList(content);
//        return sysPermissionService.getContents();
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public Contents getContentById(@PathVariable("id") Integer id) throws Exception {

        Contents content = new Contents();
        return Arrays.asList(content).get(0);
//        return sysPermissionService.getContents();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public int updateContent(@PathVariable("id") int id){
        return sysPermissionService.updateContent(id);
    }

}
