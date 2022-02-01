package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SyncPhotoWatcher
  extends Watchers.Watcher
{
  public abstract void onError(QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher
 * JD-Core Version:    0.7.0.1
 */