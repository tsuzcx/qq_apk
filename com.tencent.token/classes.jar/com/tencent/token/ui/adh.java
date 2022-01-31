package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.w;

class adh
  implements View.OnClickListener
{
  adh(adg paramadg) {}
  
  public void onClick(View paramView)
  {
    cw.a().a(0L, adg.a(this.a).dguid, adg.a(this.a).ddes, adg.a(this.a).dappid, adg.a(this.a).dsubappid, adg.a(this.a).dappname, 70, w.a(cp.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", UtilsMailProtectActivity.access$400(this.a.a), UtilsMailProtectActivity.access$500(this.a.a));
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adh
 * JD-Core Version:    0.7.0.1
 */