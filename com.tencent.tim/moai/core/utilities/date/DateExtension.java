package moai.core.utilities.date;

import java.util.Calendar;
import java.util.Date;

public class DateExtension {
    public static String TAG = DateExtension.class.getSimpleName();

    private static final long INTERVAL_MINUTE = 60 * 1000;
	private static final long INTERVAL_HOUR = 60 * INTERVAL_MINUTE;
	private static final long INTERVAL_DAY = 24 * INTERVAL_HOUR;

    private static final Calendar mCalendar = Calendar.getInstance();

    private static String fillZero(int value) {
		return (value < 10 ? "0" : "") + value;
	}

    private static String readableWeekDay(int dayOfWeek) {
        String weekDay = "";
        switch (dayOfWeek) {
            case 1:
                weekDay = "日";
                break;
            case 2:
                weekDay = "一";
                break;
            case 3:
                weekDay = "二";
                break;
            case 4:
                weekDay = "三";
                break;
            case 5:
                weekDay = "四";
                break;
            case 6:
                weekDay = "五";
                break;
            case 7:
                weekDay = "六";
                break;
        }
        return weekDay;
    }

    private static long lastWeekInterval(int dayOfWeek, int nowHour, int nowMinute, int nowSecond) {
        return  (dayOfWeek - 2) * INTERVAL_DAY / 1000 + ((nowHour * 60 + nowMinute) * 60 + nowSecond);
    }

    public static String feedbackDateFormat(Date date) {
        Date now = new Date();
        if (date == null)
            date = now;

        mCalendar.setTime(now);
		int nowSecond = mCalendar.get(Calendar.SECOND);
		int nowMinute = mCalendar.get(Calendar.MINUTE);
		int nowHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		int nowDate = mCalendar.get(Calendar.DATE);
		int nowMonth = mCalendar.get(Calendar.MONTH) + 1;
		int nowYear = mCalendar.get(Calendar.YEAR);
        int nowWeekDay = mCalendar.get(Calendar.DAY_OF_WEEK);

        mCalendar.setTime(date);
	    int inputSecond = mCalendar.get(Calendar.SECOND);
		int inputMinute = mCalendar.get(Calendar.MINUTE);
		int inputHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		int inputDate = mCalendar.get(Calendar.DATE);
		int inputMonth = mCalendar.get(Calendar.MONTH) + 1;
		int inputYear = mCalendar.get(Calendar.YEAR);
        int inputWeekDay = mCalendar.get(Calendar.DAY_OF_WEEK);

		// 计算时间间隔
		long interval = now.getTime() - date.getTime();

        if (interval >= 0) {
            long dateDiffSecond = interval / 1000 - ( ((nowHour * 60 + nowMinute) * 60 + nowSecond) -  ((inputHour * 60 + inputMinute) * 60 + inputSecond) ); //相对值，单位秒
            if (dateDiffSecond < 0 + 1) { //误差1秒
                // 今天 "HH:mm"
                return fillZero(inputHour) + ":" + fillZero(inputMinute);
            } else if (dateDiffSecond < INTERVAL_DAY / 1000 + 1) {
                // 昨天 "昨天 HH:mm"
                return "昨天 " + fillZero(inputHour) + ":" + fillZero(inputMinute);
            } else if (inputWeekDay > 1 && interval / 1000 < lastWeekInterval(inputWeekDay, nowHour, nowMinute, nowSecond)) {
                // 一周内
                return "周" + readableWeekDay(inputWeekDay) + " " + fillZero(inputHour) + ":" + fillZero(inputMinute);
            } else if (inputYear == nowYear) {
                // 一周前
                return fillZero(inputMonth) + "月" + fillZero(inputDate) + "日 " + fillZero(inputHour) + ":" + fillZero(inputMinute);
            }

            if (inputYear != nowYear) {
                //今年，"MM月dd日"
                return inputYear + "年"  + fillZero(inputMonth) + "月" + fillZero(inputDate) + "日 " + fillZero(inputHour) + ":" + fillZero(inputMinute);
            }
		}
        return inputYear + "年" + fillZero(inputMonth) + "月" + fillZero(inputDate) + "日";
    }


    public static Date timeToDate(long time) {
        Date date = new Date();
        try {
            date.setTime(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date timeToDate(String timeStr) {
        try {
            long time = Long.parseLong(timeStr);
            return timeToDate(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
