package com.tencent.qqmail.paintpad;

import android.util.Log;
import com.tencent.qqmail.utilities.share.ShareUtil.ShareCallback;

class MailPaintPadActivity$6
  implements ShareUtil.ShareCallback
{
  MailPaintPadActivity$6(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void isSuccess(boolean paramBoolean)
  {
    Log.i("MailPaintPadActivity", "WXShareResultCallback " + paramBoolean);
    if (paramBoolean) {
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.6
 * JD-Core Version:    0.7.0.1
 */