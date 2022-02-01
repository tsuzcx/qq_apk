package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import anqx;
import anvf;
import anvf.c;

public class StructMsgItemVideo$3
  implements Runnable
{
  public StructMsgItemVideo$3(anvf paramanvf, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = anqx.load(this.I, this.this$0.uin, anvf.a(this.this$0));
    this.this$0.a.obtainMessage().obj = this.val$view;
    if (!TextUtils.isEmpty(str))
    {
      anvf.a(this.this$0, this.I, str);
      return;
    }
    anvf.a(this.this$0, this.I);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
 * JD-Core Version:    0.7.0.1
 */