package com.iyb.ak.controller;

import com.iyb.ak.entity.Contents;
import com.iyb.ak.service.ContentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangshukang on 2017/11/9.
 */

@RestController
@Slf4j
@RequestMapping(value = "/content")
public class ContentsController {

    @Autowired
    ContentsService sysPermissionService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Contents> getContents() throws Exception {
        if (1 == 1) {
//            throw new Exception();
        }

        Contents content = new Contents();
        content.setContent("admin801122+test11");
        return Arrays.asList(content);
//        return sysPermissionService.getContents();
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public Contents getContentById(@PathVariable("id") Integer id) throws Exception {
        if (1 == 1) {
//            throw new Exception();
        }

        Contents content = new Contents();
        content.setContent("admin801122+test11");
        return Arrays.asList(content).get(0);
//        return sysPermissionService.getContents();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public int updateContent(@PathVariable("id") int id){
        return sysPermissionService.updateContent(id);
    }

}
