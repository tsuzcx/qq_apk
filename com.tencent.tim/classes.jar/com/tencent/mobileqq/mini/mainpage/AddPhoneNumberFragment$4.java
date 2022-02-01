package com.tencent.mobileqq.mini.mainpage;

import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class AddPhoneNumberFragment$4
  implements TextWatcher
{
  AddPhoneNumberFragment$4(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AddPhoneNumberFragment.access$500(this.this$0).removeCallbacks(AddPhoneNumberFragment.access$400(this.this$0));
    AddPhoneNumberFragment.access$600(this.this$0).setText("获取验证码");
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      AddPhoneNumberFragment.access$002(this.this$0, paramEditable.toString());
      AddPhoneNumberFragment.access$600(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$600(this.this$0).setClickable(true);
      AddPhoneNumberFragment.access$600(this.this$0).setTextColor(Color.parseColor("#181819"));
    }
    for (;;)
    {
      QLog.i("AddPhoneNumberFragment", 2, "mPhoneNumber : " + AddPhoneNumberFragment.access$000(this.this$0));
      return;
      AddPhoneNumberFragment.access$002(this.this$0, null);
      AddPhoneNumberFragment.access$600(this.this$0).setEnabled(false);
      AddPhoneNumberFragment.access$600(this.this$0).setClickable(false);
      AddPhoneNumberFragment.access$600(this.this$0).setTextColor(Color.parseColor("#B0B3BF"));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.4
 * JD-Core Version:    0.7.0.1
 */