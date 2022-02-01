package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.Observable;

class AttachFolderListFragment$4
  extends IObserver
{
  AttachFolderListFragment$4(AttachFolderListFragment paramAttachFolderListFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i = ((Integer)((HashMap)paramObject).get("push_attachfolder_accountid")).intValue();
    AttachFolderListFragment.access$000(this.this$0).update(i);
    QMLog.log(4, "AttachFolderListFragment", "Receive attach folder push accountId: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.4
 * JD-Core Version:    0.7.0.1
 */