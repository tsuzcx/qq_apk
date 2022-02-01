package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import acfd;
import alip;
import anel;
import aokl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetGeneralSettings
  extends AsyncStep
{
  private acfd l;
  
  public int od()
  {
    if (this.a.cyz == 1) {}
    for (boolean bool = true; bool; bool = false)
    {
      if (this.l == null)
      {
        this.l = new a(null);
        this.a.app.addObserver(this.l, true);
      }
      if (!this.a.app.aP(bool)) {
        break;
      }
      return 2;
    }
    synchronized (aokl.a().fg)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = aokl.a().a();
      if (localFileStoragePushFSSvcList != null)
      {
        anel.b(localFileStoragePushFSSvcList, this.a.app);
        aokl.a().c(null);
      }
      alip.a(this.a.app).cn(true, true);
      return 7;
    }
  }
  
  public void onDestroy()
  {
    if (this.l != null)
    {
      this.a.app.removeObserver(this.l);
      this.l = null;
    }
  }
  
  class a
    extends acfd
  {
    private a() {}
    
    public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        GetGeneralSettings.this.a.cyz = 3;
        GetGeneralSettings.this.setResult(7);
        return;
      }
      GetGeneralSettings.this.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */