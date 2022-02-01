package com.tencent.qqmail.card.watcher;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import moai.core.watcher.Watchers.Watcher;

public abstract interface BatchLoadCardListWatch
  extends Watchers.Watcher
{
  public abstract void onBefore();
  
  public abstract void onError(ArrayList<String> paramArrayList, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(ArrayList<String> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.watcher.BatchLoadCardListWatch
 * JD-Core Version:    0.7.0.1
 */