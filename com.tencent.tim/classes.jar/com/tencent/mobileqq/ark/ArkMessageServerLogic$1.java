package com.tencent.mobileqq.ark;

import adrc;
import adrj.a;
import adrk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ArkMessageServerLogic$1
  implements Runnable
{
  public ArkMessageServerLogic$1(adrj.a parama) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject == null) {
      ArkAppCenter.r("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, qq app is null");
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.ch(null);
      }
      do
      {
        return;
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
        if (localObject == null)
        {
          ArkAppCenter.r("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark center is null");
          break;
        }
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject == null)
        {
          ArkAppCenter.r("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark sso is null");
          break;
        }
      } while (((adrc)localObject).a("ArkAppPanel.List", 10000, 0, new adrk(this)));
      ArkAppCenter.r("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic.1
 * JD-Core Version:    0.7.0.1
 */