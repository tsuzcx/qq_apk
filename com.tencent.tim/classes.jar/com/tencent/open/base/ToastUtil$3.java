package com.tencent.open.base;

import android.view.View;
import android.widget.Toast;
import aroi;
import arxa;

public class ToastUtil$3
  implements Runnable
{
  public ToastUtil$3(arxa paramarxa, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.g == null)
    {
      this.this$0.g = new Toast(aroi.a().getContext());
      this.this$0.g.setView(this.val$view);
      this.this$0.g.setDuration(this.val$duration);
      this.this$0.g.show();
      return;
    }
    this.this$0.g.setView(this.val$view);
    this.this$0.g.setDuration(this.val$duration);
    this.this$0.g.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.3
 * JD-Core Version:    0.7.0.1
 */