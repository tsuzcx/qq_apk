package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import ram;

class AbsVideoInfoWidget$3
  implements Runnable
{
  AbsVideoInfoWidget$3(AbsVideoInfoWidget paramAbsVideoInfoWidget) {}
  
  public void run()
  {
    if (this.this$0.g != null) {}
    try
    {
      this.this$0.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      ram.w(this.this$0.TAG, "dismiss dialog error :%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */