package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.x;

final class ty
  extends bo
{
  ty(PCMobileQQVerifyedDevicesActivity paramPCMobileQQVerifyedDevicesActivity)
  {
    super(paramPCMobileQQVerifyedDevicesActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {}
    do
    {
      return;
      int i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3054: 
        if (paramMessage.arg1 == 0)
        {
          PCMobileQQVerifyedDevicesActivity.access$400(this.a).setVisibility(0);
          PCMobileQQVerifyedDevicesActivity.access$500(this.a).setVisibility(8);
          PCMobileQQVerifyedDevicesActivity.access$600(this.a);
          return;
        }
      case 4097: 
      case 4098: 
        byte[] arrayOfByte = (byte[])paramMessage.obj;
        if ((i == 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          PCMobileQQVerifyedDevicesActivity.access$202(this.a, s.a(arrayOfByte));
          PCMobileQQVerifyedDevicesActivity.access$300(this.a);
          return;
        }
        if (i == -1000)
        {
          this.a.dismissDialog();
          this.a.showToast(2131361943);
          return;
        }
        if (i == 8192)
        {
          this.a.dismissDialog();
          this.a.showToast(2131362089);
          return;
        }
        if ((i == 1) || (i == 15) || (i == 16) || (i == 2))
        {
          this.a.dismissDialog();
          this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new tz(this));
          return;
        }
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("loginerror") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("loginerror"));
          return;
        }
        this.a.showToast(2131362091);
        return;
      case 4104: 
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131362091) + ":" + paramMessage.getData().getString("exception"));
          return;
        }
        this.a.showToast(2131362091);
        return;
        if ((111 == paramMessage.arg1) || (110 == paramMessage.arg1) || (103 == paramMessage.arg1))
        {
          PCMobileQQVerifyedDevicesActivity.access$900(this.a, paramMessage.arg1, PCMobileQQVerifyedDevicesActivity.access$700(this.a), PCMobileQQVerifyedDevicesActivity.access$800(this.a), true);
          return;
        }
        if (185 != paramMessage.arg1) {
          break label559;
        }
      }
    } while (ax.a().e() == null);
    x.a(RqdApplication.i()).a(this.a, "" + ax.a().e().mRealUin, PCMobileQQVerifyedDevicesActivity.access$000(this.a), true);
    return;
    label559:
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    e.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
    PCMobileQQVerifyedDevicesActivity.access$900(this.a, paramMessage.a, paramMessage.c, null, false);
    return;
    if (paramMessage.arg1 == 0)
    {
      PCMobileQQVerifyedDevicesActivity.access$300(this.a);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    d.a(this.a.getResources(), paramMessage);
    PCMobileQQVerifyedDevicesActivity.access$1000(this.a, paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ty
 * JD-Core Version:    0.7.0.1
 */