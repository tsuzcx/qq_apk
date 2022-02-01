package moai.log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*package*/ class MLogImpl extends SimpleMLog {
	
	private final List<Handler> handlers = new CopyOnWriteArrayList<>();

	@Override
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
	
	@Override
	protected void process(int level, String tag, String msg) {
		for (Handler handler : handlers) {
			handler.publish(level, tag, msg);
		}
	}
	
	@Override
	protected void process(int level, String tag, String msg, Throwable t) {
		for (Handler handler : handlers) {
			handler.publish(level, tag, msg, t);
		}
	}

	@Override
	public Handler[] getAllHandler() {
		return handlers.toArray(new Handler[0]);
	}

	@Override
	public boolean removeHandler(Handler handler) {
		return handlers.remove(handler);
	}
	

}
