package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class wd
  implements View.OnClickListener
{
  wd(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity) {}
  
  public void onClick(View paramView)
  {
    if (RealNameStep0VerifyMobileDownActivity.access$1200(this.a) != null) {
      RealNameStep0VerifyMobileDownActivity.access$1200(this.a).clearFocus();
    }
    paramView = RealNameStep0VerifyMobileDownActivity.access$1200(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0)) {
      this.a.showToast(2131230959);
    }
    while (RealNameStep0VerifyMobileDownActivity.access$900(this.a)) {
      return;
    }
    this.a.showProDialog(this.a, 2131230843, 2131231298, null);
    RealNameStep0VerifyMobileDownActivity.access$1400(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wd
 * JD-Core Version:    0.7.0.1
 */