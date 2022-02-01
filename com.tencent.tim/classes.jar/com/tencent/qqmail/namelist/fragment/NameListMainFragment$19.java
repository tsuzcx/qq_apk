package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.watcher.DeleteNameListWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class NameListMainFragment$19
  implements DeleteNameListWatcher
{
  NameListMainFragment$19(NameListMainFragment paramNameListMainFragment) {}
  
  public void onBefore(int paramInt1, int paramInt2, String[] paramArrayOfString) {}
  
  public void onError(int paramInt1, int paramInt2, String[] paramArrayOfString, QMNetworkError paramQMNetworkError)
  {
    NameListMainFragment.access$2600(this.this$0, this.this$0.getString(2131690885));
  }
  
  public void onSuccess(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.this$0.refreshData();
    NameListMainFragment.access$2400(this.this$0, this.this$0.getString(2131690886));
    DataCollector.logEvent("Event_Black_White_Name_List_Slide_To_Remove");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.19
 * JD-Core Version:    0.7.0.1
 */