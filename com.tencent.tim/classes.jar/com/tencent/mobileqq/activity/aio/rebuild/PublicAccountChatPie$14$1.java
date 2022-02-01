package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.widget.RelativeLayout;
import ycd;
import ycj;

public class PublicAccountChatPie$14$1
  implements Runnable
{
  public PublicAccountChatPie$14$1(ycj paramycj) {}
  
  public void run()
  {
    if (this.a.this$0.xt != null) {
      this.a.this$0.xt.clearAnimation();
    }
    ycd.d(this.a.this$0).removeView(this.a.this$0.xt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.14.1
 * JD-Core Version:    0.7.0.1
 */