package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aet
  implements View.OnClickListener
{
  aet(VerifyMobilePhoneActivity paramVerifyMobilePhoneActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", VerifyMobilePhoneActivity.access$100(this.a));
    paramView.putExtra("intent.determin_factors_result", VerifyMobilePhoneActivity.access$300(this.a));
    paramView.putExtra("intent.determin_verify_type", VerifyMobilePhoneActivity.access$200(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aet
 * JD-Core Version:    0.7.0.1
 */