package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.utils.w;

class cj
  implements View.OnClickListener
{
  cj(CheckMobileAvailableActivity paramCheckMobileAvailableActivity) {}
  
  public void onClick(View paramView)
  {
    if ((CheckMobileAvailableActivity.access$200(this.a) == 0) || (CheckMobileAvailableActivity.access$200(this.a) == 7)) {
      w.a(this.a, this.a.getResources().getString(2131230861), this.a.getResources().getString(2131231657));
    }
    do
    {
      return;
      if (CheckMobileAvailableActivity.access$200(this.a) == 5)
      {
        cw.a().e(w.f(CheckMobileAvailableActivity.access$800(this.a)), CheckMobileAvailableActivity.access$900(this.a));
        this.a.showUserDialog(12);
        return;
      }
    } while (CheckMobileAvailableActivity.access$200(this.a) != 6);
    cw.a().e(CheckMobileAvailableActivity.access$600(this.a).mUin, CheckMobileAvailableActivity.access$900(this.a));
    this.a.showUserDialog(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cj
 * JD-Core Version:    0.7.0.1
 */