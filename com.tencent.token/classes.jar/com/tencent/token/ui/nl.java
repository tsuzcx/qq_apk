package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class nl
  implements View.OnClickListener
{
  nl(LoginMsgChangePwdActivity paramLoginMsgChangePwdActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ModifyQQPwdActivity.class);
    paramView.putExtra("page_id", 2);
    pg.a().a(this.a, paramView, pg.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nl
 * JD-Core Version:    0.7.0.1
 */