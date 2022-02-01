package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.widget.QQToast;

class AppBrandLaunchManager$6
  implements Runnable
{
  AppBrandLaunchManager$6(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void run()
  {
    QQToast.a(AppBrandLaunchManager.access$100(this.this$0), GameWnsUtils.gameDisableHint(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.6
 * JD-Core Version:    0.7.0.1
 */