package com.tencent.mobileqq.activity.contacts.phone;

import android.os.Handler;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactFragment$3
  implements Runnable
{
  PhoneContactFragment$3(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContactFragment", 2, "reset data");
    }
    if (this.this$0.a != null) {
      this.this$0.a.bu(PhoneContactFragment.f(this.this$0));
    }
    this.this$0.mHandler.removeCallbacks(PhoneContactFragment.a(this.this$0));
    this.this$0.mHandler.post(PhoneContactFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.3
 * JD-Core Version:    0.7.0.1
 */