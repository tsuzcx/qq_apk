package moai.log;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * <pre>
 * 解析格式器
 * </pre>
 */
final class Formatter {
	enum FORMAT {
		RAW("raw"), // 字符串
		PID("pid"), // 进程id
		PNAME("pname"), // 进程名字
		TID("tid"), // 线程id
		TNAME("tname"), // 线程名字
		TAG("tag"), // TAG值
		LEVEL("level"), // 用V|D|I|W|E|A标识
		YYYY("yyyy"), // 年份，如2015
		YY("yy"), // 年份末两位，如15
		MONTH("mm"), // 月份，如09
		DD("dd"), // 日期，如01
		HH("HH"), // 小时，如01
		MINUTE("MM"), // 分钟，如01
		SS("SS"), // 秒数，如00
		SSS("sss") // 毫秒，如000
		;
		
		private String content;
		FORMAT(String content) {
			this.content = content;
		}
		public String getContent() {
			return content;
		}
	}

    private final FORMAT[] formats;
	private final String[] rawValues;
	
	public Formatter(String fmt) {
		if (fmt == null || fmt.length() == 0) {
			formats = null;
			rawValues = new String[] { fmt };
		} else {
			ArrayList<FORMAT> fmtList = new ArrayList<>(FORMAT.values().length);
			ArrayList<String> strList = new ArrayList<>(FORMAT.values().length);
			int begin = 0;
			int end;
			while (begin < fmt.length() && (end = fmt.indexOf('%', begin)) >= 0) {
				int formatTagBegin = end + 1;
				FORMAT formater = null;
				if (formatTagBegin < fmt.length()) {
					for (FORMAT f : FORMAT.values()) {
						// MARK yyyy必须在yy之前
						if (fmt.startsWith(f.content, formatTagBegin)) {
							formater = f;
							break;
						}
					}
				}
				if (formater != null) {
					fmtList.add(FORMAT.RAW);
					strList.add(fmt.substring(begin, end));
					fmtList.add(formater);
					begin = end + 1 + formater.content.length();
				} else {
					// %作为内容
					fmtList.add(FORMAT.RAW);
					strList.add(fmt.substring(begin, end + 1));
					begin = end + 1;
				}
			}
			if (begin < fmt.length()) {
				fmtList.add(FORMAT.RAW);
				strList.add(fmt.substring(begin));
			}
			formats = fmtList.toArray(new FORMAT[0]); 
			rawValues = strList.toArray(new String[0]);
		}
		
//		ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//		List<RunningAppProcessInfo> infoList = activityManager.getRunningAppProcesses();
//		int myPid = android.os.Process.myPid();
//		//用户反馈core
//		if(infoList != null){
//			for (RunningAppProcessInfo info : infoList) {
//				if (info.pid == myPid) {
//					processName = info.processName;
//				}
//				if (info.pid == myPid
//						&& info.processName.contains(PUSH_PROCESS_NAME)) {
//					bPushProcess = true;
//                    QMLog.simpleProcessName = "P";
//				}
//				if (info.pid == myPid
//						&& info.processName.contains(UNINSTALL_WATCH_PROCESS_NAME)) {
//					bUninstallProcess = true;
//                    QMLog.simpleProcessName = "U";
//				}
//				if (info.pid == myPid
//						&& info.processName.equals(CommonDefine.ANDROIDQQMAIL_PACKAGENAME)) {
//					bMainProcess = true;
//                    QMLog.simpleProcessName = "M";
//				}
//			}
//		}
		
	}
	
	private static ThreadLocal<GregorianCalendar> calendar = new ThreadLocal<GregorianCalendar>() {
		protected GregorianCalendar initialValue() {
			return new GregorianCalendar();
		}
	};
	
	/**
	 * 把format的内容输出到StringBuilder
	 * @param sb
	 */
	public void append(ByteBufferWrapper sb, String tag, int level, long logTime, long threadId, String threadName) {
		if (formats == null) {
			return;
		}
		// 觉得一般都需要时间
		GregorianCalendar c = calendar.get();
		c.setTimeInMillis(logTime);
		for (int i = 0, rawValuesIdx = 0; i < formats.length; i++) {
			switch (formats[i]) {
			case RAW:
				sb.append(rawValues[rawValuesIdx++]);
				break;
			case PID:
				sb.append(MLogManager.myPid());
				break;
			case PNAME:
				sb.append(MLogManager.mySimpleProcessName());
				break;
			case TID:
				sb.append(threadId);
				break;
			case TNAME:
				sb.append(threadName);
				break;
			case TAG:
				sb.append(tag);
				break;
			case LEVEL:
				sb.append(getType(level));
				break;
			case YYYY:
				sb.append(c.get(Calendar.YEAR));
				break;
			case YY:
				sb.append(c.get(Calendar.YEAR) % 100);
				break;
			case MONTH:
				int month = c.get(Calendar.MONTH) + 1;
				fillZero(sb, month, 2);
				break;
			case DD:
				fillZero(sb, c.get(Calendar.DATE), 2);
				break;
			case HH:
				fillZero(sb, c.get(Calendar.HOUR_OF_DAY), 2);
				break;
			case MINUTE:
				fillZero(sb, c.get(Calendar.MINUTE), 2);
				break;
			case SS:
				fillZero(sb, c.get(Calendar.SECOND), 2);
				break;
			case SSS:
				fillZero(sb, c.get(Calendar.MILLISECOND), 3);
				break;
			}
		}
		
	}
	
	private static void fillZero(ByteBufferWrapper sb, int value, int digit) {
		// 为了效率，不使用除法，采用枚举
		if (digit == 4 && 1000 > value) {
			sb.append('0');
			--digit;
		}
		if (digit == 3 && 100 > value) {
			sb.append('0');
			--digit;
		}
		if (digit == 2 && 10 > value) {
			sb.append('0');
			--digit;
		}
		sb.append(value);
	}

	private static void fillZero(StringBuilder sb, int value, int digit) {
		// 为了效率，不使用除法，采用枚举
		if (digit == 4 && 1000 > value) {
			sb.append('0');
			--digit;
		}
		if (digit == 3 && 100 > value) {
			sb.append('0');
			--digit;
		}
		if (digit == 2 && 10 > value) {
			sb.append('0');
			--digit;
		}
		sb.append(value);
	}
	
	/**
	 * 用于format日期
	 * @param c
	 * @return
	 */
	public String formatDate(GregorianCalendar c) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, rawValuesIdx = 0; i < formats.length; i++) {
			switch (formats[i]) {
			case RAW:
				sb.append(rawValues[rawValuesIdx++]);
				break;
			case YYYY:
				sb.append(c.get(Calendar.YEAR));
				break;
			case YY:
				sb.append(c.get(Calendar.YEAR) % 100);
				break;
			case MONTH:
				int month = c.get(Calendar.MONTH) + 1;
				fillZero(sb, month, 2);
				break;
			case DD:
				fillZero(sb, c.get(Calendar.DATE), 2);
				break;
			default:
				throw new IllegalStateException("not supported");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取format的正则
	 * @return
	 */
	Pattern formatDate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, rawValuesIdx = 0; i < formats.length; i++) {
			switch (formats[i]) {
			case RAW:
				sb.append(rawValues[rawValuesIdx++]);
				break;
			case YYYY:
				sb.append("\\d{4}");
				break;
			case YY:
			case MONTH:
			case DD:
				sb.append("\\d{2}");
				break;
			default:
				throw new IllegalStateException("not supported");
			}
		}
		return Pattern.compile(sb.toString());
	}
	
	private static String getType(int type) {
		String sType;
		switch (type) {
		case Log.VERBOSE:
			sType = "V";
			break;
		case Log.DEBUG:
			sType = "D";
			break;
		case Log.INFO:
			sType = "I";
			break;
		case Log.WARN:
			sType = "W";
			break;
		case Log.ERROR:
			sType = "E";
			break;
		case Log.ASSERT:
			sType = "A";
			break;
		default:
			throw new IllegalArgumentException("" + type);
		}
		return sType;
	}
	
}
