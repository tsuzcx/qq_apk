package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class tc
  extends cb
{
  tc(PCMobileQQVerifyedDevicesActivity paramPCMobileQQVerifyedDevicesActivity)
  {
    super(paramPCMobileQQVerifyedDevicesActivity);
  }
  
  public void handleMessage(Message paramMessage)
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
          PCMobileQQVerifyedDevicesActivity.access$700(this.a).setVisibility(0);
          PCMobileQQVerifyedDevicesActivity.access$800(this.a).setVisibility(8);
          PCMobileQQVerifyedDevicesActivity.access$900(this.a);
          return;
        }
      case 4097: 
      case 4098: 
        byte[] arrayOfByte = (byte[])paramMessage.obj;
        if ((i == 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          PCMobileQQVerifyedDevicesActivity.access$002(this.a, w.a(arrayOfByte));
          PCMobileQQVerifyedDevicesActivity.access$100(this.a);
          return;
        }
        if (i == -1000)
        {
          this.a.showUserDialog(this.a.getResources().getString(2131230960));
          PCMobileQQVerifyedDevicesActivity.access$400(this.a, i);
          return;
        }
        if (i == 8192)
        {
          this.a.showUserDialog(this.a.getResources().getString(2131231407));
          PCMobileQQVerifyedDevicesActivity.access$400(this.a, i);
          return;
        }
        if ((i == 40) || (i == 42) || (i == 64))
        {
          this.a.dismissDialog();
          this.a.goToRemoveProtectH5(this.a, paramMessage, i);
          PCMobileQQVerifyedDevicesActivity.access$400(this.a, i);
          return;
        }
        this.a.dismissDialog();
        this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new td(this));
        PCMobileQQVerifyedDevicesActivity.access$400(this.a, i);
        return;
      case 4109: 
        paramMessage = paramMessage.getData();
        if (paramMessage != null)
        {
          paramMessage = paramMessage.getByteArray("sig");
          PCMobileQQVerifyedDevicesActivity.access$002(this.a, w.a(paramMessage));
        }
        PCMobileQQVerifyedDevicesActivity.access$600(this.a);
        return;
      case 4104: 
        this.a.dismissDialog();
        if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
        {
          this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
          return;
        }
        this.a.showToast(2131231411);
        return;
        if (185 != paramMessage.arg1) {
          break label524;
        }
      }
    } while (do.a().e() == null);
    paramMessage = do.a().e();
    cp.a(RqdApplication.l()).a("" + paramMessage.mRealUin, PCMobileQQVerifyedDevicesActivity.access$200(this.a), 523005419L, 64);
    return;
    label524:
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    h.c("mailprotect load failed:" + paramMessage.a + "-" + paramMessage.b);
    this.a.showUserDialog(paramMessage.c);
    PCMobileQQVerifyedDevicesActivity.access$400(this.a, paramMessage.a);
    return;
    if (paramMessage.arg1 == 0)
    {
      PCMobileQQVerifyedDevicesActivity.access$100(this.a);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tc
 * JD-Core Version:    0.7.0.1
 */