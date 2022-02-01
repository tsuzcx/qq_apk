package moai.log;
import android.util.Log;

/**
 * 输出到logcat
 */
public class LogcatHandler extends Handler {

	public LogcatHandler() {
		super(Log.VERBOSE, null);
	}

	@Override
	public int publish(int level, String tag, String msg) {
		return Log.println(level, tag, msg);
	}

	@Override
	public int publish(int level, String tag, String msg, Throwable t) {
		// TODO
		String cause = Log.getStackTraceString(t);
		return Log.println(level, tag, msg) + Log.println(level, tag, cause);
	}

}
