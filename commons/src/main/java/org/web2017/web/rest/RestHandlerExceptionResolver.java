package org.web2017.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.web2017.commons.Responses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestHandlerExceptionResolver implements HandlerExceptionResolver {
  private final Logger logger = LoggerFactory.getLogger( RestHandlerExceptionResolver.class );

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
    Result result = new Result();
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;

      if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
        result.setCode( ResultCode.FAIL ).setMessage( e.getMessage() );
        logger.info( e.getMessage() );
      } else {
        result.setCode( ResultCode.INTERNAL_SERVER_ERROR ).setMessage( "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员" );
        String message = String.format( "接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
            request.getRequestURI(),
            handlerMethod.getBean().getClass().getName(),
            handlerMethod.getMethod().getName(),
            e.getMessage() );
        logger.error( message, e );
      }
    } else {
      if (e instanceof NoHandlerFoundException) {
        result.setCode( ResultCode.NOT_FOUND ).setMessage( "接口 [" + request.getRequestURI() + "] 不存在" );
      } else {
        result.setCode( ResultCode.INTERNAL_SERVER_ERROR ).setMessage( e.getMessage() );
        logger.error( e.getMessage(), e );
      }
    }
    Responses.sendResult( response, result );
    return new ModelAndView();
  }

}
