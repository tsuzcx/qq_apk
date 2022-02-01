package com.tencent.mobileqq.activity.phone;

import android.graphics.Bitmap;
import android.widget.ImageView;

class PhoneContactStatusCheckView$1$1
  implements Runnable
{
  PhoneContactStatusCheckView$1$1(PhoneContactStatusCheckView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((PhoneContactStatusCheckView.a(this.a.this$0) != null) && (this.val$bmp != null)) {
      PhoneContactStatusCheckView.a(this.a.this$0).setImageBitmap(this.val$bmp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView.1.1
 * JD-Core Version:    0.7.0.1
 */