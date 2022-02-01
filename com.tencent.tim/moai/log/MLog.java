package moai.log;
/**
 * <pre>
 * 与{@link android.util.Log}的接口一样
 * Level采用android.util.Log，设置到Handler中
 * </pre>
 */
public interface MLog {
	// 6个等级简写，ASSERT级使用println

	public void v(String tag, String msg);
	public void v(String tag, String fmt, Object... msgs);
	public void v(String tag, String msg, Throwable t);
	
	public void d(String tag, String msg);
	public void d(String tag, String fmt, Object... msgs);
	public void d(String tag, String msg, Throwable t);
	
	public void i(String tag, String msg);
	public void i(String tag, String fmt, Object... msgs);
	public void i(String tag, String msg, Throwable t);
	
	public void w(String tag, String msg);
	public void w(String tag, String fmt, Object... msgs);
	public void w(String tag, String msg, Throwable t);
	
	public void e(String tag, String msg);
	public void e(String tag, String fmt, Object... msgs);
	public void e(String tag, String msg, Throwable t);
	
	public void println(int level, String tag, String msg);
	
	/**
	 * 
	 * @param handler
	 */
	public void addHandler(Handler handler);
	/**
	 * @param handler
	 * @return true，含有handler
	 */
	public boolean removeHandler(Handler handler);
	public Handler[] getAllHandler();
}
