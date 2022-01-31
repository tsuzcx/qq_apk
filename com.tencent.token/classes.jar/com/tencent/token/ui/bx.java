package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.s;

final class bx
  implements View.OnClickListener
{
  bx(CheckMobileAvailableActivity paramCheckMobileAvailableActivity) {}
  
  public final void onClick(View paramView)
  {
    if ((CheckMobileAvailableActivity.access$200(this.a) == 0) || (CheckMobileAvailableActivity.access$200(this.a) == 7)) {
      s.a(this.a, this.a.getResources().getString(2131361883), this.a.getResources().getString(2131362363));
    }
    do
    {
      return;
      if (CheckMobileAvailableActivity.access$200(this.a) == 5)
      {
        af.a().e(s.f(CheckMobileAvailableActivity.access$800(this.a)), CheckMobileAvailableActivity.access$900(this.a));
        this.a.showUserDialog(12);
        return;
      }
    } while (CheckMobileAvailableActivity.access$200(this.a) != 6);
    af.a().e(CheckMobileAvailableActivity.access$600(this.a).mUin, CheckMobileAvailableActivity.access$900(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bx
 * JD-Core Version:    0.7.0.1
 */