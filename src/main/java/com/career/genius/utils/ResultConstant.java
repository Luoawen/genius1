package com.career.genius.utils;

/**
 * 系统接口结果常量枚举类
 * Created by alankin on 2017/4/26.
 */
public enum ResultConstant {

    /**
     * 失败
     */
    FAILED(0, "失败"),

    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    //----------------------------------200申请单----------------------------------------
    /**
     * 异常订单
     */
    ORDER_EXCEPTION_ORDER(200, "有异常订单，不能申请"),


    //----------------------------------100全局异常----------------------------------------
    EXCEPTION_FIELD_INVALID(99, "字段异常"),
    EXCEPTION_INVALID(100, "登录信息过期，请重新登录！"),
    EXCEPTION_NO_USER(101, "没有找到登录信息！"),
    EXCEPTION_ACOUNT_OR_PWD_NOT_RIGHT(102, "手机或密码输入错误!"),
    EXCEPTION_NO_ACOUNT(103, "该用户不存在!"),
    EXCEPTION_ACOUNT_EXIST(104, "该账号已存在!"),
    EXCEPTION_AUTH_CODE(105, "验证码输入错误!"),
    EXCEPTION_IP(106, "访问IP与登录不一致，请重新登录！"),
    EXCEPTION(98, "未知异常!"),
    EXCEPTION_MSG_CODE(107, "手机验证码输入错误!"),

    //----------------------------------300申请用户异常----------------------------------------
    /**
     * 异常订单
     */
    NO_DISTRIBUTE_VERIFY(300, "没有分配审核人"),
    VERIFY_EXCEPTION(301, "审核人状态异常"),
//    VERIFY_NOT_PASS(302, "审核未通过"),
    VERIFY_NOT_PASS(302, "正在审核中"),
    NO_DISTRIBUTE_BROWER(303, "没有分配借款人，无法申请"),
    //----------------------------------110全局自定义消息异常----------------------------------------


    //----------------------------------手机验证码异常----------------------------------------
    ERROR_MOBILE(1001002, "请填写正确的手机号码"),
    MESSAGE_TIME_ERROR(1001003, "60秒内只能发送一次短信,请稍后再试"),
    MESSAGE_SEND_ERROR(1001004, "发送短信出错,请稍后再试"),
    MOBILE_NOT_SEND_CODE(1001005, "该手机号未获取验证码,请先获取验证码"),
    MOBILE_CAN_NOT_CHANGE(1001006, "此手机号与获取验证码的手机号不一致"),
    MESSAGE_CODE_INVALID(1001007, "此验证码失效,请重新获取验证码"),
    MESSAGE_CODE_ERROR(1001008, "验证码错误"),
    MESSAGE_CODE_NO_SEND(1001009, "验证码没有发送"),
    MESSAGE_CODE_IS_ERROR(1001008, "验证码错误");
    public int code;

    public String message;

    ResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}