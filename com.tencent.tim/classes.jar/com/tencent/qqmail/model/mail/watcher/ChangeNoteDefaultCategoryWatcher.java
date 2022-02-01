package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import moai.core.watcher.Watchers.Watcher;

public abstract interface ChangeNoteDefaultCategoryWatcher
  extends Watchers.Watcher
{
  public abstract void onError(QMCGIError paramQMCGIError);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.ChangeNoteDefaultCategoryWatcher
 * JD-Core Version:    0.7.0.1
 */