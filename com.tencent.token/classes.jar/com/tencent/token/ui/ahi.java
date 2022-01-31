package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.utils.t;
import com.tencent.token.x;

final class ahi
  implements View.OnClickListener
{
  ahi(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public final void onClick(View paramView)
  {
    paramView = WtLoginAccountInput.access$100(this.a).getText().toString();
    if ((paramView == null) || (paramView.length() == 0))
    {
      this.a.showToast(2131362366);
      return;
    }
    try
    {
      WtLoginAccountInput.access$602(this.a, Long.parseLong(paramView));
      WtLoginAccountInput.access$202(this.a, WtLoginAccountInput.access$1600(this.a).getText().toString());
      if ((WtLoginAccountInput.access$200(this.a) == null) || (WtLoginAccountInput.access$200(this.a).length() == 0))
      {
        this.a.showToast(2131362367);
        return;
      }
    }
    catch (Exception paramView)
    {
      this.a.showUserDialog(this.a.getResources().getString(2131362636));
      return;
    }
    t.a(this.a);
    if (ag.c().g()) {
      af.a().a(WtLoginAccountInput.access$000(this.a));
    }
    for (;;)
    {
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
      if ((WtLoginAccountInput.access$700(this.a).d() >= 3) && (WtLoginAccountInput.access$700(this.a).d(WtLoginAccountInput.access$600(this.a)) == null))
      {
        this.a.showUserDialog(2131362104, this.a.getResources().getString(2131362550), 2131361800, null);
        return;
      }
      WtLoginAccountInput.access$400(this.a).b(paramView, WtLoginAccountInput.access$200(this.a), WtLoginAccountInput.access$000(this.a), WtLoginAccountInput.access$300(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahi
 * JD-Core Version:    0.7.0.1
 */