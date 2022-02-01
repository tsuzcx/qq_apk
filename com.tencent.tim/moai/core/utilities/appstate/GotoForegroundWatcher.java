package moai.core.utilities.appstate;

import moai.core.watcher.Watchers;

public interface GotoForegroundWatcher extends Watchers.Watcher {
	/*
	 * 即将进入前台
	 */
	public void onGotoForeground();
}
