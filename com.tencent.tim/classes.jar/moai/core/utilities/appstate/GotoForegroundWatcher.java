package moai.core.utilities.appstate;

import moai.core.watcher.Watchers.Watcher;

public abstract interface GotoForegroundWatcher
  extends Watchers.Watcher
{
  public abstract void onGotoForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.appstate.GotoForegroundWatcher
 * JD-Core Version:    0.7.0.1
 */