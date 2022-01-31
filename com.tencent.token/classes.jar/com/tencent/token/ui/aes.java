package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class aes
  implements View.OnClickListener
{
  aes(aer paramaer) {}
  
  public final void onClick(View paramView)
  {
    af.a().a(0L, aer.a(this.a).dguid, aer.a(this.a).ddes, aer.a(this.a).dappid, aer.a(this.a).dsubappid, aer.a(this.a).dappname, 70, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", UtilsMailProtectActivity.access$400(this.a.a), UtilsMailProtectActivity.access$000(this.a.a));
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aes
 * JD-Core Version:    0.7.0.1
 */