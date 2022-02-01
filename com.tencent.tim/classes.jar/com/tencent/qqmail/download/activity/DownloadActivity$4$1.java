package com.tencent.qqmail.download.activity;

import android.content.res.Resources;
import com.tencent.qqmail.ftn.util.SharedUrlUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareLinkDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;

class DownloadActivity$4$1
  implements Runnable
{
  DownloadActivity$4$1(DownloadActivity.4 param4, String paramString1, String paramString2) {}
  
  public void run()
  {
    DownloadActivity.access$300(this.this$1.this$0).hide();
    new QMShareLinkDialogHelper(this.this$1.this$0, this.this$1.this$0.getResources().getString(2131692325), SharedUrlUtil.getUrl(this.val$fid), this.val$fileName).createDialog().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.4.1
 * JD-Core Version:    0.7.0.1
 */