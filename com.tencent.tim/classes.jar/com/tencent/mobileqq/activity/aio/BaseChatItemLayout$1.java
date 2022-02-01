package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class BaseChatItemLayout$1
  implements Runnable
{
  BaseChatItemLayout$1(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout.LayoutParams paramLayoutParams, ImageView paramImageView) {}
  
  public void run()
  {
    this.v.addRule(15, 0);
    this.v.topMargin = (this.this$0.wb.getTop() + (this.this$0.wb.getHeight() - BaseChatItemLayout.bOD) / 2);
    this.se.setLayoutParams(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout.1
 * JD-Core Version:    0.7.0.1
 */