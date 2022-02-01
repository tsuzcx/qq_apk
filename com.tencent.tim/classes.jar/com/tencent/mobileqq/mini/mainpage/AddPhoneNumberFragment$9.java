package com.tencent.mobileqq.mini.mainpage;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Button;

class AddPhoneNumberFragment$9
  implements Runnable
{
  AddPhoneNumberFragment$9(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void run()
  {
    if (AddPhoneNumberFragment.mSecond <= 1)
    {
      AddPhoneNumberFragment.access$600(this.this$0).setText("获取验证码");
      AddPhoneNumberFragment.access$600(this.this$0).setTextColor(Color.parseColor("#181819"));
      AddPhoneNumberFragment.access$600(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$600(this.this$0).setClickable(true);
      return;
    }
    AddPhoneNumberFragment.mSecond -= 1;
    AddPhoneNumberFragment.access$600(this.this$0).setClickable(false);
    AddPhoneNumberFragment.access$600(this.this$0).setText("有效期(" + AddPhoneNumberFragment.mSecond + ")");
    AddPhoneNumberFragment.access$500(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.9
 * JD-Core Version:    0.7.0.1
 */