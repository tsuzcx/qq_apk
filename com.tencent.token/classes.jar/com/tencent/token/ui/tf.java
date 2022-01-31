package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.p;

final class tf
  implements View.OnClickListener
{
  tf(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    p.a().a(System.currentTimeMillis(), 64);
    paramView = new Intent(this.a, LoginMsgChangePwdActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tf
 * JD-Core Version:    0.7.0.1
 */