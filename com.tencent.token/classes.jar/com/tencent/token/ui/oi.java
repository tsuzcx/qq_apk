package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class oi
  implements View.OnClickListener
{
  oi(LoginMsgChangePwdActivity paramLoginMsgChangePwdActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, ModifyQQPwdActivity.class);
    paramView.putExtra("page_id", 2);
    pv.a().a(this.a, paramView, pv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.oi
 * JD-Core Version:    0.7.0.1
 */