package moai.log;

import android.util.Log;

/**
 * 空实现
 */
public class SimpleMLog implements MLog {

	@Override
	public void v(String tag, String msg) {
		process(Log.VERBOSE, tag, msg);
	}

	@Override
	public void v(String tag, String fmt, Object... msgs) {
		process(Log.VERBOSE, tag, String.format(fmt, msgs));
	}

	@Override
	public void v(String tag, String msg, Throwable t) {
		process(Log.VERBOSE, tag, msg, t);
	}

	@Override
	public void d(String tag, String msg) {
		process(Log.DEBUG, tag, msg);

	}

	@Override
	public void d(String tag, String fmt, Object... msgs) {
		process(Log.DEBUG, tag, String.format(fmt, msgs));

	}

	@Override
	public void d(String tag, String msg, Throwable t) {
		process(Log.DEBUG, tag, msg, t);

	}

	@Override
	public void i(String tag, String msg) {
		process(Log.INFO, tag, msg);

	}

	@Override
	public void i(String tag, String fmt, Object... msgs) {
		process(Log.INFO, tag, String.format(fmt, msgs));

	}

	@Override
	public void i(String tag, String msg, Throwable t) {
		process(Log.INFO, tag, msg, t);

	}

	@Override
	public void w(String tag, String msg) {
		process(Log.WARN, tag, msg);

	}

	@Override
	public void w(String tag, String fmt, Object... msgs) {
		process(Log.WARN, tag, String.format(fmt, msgs));

	}

	@Override
	public void w(String tag, String msg, Throwable t) {
		process(Log.WARN, tag, msg, t);

	}

	@Override
	public void e(String tag, String msg) {
		process(Log.ERROR, tag, msg);

	}

	@Override
	public void e(String tag, String fmt, Object... msgs) {
		process(Log.ERROR, tag, String.format(fmt, msgs));

	}

	@Override
	public void e(String tag, String msg, Throwable t) {
		process(Log.ERROR, tag, msg, t);

	}

	@Override
	public void println(int level, String tag, String msg) {
		process(level, tag, msg);

	}

	/**
	 * 统一v,d,i,w,e请求
	 * @param level
	 * @param tag
	 * @param msg
	 */
	protected void process(int level, String tag, String msg) {
	}
	
	/**
	 * 统一v,d,i,w,e请求
	 * @param level
	 * @param tag
	 * @param msg
	 * @param t
	 */
	protected void process(int level, String tag, String msg, Throwable t) {
	}

	@Override
	public void addHandler(Handler handler) {
	}

	@Override
	public boolean removeHandler(Handler handler) {
		return false;
	}

	@Override
	public Handler[] getAllHandler() {
		return null;
	}

}
