package com.iyb.ak;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;
import java.util.Set;


/**
 * Created by zhangshukang on 2017/11/17.
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = MarsApplication.class)
@Slf4j
public class PermAndMvcCheck {
	@Autowired()
	@Qualifier("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping handlerMapping;

	@Test
	public void checkPerm4Co() throws Exception{
		checkPerm2Url("/v1/co");
	}

	private void checkPerm2Url(String urlStart) throws Exception {
		//springMvc mapping
		Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();
		Set<RequestMappingInfo> requestMappings = Sets.newHashSet();
		for (RequestMappingInfo request : map.keySet()) {
			Set<String> patterns = request.getPatternsCondition().getPatterns();
			for (String pattern : patterns) {
				System.out.println(pattern);
				if (pattern.startsWith(urlStart)) {
					requestMappings.add(request);
					break;
				}
			}
		}
		int coNum = requestMappings.size();

	}
}


