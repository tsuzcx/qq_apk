package com.tencent.mobileqq.mini.mainpage;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class AddPhoneNumberFragment$7
  implements TextWatcher
{
  AddPhoneNumberFragment$7(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      AddPhoneNumberFragment.access$1002(this.this$0, paramEditable.toString());
      AddPhoneNumberFragment.access$1100(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$1100(this.this$0).setClickable(true);
      AddPhoneNumberFragment.access$1100(this.this$0).setTextColor(-1);
    }
    for (;;)
    {
      QLog.d("AddPhoneNumberFragment", 1, "mSmsCode : " + AddPhoneNumberFragment.access$1000(this.this$0));
      return;
      AddPhoneNumberFragment.access$1002(this.this$0, null);
      AddPhoneNumberFragment.access$1100(this.this$0).setEnabled(false);
      AddPhoneNumberFragment.access$1100(this.this$0).setClickable(false);
      AddPhoneNumberFragment.access$1100(this.this$0).setTextColor(Color.parseColor("#3303081A"));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.7
 * JD-Core Version:    0.7.0.1
 */