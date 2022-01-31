package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class wt
  implements View.OnClickListener
{
  wt(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = RealNameStep0VerifyMobileDownActivity.access$1600(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0)) {
      this.a.showToast(2131361948);
    }
    while (RealNameStep0VerifyMobileDownActivity.access$1300(this.a)) {
      return;
    }
    this.a.showProDialog(this.a, 2131361808, 2131361817, null);
    RealNameStep0VerifyMobileDownActivity.access$1700(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wt
 * JD-Core Version:    0.7.0.1
 */