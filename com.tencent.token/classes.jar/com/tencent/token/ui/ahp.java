package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class ahp
  implements View.OnClickListener
{
  ahp(WtloginSigExpireActivity paramWtloginSigExpireActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FindPasswdActivity.class);
    paramView.putExtra("real_uin", WtloginSigExpireActivity.access$200(this.a));
    paramView.putExtra("canchange_uin", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahp
 * JD-Core Version:    0.7.0.1
 */