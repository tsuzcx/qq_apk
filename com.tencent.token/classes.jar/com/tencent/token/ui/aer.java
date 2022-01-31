package com.tencent.token.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;

class aer
  implements View.OnClickListener
{
  aer(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity) {}
  
  public void onClick(View paramView)
  {
    if (VerifyMobilePhoneActivity.access$000(this.a) != null) {
      VerifyMobilePhoneActivity.access$000(this.a).clearFocus();
    }
    paramView = VerifyMobilePhoneActivity.access$000(this.a).getText().toString();
    if (!TextUtils.isEmpty(paramView))
    {
      cw.a().b(VerifyMobilePhoneActivity.access$100(this.a).b(), paramView, VerifyMobilePhoneActivity.access$200(this.a).a(), this.a.mHandler);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    this.a.showUserDialog(2131230843, this.a.getString(2131230957), 2131230897, new aes(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aer
 * JD-Core Version:    0.7.0.1
 */