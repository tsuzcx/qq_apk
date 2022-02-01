package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import ku;

class TextPreviewActivity$8
  implements Runnable
{
  TextPreviewActivity$8(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void run()
  {
    Drawable localDrawable = this.this$0.a.a(this.this$0.mFontId);
    if (localDrawable == null)
    {
      TextPreviewActivity.a(this.this$0.mFontId, this.this$0.app, this.this$0.d);
      return;
    }
    Message localMessage = this.this$0.mHandler.obtainMessage(18);
    localMessage.obj = localDrawable;
    this.this$0.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */