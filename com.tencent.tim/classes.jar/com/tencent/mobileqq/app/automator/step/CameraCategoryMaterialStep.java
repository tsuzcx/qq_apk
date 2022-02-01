package com.tencent.mobileqq.app.automator.step;

import axbi;
import axcd;
import axce;
import axis;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private void FN(String paramString)
  {
    axis.a().ai("last_entry_version", paramString, 4);
  }
  
  private long eX()
  {
    return axis.a().b("lasttime", 0L, 0);
  }
  
  private void id(long paramLong)
  {
    axis.a().w("lasttime", paramLong, 0);
  }
  
  private String rQ()
  {
    return axis.a().t("last_entry_version", "", 4);
  }
  
  public int od()
  {
    axbi localaxbi = (axbi)this.a.app.getBusinessHandler(159);
    if (System.currentTimeMillis() - eX() > 86400000L)
    {
      id(System.currentTimeMillis());
      FN(AppSetting.nT());
      localaxbi.acl("MqStoryCamera");
      localaxbi.acl("MqEmoCamera");
      localaxbi.eIA();
      localaxbi.eIz();
      axce.a().a(axcd.c, null, false);
    }
    for (;;)
    {
      return super.od();
      if (!AppSetting.nT().equals(rQ()))
      {
        FN(AppSetting.nT());
        localaxbi.eIz();
        axce.a().a(axcd.c, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */