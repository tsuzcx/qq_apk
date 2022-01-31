package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;

final class qs
  implements View.OnClickListener
{
  qs(MyPswSubPageActivity paramMyPswSubPageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().e() == null)
    {
      this.a.showNoAccountTipDialog(this.a, 10, 0);
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 10, 1);
      return;
    }
    paramView = new Intent(this.a, ModifyQQPwdActivity.class);
    pv.a().a(this.a, paramView, pv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qs
 * JD-Core Version:    0.7.0.1
 */