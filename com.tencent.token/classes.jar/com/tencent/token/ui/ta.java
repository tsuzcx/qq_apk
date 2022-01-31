package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class ta
  implements View.OnClickListener
{
  ta(PCMobileQQVerifyedDevicesActivity paramPCMobileQQVerifyedDevicesActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if (paramView == null) {
      return;
    }
    cp localcp = cp.a(RqdApplication.l());
    byte[] arrayOfByte = localcp.b(do.a().e().mRealUin);
    h.a("mailprotect data=" + arrayOfByte);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (!localcp.b("" + paramView.mRealUin, 523005419L)))
    {
      PCMobileQQVerifyedDevicesActivity.access$002(this.a, w.a(arrayOfByte));
      PCMobileQQVerifyedDevicesActivity.access$100(this.a);
      return;
    }
    cp.a(RqdApplication.l()).a("" + paramView.mRealUin, PCMobileQQVerifyedDevicesActivity.access$200(this.a), 523005419L, 64);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ta
 * JD-Core Version:    0.7.0.1
 */