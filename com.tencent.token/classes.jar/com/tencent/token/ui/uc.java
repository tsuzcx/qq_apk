package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.af;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class uc
  implements View.OnClickListener
{
  uc(ub paramub) {}
  
  public final void onClick(View paramView)
  {
    af.a().a(0L, ub.a(this.a).dguid, ub.a(this.a).ddes, ub.a(this.a).dappid, ub.a(this.a).dsubappid, ub.a(this.a).dappname, 71, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", PCMobileQQVerifyedDevicesActivity.access$200(this.a.a), PCMobileQQVerifyedDevicesActivity.access$000(this.a.a));
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uc
 * JD-Core Version:    0.7.0.1
 */