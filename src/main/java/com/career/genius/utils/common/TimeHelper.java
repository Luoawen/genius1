package com.career.genius.utils.common;

import com.usm.utils.ObjectHelper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间处理工具类
 *
 * @author LZM
 * @since 2017-11-30
 * @version 1.0
 *
 */
public class TimeHelper {

	public static final String FormatYMDHSM = "yyyy-MM-dd HH:mm:ss";

	public static String toYMDHS(Date d) {
		return toFormatter(d, "yyyy-MM-dd HH:mm");
	}

	public static String now() {
		return toFormatter(new Date(), FormatYMDHSM);
	}

	public static String nowDay() {
		return toFormatter(new Date(), "yyyy-MM-dd");
	}

	public static String nowDayT() {
		return toFormatter(new Date(), "yyyyMMdd");
	}

	public static String toYMDHMS(Date d) {
		return toFormatter(d, FormatYMDHSM);
	}

	public static String toFormatter(Date d, String format) {
		if (ObjectHelper.isNotEmpty(d)) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.format(d);
		} else {
			return "";
		}

	}

	/**
	 * 默认构造方法
	 */
	public TimeHelper() {

	}

	public static int getCalendar(Calendar c, int field) {
		if (c != null) {
			return c.get(field);
		} else {
			return Calendar.getInstance().get(field);
		}
	}

	/**
	 * 得到年
	 *
	 * @param c
	 * @return
	 */
	public static int getYear(Calendar c) {
		return getCalendar(c, Calendar.YEAR);
	}

	/**
	 * 得到月份 注意，这里的月份依然是从0开始的
	 *
	 * @param c
	 * @return
	 */
	public static int getMonth(Calendar c) {
		return getCalendar(c, Calendar.MONTH);
	}

	/**
	 * 得到日期
	 *
	 * @param c
	 * @return
	 */
	public static int getDate(Calendar c) {
		return getCalendar(c, Calendar.DATE);
	}

	/**
	 * 得到星期
	 *
	 * @param c
	 * @return
	 */
	public static int getDay(Calendar c) {
		return getCalendar(c, Calendar.DAY_OF_WEEK);
	}

	/**
	 * 得到小时
	 *
	 * @param c
	 * @return
	 */
	public static int getHour(Calendar c) {
		return getCalendar(c, Calendar.HOUR);
	}

	/**
	 * 得到分钟
	 *
	 * @param c
	 * @return
	 */
	public static int getMinute(Calendar c) {
		return getCalendar(c, Calendar.MINUTE);
	}

	/**
	 * 得到秒
	 *
	 * @param c
	 * @return
	 */
	public static int getSecond(Calendar c) {
		return getCalendar(c, Calendar.SECOND);
	}

	public static Calendar calendarByDay(Calendar c, int n) {
		long offset = n * 24 * 60 * 60 * 1000;
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
		return calendar;
	}

	/**
	 * 得到指定或者当前时间前n天的Calendar
	 *
	 * @param c
	 * @param n
	 * @return
	 */
	public static Calendar beforeNDays(Calendar c, int n) {
		return calendarByDay(c, -n);
	}

	/**
	 * 得到指定或者当前时间后n天的Calendar
	 *
	 * @param c
	 * @param n
	 * @return
	 */
	public static Calendar afterNDays(Calendar c, int n) {
		return calendarByDay(c, n);
	}

	/**
	 * 昨天
	 *
	 * @param c
	 * @return
	 */
	public static Calendar yesterday(Calendar c) {
		return beforeNDays(c, 1);
	}

	/**
	 * 明天
	 *
	 * @param c
	 * @return
	 */
	public static Calendar tomorrow(Calendar c) {
		return afterNDays(c, 1);
	}

	/**
	 * 得到指定或者当前时间后n分钟的Calendar
	 *
	 * @param c
	 * @return
	 */
	public static Calendar afterMin(Calendar c, int n) {
		long offset = n * 60 * 1000;
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
		return calendar;
	}

	/**
	 * 得到指定或者当前时间前offset毫秒的Calendar
	 *
	 * @param c
	 * @param offset
	 * @return
	 */
	public static Calendar before(Calendar c, long offset) {
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar;
	}

	/**
	 * 得到指定或者当前时间前offset毫秒的Calendar
	 *
	 * @param c
	 * @param offset
	 * @return
	 */
	public static Calendar after(Calendar c, long offset) {
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar;
	}

	/**
	 * 日期格式化
	 *
	 * @param c
	 * @param pattern
	 * @return
	 */
	public static String format(Calendar c, String pattern) {
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyy年MM月dd日 HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(calendar.getTime());
	}

	/**
	 * Date类型转换到Calendar类型
	 *
	 * @param d
	 * @return
	 */
	public static Calendar Date2Calendar(Date d) {
		Calendar c = Calendar.getInstance();
		if (ObjectHelper.isNotEmpty(d)) {
			c.setTime(d);
		} else {
			c.setTime(new Date());
		}
		return c;
	}

	/**
	 * 后一个月
	 *
	 * @param c
	 * @return
	 */
	public static Date DateAfter(Date date, int month) throws ParseException {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.MONTH, month);
		return bt.getTime();
	}

	/**
	 * 后一个年
	 *
	 * @param c
	 * @return
	 */
	public static Date aYearLater(Date date) throws ParseException {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.YEAR, 1);
		return bt.getTime();
	}

	/**
	 * 后N年
	 *
	 * @param c
	 * @return
	 */
	public static String yearLater(Date date, int year) throws ParseException {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.YEAR, year);
		return toFormatter(bt.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 后N年
	 *
	 * @param c
	 * @return
	 */
	public static Date yearLaterDate(Date date, int year) throws ParseException {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.YEAR, year);
		return bt.getTime();
	}

	/**
	 * 后N天
	 *
	 * @param c
	 * @return
	 */
	public static String DateAfterDay(Date date, int day) throws ParseException {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.DAY_OF_YEAR, day);
		return toFormatter(bt.getTime(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * 前N天
	 *
	 * @param c
	 * @return
	 */
	public static String DateAfterDayForStr(Date date, int day) {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.DAY_OF_YEAR, -day);
		return toFormatter(bt.getTime(), "yyyy-MM-dd") + " 00:00:01";
	}

	/**
	 * 前N小时
	 *
	 * @param c
	 * @return
	 */
	public static String DateAfterHourForStr(Date date, int h) {
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.HOUR_OF_DAY, -h);
		return toFormatter(bt.getTime(), "yyyy-MM-dd HH") + " 00:01";
	}

	/**
	 * 后Nsecond
	 *
	 * @param c
	 * @return
	 */
	public static Long DateAfterSecond(int second) throws ParseException {
		Calendar bt = Date2Calendar(new Date());
		bt.add(Calendar.SECOND, second);
		return bt.getTime().getTime();
	}

	/**
	 * 2个Date时间的相差多少时间
	 *
	 * @param d
	 * @return
	 */
	public static String DateBDate(Date s, Date e) {
		String rs = "";
		long bt = Date2Calendar(e).getTimeInMillis() - Date2Calendar(s).getTimeInMillis();
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long
		long day = bt / nd;// 计算差多少天
		long hour = bt % nd / nh;// 计算差多少小时
		long min = bt % nd % nh / nm;// 计算差多少分钟
		long sec = bt % nd % nh % nm / ns;// 计算差多少秒
		if (day <= 0 && hour <= 0 && min <= 0 && sec <= 0) {
			rs = "-";
		} else {
			if (day > 0)
				rs += day + "日";
			if (hour > 0)
				rs += hour + "时";
			if (min > 0) {
				rs += min + "分";
			} else if (sec > 0) {
				rs += "1分";
			}
		}
		return rs;
	}

	public static String DateBDate(Date s) {
		return DateBDate(s, new Date());
	}

	/**
	 * 2个Date时间的相差多少秒
	 *
	 * @param d
	 * @return
	 */
	public static int DBD(Date s, Date e) {
		long bt = Date2Calendar(e).getTimeInMillis() - Date2Calendar(s).getTimeInMillis();
		long ns = 1000;// 一秒钟的毫秒数long
		long sec = bt / ns;// 计算差多少秒
		return (int) sec;
	}

	/**
	 * 2个Date时间的相差多少分钟
	 *
	 * @param d
	 * @return
	 */
	public static int DBDForM(Date s, Date e) {
		long bt = Date2Calendar(e).getTimeInMillis() - Date2Calendar(s).getTimeInMillis();
		long ns = 1000 * 60;// 一秒钟的毫秒数long
		long sec = bt / ns;// 计算差多少分钟
		return (int) sec;
	}

	public static int DBD(Date s) {
		return DBD(s, new Date());
	}

	/**
	 * 相差几分钟
	 *
	 * @param time
	 * @return
	 */
	public static int DBDForThree(String time) {
		int between = 0;
		try {
			if (ObjectHelper.isNotEmpty(time)) {
				between = DBD(TimeHelper.s2Date(time)) / 60;
			}
		} catch (Exception e) {
		}
		return between;
	}

	public static boolean greaterThanThreeMin(String time) {
		int min = DBDForThree(time);
		if (min >= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calendar类型转换到Date类型
	 *
	 * @param c
	 * @return
	 */
	public static Date Calendar2Date(Calendar c) {
		return c.getTime();
	}

	/**
	 * Date类型转换到Timestamp类型
	 *
	 * @param d
	 * @return
	 */
	public static Timestamp Date2Timestamp(Date d) {
		return new Timestamp(d.getTime());
	}

	/**
	 * Calendar类型转换到Timestamp类型
	 *
	 * @param c
	 * @return
	 */
	public static Timestamp Calendar2Timestamp(Calendar c) {
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * Calendar类型转换到Timestamp类型 N分钟后的时间
	 *
	 * @param c
	 * @return
	 */
	public static Timestamp timestampAfterMin(int n) {
		Calendar c = afterMin(Calendar.getInstance(), n);
		return new Timestamp(c.getTimeInMillis());
	}

	public static String afterMin(int n) {
		Calendar c = afterMin(Calendar.getInstance(), n);
		return toYMDHS(c.getTime());
	}

	/**
	 * Timestamp类型转换到Calendar类型
	 *
	 * @param ts
	 * @return
	 */
	public static Calendar Timestamp2Calendar(Timestamp ts) {
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		return c;
	}

	/**
	 * 得到当前时间的字符串表示 格式2010-02-02 12:12:12
	 *
	 * @return
	 */
	public static String getTimeString() {
		return format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 标准日期格式字符串解析成Calendar对象
	 *
	 * @param s
	 * @return
	 */
	public static Calendar pars2Calender(String s) {
		Timestamp ts = Timestamp.valueOf(s);
		return Timestamp2Calendar(ts);
	}

	public static Date string2Date(String time) {
		if (ObjectHelper.isEmpty(time)) {
			return new Date();
		}
		return new Date(Long.parseLong(time));
	}

	public static Long string2DateForStart(String time) throws ParseException {
		time = time + " 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt2 = sdf.parse(time);
		return dt2.getTime();
	}

	public static Long string2DateForEnd(String time) throws ParseException {
		time = time + " 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt2 = sdf.parse(time);
		return dt2.getTime();
	}

	public static String forStart(String time) throws ParseException {
		time = time + "-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt2 = sdf.parse(time);
		return toYMDHMS(dt2);
	}

	public static String forEnd(String time) throws ParseException {
		time = time + " 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt2 = sdf.parse(time);
		return toYMDHMS(dt2);
	}

	public static String forMonthEnd(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date dt2 = sdf.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt2);
		calendar.add(Calendar.MONTH, 1); // 加一个月
		calendar.set(Calendar.DATE, 1); // 设置为该月第一天
		calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
		dt2 = calendar.getTime();
		return toFormatter(dt2, "yyyyMMdd");
	}

	public static String timeForEnd(String time) {
		try {
			time = time + " 23:59:59";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt2 = sdf.parse(time);
			return toYMDHMS(dt2);
		} catch (ParseException p) {
			p.printStackTrace();
		}
		return "";
	}

	public static String timeForStart(String time) {
		try {
			time = time + " 00:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt2 = sdf.parse(time);
			return toYMDHMS(dt2);
		} catch (ParseException p) {
			p.printStackTrace();
		}
		return "";
	}

	public static String long2Date(Long l) {
		Date dt = new Date(l);
		return toYMDHMS(dt);
	}

	public static Date s2Date(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date dt2 = sdf.parse(time);
			return dt2;
		} catch (Exception e) {

		}
		return null;
	}

	public static Date s2Date(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt2 = sdf.parse(time);
		return dt2;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	public static Date DateAfterFiveS() throws ParseException {
		Calendar bt = Date2Calendar(new Date());
		bt.add(Calendar.SECOND, 5);
		return bt.getTime();
	}

	public static Date DateAfterS(int s) throws ParseException {
		Calendar bt = Date2Calendar(new Date());
		bt.add(Calendar.SECOND, s);
		return bt.getTime();
	}

	public static Date DateAfterSexS() throws ParseException {
		Calendar bt = Date2Calendar(new Date());
		bt.add(Calendar.SECOND, 60);
		return bt.getTime();
	}

	public static Date DateBeforeMin(Date date, int min) throws ParseException {
		if (ObjectHelper.isEmpty(date)) {
			date = new Date();
		}
		Calendar bt = Date2Calendar(date);
		bt.add(Calendar.MINUTE, -min);
		return bt.getTime();
	}

	public static String s2s(String time, String t) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt2 = sdf.parse(time);
		return toFormatter(dt2, t);
	}

	public static String timeFor26(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			Date dt2 = sdf.parse(time);
			Calendar cal = Date2Calendar(dt2);
			cal.add(Calendar.MONTH, -1);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			if (month < 10) {
				return year + "0" + month + "26";
			} else {
				return year + "" + month + "26";
			}
		} catch (ParseException p) {
			p.printStackTrace();
		}
		return "";
	}

	public static String timeForSixMonth(String time, int m) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			Date dt2 = sdf.parse(time);
			Calendar cal = Date2Calendar(dt2);
			cal.add(Calendar.MONTH, -m);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			if (month < 10) {
				return year + "0" + month;
			} else {
				return year + "" + month;
			}
		} catch (ParseException p) {
			p.printStackTrace();
		}
		return "";
	}

	public static int findDayLenForEveryYearInMonth(int year, int month) {
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, year);
		// year年
		time.set(Calendar.MONTH, month - 1);
		// Calendar对象默认一月为0,month月
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);// 本月份的天数
		return day;
	}

	/**
	 * 获取当前月份的天数
	 *
	 * @return
	 */
	public static int findDayLenForThisMonth() {
		Calendar time = Calendar.getInstance();
		int year = time.get(Calendar.YEAR);
		int month = time.get(Calendar.MONTH) + 1;
		return findDayLenForEveryYearInMonth(year, month);
	}

	public static String stsFormatter(String time, String f1, String f2) {
		return toFormatter(s2Date(time, f1), f2);
	}

	/**
	 * 判断时间是否在时间段内
	 *
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		if (nowTime == null)
			return true;
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		if (date.after(begin) && date.before(end)) {
			return true;
		} else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断时间是否在另一个时间之前
	 *
	 * @param date1
	 * @param date2
	 * @param unit
	 *            year,month,day
	 * @return date1 是否是在date2 之前（相同时间 返回true）
	 */
	@SuppressWarnings("deprecation")
	public static boolean before(Date date1, Date date2, String unit) {
		if (date1 == null || date2 == null) {
			return false;
		}
		if ("year".equals(unit)) {
			int year1 = date1.getYear();
			int year2 = date2.getYear();
			return year1 <= year2;
		} else if ("month".equals(unit)) {
			int year1 = date1.getYear();
			int year2 = date2.getYear();
			int month1 = date1.getMonth();
			int month2 = date2.getMonth();
			if (year1 < year2 || (year1 == year2 && month1 <= month2)) {
				return true;
			} else {
				return false;
			}
		}
		if ("day".equals(unit)) {
			int year1 = date1.getYear();
			int year2 = date2.getYear();
			int month1 = date1.getMonth();
			int month2 = date2.getMonth();
			int day1 = date1.getDate();
			int day2 = date2.getDate();
			if (year1 < year2 || (year1 == year2 && month1 < month2)
					|| (year1 == year2 && month1 == month2 && day1 <= day2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
