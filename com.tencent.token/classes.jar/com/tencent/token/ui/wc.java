package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class wc
  implements View.OnClickListener
{
  wc(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity) {}
  
  public void onClick(View paramView)
  {
    if (RealNameStep0VerifyMobileDownActivity.access$1200(this.a) != null) {
      RealNameStep0VerifyMobileDownActivity.access$1200(this.a).clearFocus();
    }
    RealNameStep0VerifyMobileDownActivity.access$1300(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wc
 * JD-Core Version:    0.7.0.1
 */