package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.ch;
import com.tencent.token.cw;

class jo
  implements View.OnClickListener
{
  jo(FindPasswdActivity paramFindPasswdActivity) {}
  
  public void onClick(View paramView)
  {
    if (FindPasswdActivity.access$400(this.a) != null) {
      FindPasswdActivity.access$400(this.a).clearFocus();
    }
    paramView = FindPasswdActivity.access$400(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.showToast(2131231655);
      return;
    }
    ch.a().a(System.currentTimeMillis(), 88);
    try
    {
      FindPasswdActivity.access$102(this.a, Long.parseLong(paramView));
      cw.a().d(FindPasswdActivity.access$100(this.a), 5, FindPasswdActivity.access$200(this.a));
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    catch (Exception paramView)
    {
      this.a.showUserDialog(this.a.getResources().getString(2131231503));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jo
 * JD-Core Version:    0.7.0.1
 */