package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;

class afw
  implements View.OnClickListener
{
  afw(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public void onClick(View paramView)
  {
    WtLoginAccountInput.access$602(this.a, true);
    if (cx.c().g())
    {
      cw.a().a(WtLoginAccountInput.access$500(this.a));
      return;
    }
    if ((do.a().d() >= 3) && (do.a().d(WtLoginAccountInput.access$700(this.a)) == null))
    {
      this.a.showUserDialog(2131230935, this.a.getResources().getString(2131230877), 2131230897, null);
      return;
    }
    cp.a(this.a.getApplicationContext()).a(this.a, 523005419L, WtLoginAccountInput.access$500(this.a));
    this.a.showProDialog(this.a, 2131230843, 2131231298, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afw
 * JD-Core Version:    0.7.0.1
 */