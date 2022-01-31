package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.p;

final class kt
  implements View.OnClickListener
{
  kt(FindPasswdActivity paramFindPasswdActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = FindPasswdActivity.access$600(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.showToast(2131362366);
      return;
    }
    p.a().a(System.currentTimeMillis(), 88);
    try
    {
      FindPasswdActivity.access$202(this.a, Long.parseLong(paramView));
      af.a().f(FindPasswdActivity.access$200(this.a), 5, FindPasswdActivity.access$100(this.a));
      return;
    }
    catch (Exception paramView)
    {
      this.a.showUserDialog(this.a.getResources().getString(2131362636));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kt
 * JD-Core Version:    0.7.0.1
 */