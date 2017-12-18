package com.iyb.ak.exception;

import com.iyb.ak.entity.base.MessageVo;
import com.iyb.ak.logger.ErrorLogInfo;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanjun on 2017/5/17.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Value("${spring.application.name:}")
    private String systemName;

    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<MessageVo> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.error(ErrorLogInfo.build(ex, systemName, BaseException.ERR_9999, ex.getMessage()).toJson());
        log.error(ex.getMessage(), ex);
        MessageVo messages = new MessageVo();
        messages.addMessageObj(BaseException.ERR_9999, ex.getMessage(), "");
        return new ResponseEntity<>(messages, HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    @ExceptionHandler(NotFoundException.class)
////    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ResponseEntity<MessageVo> handleNotFoundException(HttpServletRequest request, HttpServletResponse response, NotFoundException ex) {
//        log.warn(ex.getMessage(), ex);
//        if(ex.getMessageList() == null){
//            NotFoundException ne = new NotFoundException(BaseException.ERR_9996, this);
//            return new ResponseEntity<>(ne.getMessageList(), HttpStatus.NOT_FOUND);
//        }
//        else
//            return new ResponseEntity<>(ex.getMessageList(), HttpStatus.NOT_FOUND);
//    }

}
