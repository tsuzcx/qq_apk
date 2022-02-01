package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.ui.QMTips;

class AttachImagePagerActivity$1$1
  implements Runnable
{
  AttachImagePagerActivity$1$1(AttachImagePagerActivity.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$ret == 0)
    {
      this.this$1.this$0.getTips().hide();
      QMApplicationContext.sharedInstance().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + this.val$fixedPath)));
      return;
    }
    if (this.val$ret == -2)
    {
      this.this$1.this$0.getTips().showError(2131718596);
      return;
    }
    this.this$1.this$0.getTips().showError(2131718595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */