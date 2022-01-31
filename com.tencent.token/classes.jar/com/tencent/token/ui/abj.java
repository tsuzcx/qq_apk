package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;

final class abj
  implements View.OnClickListener
{
  abj(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FindPasswdActivity.class);
    paramView.putExtra("not_showLockVerify", true);
    paramView.putExtra("real_uin", StartPwdGestureForgetActivity.access$400(this.a).mRealUin);
    paramView.putExtra("canchange_uin", false);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abj
 * JD-Core Version:    0.7.0.1
 */