package com.tencent.mobileqq.app;

import accy;
import aqap;
import aqma;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;

public class ConfigHandler$11
  implements Runnable
{
  public ConfigHandler$11(accy paramaccy) {}
  
  public void run()
  {
    Object localObject = aqap.a().b();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).a == null)) {
      return;
    }
    boolean bool = aqma.aEW();
    int i = aqma.Mb();
    int j = ((UpgradeDetailWrapper)localObject).a.dYn;
    if ((bool) && (j == i)) {}
    for (i = 1;; i = 0)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i != 0) {
        break;
      }
      aqap.a().ac((QQAppInterface)localObject, true);
      aqma.XB(j);
      aqma.SK(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.11
 * JD-Core Version:    0.7.0.1
 */