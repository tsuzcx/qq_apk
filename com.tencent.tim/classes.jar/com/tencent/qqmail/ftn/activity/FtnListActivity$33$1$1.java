package com.tencent.qqmail.ftn.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.utilities.log.QMLog;

class FtnListActivity$33$1$1
  implements DialogInterface.OnDismissListener
{
  FtnListActivity$33$1$1(FtnListActivity.33.1 param1, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$2.this$1.this$0.getString(2131720712)))
    {
      QMLog.log(4, "FtnListActivity", "goToSystemFileExplorer");
      FtnListActivity.access$6000(this.this$2.this$1.this$0);
    }
    while (!this.val$tag.equals(this.this$2.this$1.this$0.getString(2131701863))) {
      return;
    }
    QMLog.log(4, "FtnListActivity", "goToQQBrowserFileExplorer");
    FtnListActivity.access$6100(this.this$2.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.33.1.1
 * JD-Core Version:    0.7.0.1
 */