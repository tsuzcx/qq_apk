package com.tencent.token.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;

final class agd
  implements View.OnClickListener
{
  agd(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = VerifyMobilePhoneActivity.access$000(this.a).getText().toString();
    if (!TextUtils.isEmpty(paramView))
    {
      af.a().c(VerifyMobilePhoneActivity.access$100(this.a).mRealUin, 6, paramView, "", this.a.mHandler);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    }
    this.a.showUserDialog(2131361808, this.a.getString(2131361947), 2131361800, new age(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agd
 * JD-Core Version:    0.7.0.1
 */