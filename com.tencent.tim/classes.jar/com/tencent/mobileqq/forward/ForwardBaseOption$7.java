package com.tencent.mobileqq.forward;

import ahgq;
import android.graphics.drawable.Drawable;
import aqju;

public class ForwardBaseOption$7
  implements Runnable
{
  public ForwardBaseOption$7(ahgq paramahgq, Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.e.isShowing())
    {
      this.this$0.e.setPreviewImage(this.val$d, this.cgU, this.val$num, this.cgV);
      this.this$0.dnP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.7
 * JD-Core Version:    0.7.0.1
 */