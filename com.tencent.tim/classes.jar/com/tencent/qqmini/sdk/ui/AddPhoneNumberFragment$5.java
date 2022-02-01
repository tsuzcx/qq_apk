package com.tencent.qqmini.sdk.ui;

import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AddPhoneNumberFragment$5
  implements TextWatcher
{
  AddPhoneNumberFragment$5(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AddPhoneNumberFragment.access$100(this.this$0).removeCallbacks(AddPhoneNumberFragment.access$500(this.this$0));
    AddPhoneNumberFragment.access$000(this.this$0).setText("获取验证码");
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      AddPhoneNumberFragment.access$202(this.this$0, paramEditable.toString());
      AddPhoneNumberFragment.access$000(this.this$0).setEnabled(true);
      AddPhoneNumberFragment.access$000(this.this$0).setClickable(true);
      AddPhoneNumberFragment.access$000(this.this$0).setTextColor(Color.parseColor("#181819"));
    }
    for (;;)
    {
      QMLog.i("AddPhoneNumberFragment", "mPhoneNumber : " + AddPhoneNumberFragment.access$200(this.this$0));
      return;
      AddPhoneNumberFragment.access$202(this.this$0, null);
      AddPhoneNumberFragment.access$000(this.this$0).setEnabled(false);
      AddPhoneNumberFragment.access$000(this.this$0).setClickable(false);
      AddPhoneNumberFragment.access$000(this.this$0).setTextColor(Color.parseColor("#B0B3BF"));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.5
 * JD-Core Version:    0.7.0.1
 */