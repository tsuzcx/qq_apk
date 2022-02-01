package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import java.util.HashMap;

class FtnListActivity$16$1
  implements Runnable
{
  FtnListActivity$16$1(FtnListActivity.16 param16, FtnUploadInfo paramFtnUploadInfo, HashMap paramHashMap) {}
  
  public void run()
  {
    this.this$1.this$0.updateUploadItemState(this.val$uploadItemData, 4);
    if (((Integer)this.val$notification.get("paramerrorcgiexceptioncode")).intValue() == -110)
    {
      String str = QMApplicationContext.sharedInstance().getString(2131694075);
      FtnListActivity.access$900(this.this$1.this$0).changeUploadItemViewState(this.val$uploadItemData, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.16.1
 * JD-Core Version:    0.7.0.1
 */