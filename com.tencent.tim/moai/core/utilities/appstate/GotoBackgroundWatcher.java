package moai.core.utilities.appstate;

import moai.core.watcher.Watchers;

public interface GotoBackgroundWatcher extends Watchers.Watcher {
	/*
	 * 即将进入后台
	 */
	public void onGotoBackground();
}
