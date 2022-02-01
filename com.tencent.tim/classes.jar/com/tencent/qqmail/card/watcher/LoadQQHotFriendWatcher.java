package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadQQHotFriendWatcher
  extends Watchers.Watcher
{
  public abstract void onError(QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt, List<MailContact> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.LoadQQHotFriendWatcher
 * JD-Core Version:    0.7.0.1
 */