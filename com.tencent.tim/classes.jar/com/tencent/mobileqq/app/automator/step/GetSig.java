package com.tencent.mobileqq.app.automator.step;

import achq;
import aclo;
import android.os.Bundle;
import anot;
import avhp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class GetSig
  extends AsyncStep
{
  private achq j;
  
  private void cND()
  {
    ToServiceMsg localToServiceMsg = this.a.createToServiceMsg("TransService.ReqGetSign");
    localToServiceMsg.extraData.putInt("ssover", 1);
    localToServiceMsg.extraData.putInt("app_id", AppSetting.getAppId());
    localToServiceMsg.extraData.putByte("a2type", (byte)4);
    localToServiceMsg.extraData.putByteArray("enkey", this.a.app.getUinSign());
    this.a.send(localToServiceMsg);
  }
  
  public int od()
  {
    if (this.j == null)
    {
      this.j = new a(null);
      this.a.app.addDefaultObservers(this.j);
    }
    cND();
    return 2;
  }
  
  public void onCreate()
  {
    ((aclo)this.a.app.getBusinessHandler(18)).cMr();
    anot.h(this.a.app, true);
    avhp.erH();
  }
  
  public void onDestroy()
  {
    if (this.j != null)
    {
      this.a.app.removeObserver(this.j);
      this.j = null;
    }
  }
  
  class a
    extends achq
  {
    private a() {}
    
    public void Fo(boolean paramBoolean)
    {
      GetSig localGetSig = GetSig.this;
      if (paramBoolean) {}
      for (int i = 7;; i = 6)
      {
        localGetSig.setResult(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSig
 * JD-Core Version:    0.7.0.1
 */