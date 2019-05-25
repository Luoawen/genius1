package com.career.genius.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alankin on 2019/2/17.
 */
public class MsgCodeUtil {
    /* 短信验证码位数*/
    public final static int MSG_CODE_NUM = 6;
    /*
    resultEnum中的参数
	ERROR_MOBILE(1001002,"请填写正确的手机号码"),
	MESSAGE_TIME_ERROR(1001003,"60秒内只能发送一次短信,请稍后再试"),
	MESSAGE_SEND_ERROR(1001004,"发送短信出错,请稍后再试"),
	MOBILE_NOT_SEND_CODE(1001005,"该手机号未获取验证码,请先获取验证码"),
	MOBILE_CAN_NOT_CHANGE(1001006,"此手机号与获取验证码的手机号不一致"),
	MESSAGE_CODE_INVALID(1001007,"此验证码失效,请重新获取验证码"),
	MESSAGE_CODE_ERROR(1001008,"验证码错误"),

	 */

    private static Logger log = LoggerFactory.getLogger(MsgCodeUtil.class);

    private static final String MSG_START_TIME = "msg_start_time"; //短信发送时间
    private static final String MOBILE_MSG_MOBILE = "mobile_msg_mobile"; //手机号
    private static final String MOBILE_MSG_CODE = "mobile_msg_code"; //验证码
    private static final Integer CODE_VALID_TIME = 5; //验证码有效时间,单位:分钟	/**

//    public static void sendCode(String msgCode, String phone, HttpSession session) {
//        //获取当前时间
//        long startTime = System.currentTimeMillis();
//        long startTimefromSessioin = (long) (httpSession.getAttribute(MSG_START_TIME) == null ? 0L : httpSession.getAttribute(MSG_START_TIME));
//        //验证码获取一次最少60秒 为了防止网络延迟 设置成55
//        if ( ((startTime - startTimefromSessioin) / 1000)<=(long) 55){
//            //发送验证码太频繁
//            throw new BizException(ResultEnum.MESSAGE_TIME_ERROR.getMsg());
//        }
//        //发送短信
//        //todo 封装短信内容
//        String message = "验证码:" + msgCode + "," + CODE_VALID_TIME + "分钟内有效";
//        //todo 调用第三方接口发送短信
////		Boolean sendSuccess = axisSendMsg(message, phone);
//        Boolean sendSuccess = true;
//        if (sendSuccess) {
//            //短信发送成功,设置属性到session
//            saveCode(session, phone, msgCode);
//        } else {
//            //短信发送失败,请稍后再试
//            throw new BizException(ResultEnum.MESSAGE_SEND_ERROR.getMsg());
//        }
//
//    }
// 校验验证码

    public static boolean validateCode(String mobile, String code, HttpSession session) {
//        if ("111111".equals(code)) {
//            return true;
//        }

        //判断该手机号是否发送过验证码
        String mobileFromSession = (String) session.getAttribute(MOBILE_MSG_MOBILE);
        if (StringUtils.isEmpty(mobileFromSession)) {
            //未发送过验证码
            throw new RuntimeException(ResultConstant.MESSAGE_CODE_NO_SEND.getMessage());
        }

        //判断手机号是否是发送验证码的手机号
        if (!mobile.equals(mobileFromSession))
            throw new RuntimeException(ResultConstant.MOBILE_CAN_NOT_CHANGE.getMessage());

        //获取短信发送时间
        long startTimeFromSession = (long) session.getAttribute(MSG_START_TIME);
        //判断当前验证码是否失效
        if (((System.currentTimeMillis() - startTimeFromSession) / 1000) >
                ((long) CODE_VALID_TIME * 60)) {
            throw new RuntimeException(ResultConstant.MESSAGE_CODE_ERROR.getMessage());
        }

        //判断验证码是否输入正确
        if (!code.equals((String) session.getAttribute(MOBILE_MSG_CODE))) {
            throw new RuntimeException(ResultConstant.MESSAGE_CODE_IS_ERROR.getMessage());
        }

        //校验通过
        return true;
    }

    /**
     * 短信发送成功后,保存验证码
     */
    public static void saveCode(HttpSession session, String phone, String msgCode) {
        session.setAttribute(MSG_START_TIME, System.currentTimeMillis());
        session.setAttribute(MOBILE_MSG_MOBILE, phone);
        session.setAttribute(MOBILE_MSG_CODE, msgCode);
    }

    /**
     * 使用验证码后,销毁验证码
     */
    public static void consumeCode(HttpSession session) {
        session.removeAttribute(MOBILE_MSG_MOBILE);
        session.removeAttribute(MSG_START_TIME);
        session.removeAttribute(MOBILE_MSG_CODE);
    }

    /**
     * 生成4位数字验证码
     */
    public static String createRandomVcode() {
        String vcode = "";
        for (int i = 0; i < MSG_CODE_NUM; i++) {
            vcode = vcode + (int) (Math.random() * 9);
        }
        return vcode;
    }

    /**
     * 校验手机号是否合法
     */
    public static Boolean isMobile(String number) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$");
            Matcher m = p.matcher(number);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
