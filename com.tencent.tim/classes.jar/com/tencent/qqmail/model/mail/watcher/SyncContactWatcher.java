package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SyncContactWatcher
  extends Watchers.Watcher
{
  public abstract void onAddError(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1, QMNetworkError paramQMNetworkError);
  
  public abstract void onAddSuccess(int paramInt, ArrayList<Long> paramArrayList, ArrayList<MailContact> paramArrayList1);
  
  public abstract void onDeleteError(int paramInt, ArrayList<Long> paramArrayList, QMNetworkError paramQMNetworkError);
  
  public abstract void onDeleteSuccess(int paramInt, ArrayList<Long> paramArrayList);
  
  public abstract void onEditError(int paramInt, ArrayList<MailContact> paramArrayList, QMNetworkError paramQMNetworkError);
  
  public abstract void onEditSuccess(int paramInt, ArrayList<MailContact> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SyncContactWatcher
 * JD-Core Version:    0.7.0.1
 */