package com.career.genius.config.Exception;

import com.usm.enums.CodeEnum;
import com.usm.exception.ResicoException;
import com.usm.vo.BaseResultDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 请描述该类
 *
 * @author Marker
 * @time 2019-04-11 08:42
 * @discription
 **/
@ControllerAdvice(value = "com.career.genius.controller")
public class GeniusControllerAdvice {

    /**
     * @Author Marker
     * @Date
     * @Discription 统一Exception处理
     **/
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResultDto errorHandler(Exception ex) {
        BaseResultDto result = new BaseResultDto();
        result.setMsg(ex.getMessage());
        result.setCode(CodeEnum.SysError.getCode());
        ex.printStackTrace();
        return result;
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResultDto runtimeErrorHandler(RuntimeException ex) {
        BaseResultDto result = new BaseResultDto();
        result.setMsg(ex.getMessage());
        result.setCode(CodeEnum.SysError.getCode());
        ex.printStackTrace();
        return result;
    }

    /**
     * @Author Marker
     * @Date
     * @Discription 自定义Exception处理
     **/
    @ResponseBody
    @ExceptionHandler(value = GeniusException.class)
    public BaseResultDto myErrorHandler(GeniusException ex) {
        BaseResultDto result = new BaseResultDto();
        result.setCode(CodeEnum.Logic.getCode());
        result.setMsg(ex.getMessage());
        return result;
    }


}
