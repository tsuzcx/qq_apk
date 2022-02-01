package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask.CallBack;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadMailFragment$87
  implements WebviewCaptureTask.CallBack
{
  ReadMailFragment$87(ReadMailFragment paramReadMailFragment, QMTips paramQMTips) {}
  
  public void onError(String paramString)
  {
    this.val$tips.hideDelay(200L);
    ReadMailFragment.access$15900(this.this$0, new ReadMailFragment.87.2(this, paramString), 500L);
    StringBuilder localStringBuilder = new StringBuilder().append("saveWebviewFullScreenImage onError:");
    if (paramString != null) {}
    for (;;)
    {
      QMLog.log(6, "ReadMailFragment", paramString);
      return;
      paramString = "";
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (paramString == null) {
      return;
    }
    ReadMailFragment.access$15800(this.this$0, new ReadMailFragment.87.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.87
 * JD-Core Version:    0.7.0.1
 */