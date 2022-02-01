package moai.log;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;

import java.util.HashMap;
import java.util.List;

/**
 * Log的管理类
 */
@SuppressLint("InlinedApi")
public class MLogManager {
	/**
	 * shared_preferences文件名，用于通过shared_preferences配置
	 */
	public static final String SHARED_PREFERENCES_NAME = "mlog";

	
	private static HashMap<String, MLog> loggers = new HashMap<>();
//	private static Context context;
	
	private static int sPid;
	private static String sSimpleProcessName; // 进程的简称，如com.tencent.androidqqmail，简称M；com.tencent.androidqqmail:Push，简称:Push
	
	/**
	 * @param context Application
	 */
	public static void init(Context context) {
//		MLogManager.context = context;
		fetchProcessInfo(context);
	}
	
	/**
	 * 初始化进程名字
	 * @param processName
	 */
	public static void init(String processName) {
		sSimpleProcessName = processName;
	}
	
	/**
	 * <pre>
	 * 建议用法：在class中的静态变量MLogManager.getLogger("yourname");
	 * </pre>
	 * @param name
	 * @return
	 */
	public static synchronized MLog getLogger(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("name is null or empty");
		}
		MLog logger = loggers.get(name);
		if (logger == null) {
			logger = new MLogImpl();
			loggers.put(name, logger);
		}
		return logger;
	}
	
	/**
	 * 作为全局通用logger
	 * @return
	 */
	public static synchronized MLog getAnonymousLogger() {
		final String name = "";
		MLog logger = loggers.get(name);
		if (logger == null) {
			logger = new MLogImpl();
			loggers.put(name, logger);
		}
		return logger;
	}
	
	/**
	 * 获取进程id和进程名称
	 */
	private static void fetchProcessInfo(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> infoList = activityManager.getRunningAppProcesses();
		int myPid = android.os.Process.myPid();
		String processName = "M";
		if(infoList != null){
			for (RunningAppProcessInfo info : infoList) {
				if (info.pid == myPid) {
					processName = info.processName;
					int begin = processName.indexOf(':');
					if (begin < 0) {
						processName = "M";
					} else {
						processName = processName.substring(begin + 1);
					}
				}
			}
		}
		sPid = myPid;
		sSimpleProcessName = processName;
	}
	
	/*package*/ static int myPid() {
		if (sPid == 0) {
			sPid = android.os.Process.myPid();
		}
		return sPid;
	}
	
	/**
	 * @return maybe null, if not inovke {@link #init(Context)}
	 */
	/*package*/  static String mySimpleProcessName() {
		return sSimpleProcessName;
	}
}
