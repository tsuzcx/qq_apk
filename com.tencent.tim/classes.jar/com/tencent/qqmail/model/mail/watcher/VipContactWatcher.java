package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.HashMap;
import moai.core.watcher.Watchers.Watcher;

public abstract interface VipContactWatcher
  extends Watchers.Watcher
{
  public abstract void onError(HashMap<Long, Boolean> paramHashMap, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(HashMap<Long, Boolean> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.VipContactWatcher
 * JD-Core Version:    0.7.0.1
 */