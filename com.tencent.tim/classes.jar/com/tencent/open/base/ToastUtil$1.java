package com.tencent.open.base;

import android.widget.Toast;
import aroi;
import arxa;

public class ToastUtil$1
  implements Runnable
{
  public ToastUtil$1(arxa paramarxa, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.f == null)
    {
      this.this$0.f = Toast.makeText(aroi.a().getContext(), this.val$tips, this.val$duration);
      this.this$0.f.show();
      return;
    }
    this.this$0.f.setText(this.val$tips);
    this.this$0.f.setDuration(this.val$duration);
    this.this$0.f.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.1
 * JD-Core Version:    0.7.0.1
 */