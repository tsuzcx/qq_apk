package moai.log;
import android.util.Log;

/**
 * <pre>
 * 读配置
 * level，可选，默认值Log.VERBOSE
 * format，可选，默认值
 * </pre>
 */
public abstract class Handler {
	
	private int level;
	protected final Formatter formater;
	
	public Handler(int level, String format) {
		this.level = level;
		this.formater = new Formatter(format);
		check();
	}
	
	/**
	 * @param level
	 * @param tag
	 * @param msg
	 * @return 返回写入字节数
	 */
	public abstract int publish(int level, String tag, String msg);
	public abstract int publish(int level, String tag, String msg, Throwable t);

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	private void check() {
		if (!(level == Log.VERBOSE || level == Log.DEBUG || level == Log.INFO || level == Log.WARN || level == Log.ERROR || level == Log.ASSERT)) {
			throw new IllegalArgumentException("level " + level + " invalid");
		}
		// TODO
//		if (format == null) {
//			throw new IllegalArgumentException("format " + format);
//		}
	}
}
