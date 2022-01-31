package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.cw;

class adr
  implements View.OnClickListener
{
  adr(UtilsMbInfoItemActivity paramUtilsMbInfoItemActivity, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
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
      paramView.putExtra("title", this.d.getResources().getString(2131231428) + UtilsMbInfoItemActivity.access$300(this.d).mName);
      paramView.putExtra("op_type", 1);
      paramView.putExtra("position", UtilsMbInfoItemActivity.access$400(this.d));
      paramView.putExtra("page_id", UtilsMbInfoItemActivity.access$500(this.d));
      this.d.startActivity(paramView);
      return;
    } while (UtilsMbInfoItemActivity.access$300(this.d).mId != 51);
    paramView = new Intent(this.d, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("title", this.d.getResources().getString(2131231241) + UtilsMbInfoItemActivity.access$300(this.d).mName);
    paramView.putExtra("op_type", 3);
    paramView.putExtra("position", UtilsMbInfoItemActivity.access$400(this.d));
    paramView.putExtra("page_id", UtilsMbInfoItemActivity.access$500(this.d));
    pg.a().b(this.d, paramView, pg.b);
    return;
    paramView = this.d;
    String str = paramView.getResources().getString(2131231565) + this.c + UtilsMbInfoItemActivity.access$300(this.d).mName + "?";
    ads localads = new ads(this, paramView);
    adt localadt = new adt(this, paramView);
    paramView.showUserDialog(2131230843, str, this.d.getResources().getString(2131231526) + this.c, this.d.getResources().getString(2131230886), localads, localadt);
    return;
    this.d.gotoVerify(this.d);
    return;
    cw.a().i(0L, UtilsMbInfoItemActivity.access$600(this.d));
    this.d.showProDialog(this.d, 2131230843, 2131231567, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adr
 * JD-Core Version:    0.7.0.1
 */