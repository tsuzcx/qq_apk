package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;

class km
  implements View.OnClickListener
{
  km(GeneralVerifyMobileUpActivity paramGeneralVerifyMobileUpActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.sendUpSmsBySMSAPP(GeneralVerifyMobileUpActivity.access$500(this.a).e(), GeneralVerifyMobileUpActivity.access$500(this.a).d());
    this.a.showProgressDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.km
 * JD-Core Version:    0.7.0.1
 */