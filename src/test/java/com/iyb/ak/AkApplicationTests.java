package com.iyb.ak;

import com.alibaba.fastjson.JSON;
import com.iyb.ak.entity.Contents;
import com.iyb.ak.service.ContentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhangshukang on 2017/11/17.
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = MarsApplication.class)
public class AkApplicationTests {

    @Autowired
    ContentsService contentsService;

    @Test
    public void test() throws Exception {
        List<Contents> contents = contentsService.getContents();
        System.out.println(JSON.toJSONString(contents));
    }

}
