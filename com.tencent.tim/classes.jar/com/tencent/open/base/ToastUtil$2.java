package com.tencent.open.base;

import android.widget.Toast;
import aroi;
import arxa;

public class ToastUtil$2
  implements Runnable
{
  public ToastUtil$2(arxa paramarxa, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.f == null)
    {
      this.this$0.f = Toast.makeText(aroi.a().getContext(), this.ele, this.val$duration);
      this.this$0.f.show();
      return;
    }
    this.this$0.f.setText(this.ele);
    this.this$0.f.setDuration(this.val$duration);
    this.this$0.f.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.2
 * JD-Core Version:    0.7.0.1
 */