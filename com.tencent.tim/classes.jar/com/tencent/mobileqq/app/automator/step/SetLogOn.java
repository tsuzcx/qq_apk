package com.tencent.mobileqq.app.automator.step;

import aivn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.manager.ServerConfigManager.ConfigType;

public class SetLogOn
  extends AsyncStep
{
  public int od()
  {
    String str = this.a.app.a(ServerConfigManager.ConfigType.common, "QQIniUrl");
    if ((str != null) && (str.length() > 0)) {
      aivn.bPC = str.trim();
    }
    aivn.E(this.a.app.getApp(), true);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SetLogOn
 * JD-Core Version:    0.7.0.1
 */