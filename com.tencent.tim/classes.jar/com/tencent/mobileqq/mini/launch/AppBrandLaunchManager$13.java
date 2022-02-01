package com.tencent.mobileqq.mini.launch;

import acfp;
import com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$13
  implements BaseLibManager.UpdateListener
{
  AppBrandLaunchManager$13(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onUpdateResult(int paramInt)
  {
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, acfp.m(2131702740));
      return;
    }
    String str = acfp.m(2131702737);
    if (paramInt == 1100) {
      str = acfp.m(2131702743);
    }
    for (;;)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, str);
      return;
      if (paramInt == 1101) {
        str = acfp.m(2131702746);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.13
 * JD-Core Version:    0.7.0.1
 */