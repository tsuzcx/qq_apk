package com.tencent.mobileqq.activity.contact.phonecontact;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$24$1
  implements Runnable
{
  PhoneContactManagerImp$24$1(PhoneContactManagerImp.24 param24, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$bitmap != null) {
      this.this$0.val$imageView.setImageBitmap(this.val$bitmap);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "loadIconAsync end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.24.1
 * JD-Core Version:    0.7.0.1
 */