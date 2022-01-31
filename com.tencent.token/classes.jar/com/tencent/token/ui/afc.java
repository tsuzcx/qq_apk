package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;

final class afc
  implements View.OnClickListener
{
  afc(UtilsMbInfoItemActivity paramUtilsMbInfoItemActivity, boolean paramBoolean, int paramInt, String paramString) {}
  
  public final void onClick(View paramView)
  {
    if (UtilsMbInfoItemActivity.access$300(this.d) == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.a);
        switch (this.b)
        {
        default: 
          return;
        }
      } while (UtilsMbInfoItemActivity.access$300(this.d).mId != 51);
      paramView = new Intent(this.d, UtilsModSetMobileStep1Activity.class);
      paramView.putExtra("title", this.d.getResources().getString(2131361814) + UtilsMbInfoItemActivity.access$300(this.d).mName);
      paramView.putExtra("op_type", 1);
      paramView.putExtra("position", UtilsMbInfoItemActivity.access$400(this.d));
      this.d.startActivity(paramView);
      return;
    } while (UtilsMbInfoItemActivity.access$300(this.d).mId != 51);
    paramView = new Intent(this.d, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("title", this.d.getResources().getString(2131361815) + UtilsMbInfoItemActivity.access$300(this.d).mName);
    paramView.putExtra("op_type", 3);
    paramView.putExtra("position", UtilsMbInfoItemActivity.access$400(this.d));
    this.d.startActivity(paramView);
    return;
    paramView = this.d;
    String str = paramView.getResources().getString(2131362204) + this.c + UtilsMbInfoItemActivity.access$300(this.d).mName + "?";
    afd localafd = new afd(this, paramView);
    afe localafe = new afe(this, paramView);
    paramView.showUserDialog(2131361808, str, this.d.getResources().getString(2131362205) + this.c, this.d.getResources().getString(2131361804), localafd, localafe);
    return;
    this.d.gotoVerify(this.d);
    return;
    af.a().i(0L, UtilsMbInfoItemActivity.access$500(this.d));
    this.d.showProDialog(this.d, 2131361808, 2131362206, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afc
 * JD-Core Version:    0.7.0.1
 */