package com.tencent.mobileqq.ark.API;

import adnq.c;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;
import wyw;

public class ArkAppModuleReg$ModuleQQ$16
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$16(adnq.c paramc, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.Vp);
    if (localObject == null) {}
    ArkFullScreenAppActivity localArkFullScreenAppActivity;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity));
        localArkFullScreenAppActivity = (ArkFullScreenAppActivity)BaseActivity.sTopActivity;
        localObject = wyw.a((ark.Container)localObject);
      } while (localObject == null);
      localObject = (wyw)((WeakReference)localObject).get();
    } while (localObject == null);
    localArkFullScreenAppActivity.a((wyw)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.16
 * JD-Core Version:    0.7.0.1
 */