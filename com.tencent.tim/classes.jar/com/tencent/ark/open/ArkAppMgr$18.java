package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$18
  implements Runnable
{
  ArkAppMgr$18(ArkAppMgr paramArkAppMgr, ArkAppMgr.EnumInstalledAppTask paramEnumInstalledAppTask, ArkAppMgr.IEnumInstalledAppCallback paramIEnumInstalledAppCallback) {}
  
  public void run()
  {
    this.val$task.appNameList = ArkAppMgr.access$2500();
    ArkEnvironmentManager.getSharedPreferences("ArkAppUpdateRecord");
    ArkEnvironmentManager.getSharedPreferences("ArkAppUpdatePeriod");
    ArkEnvironmentManager.getSharedPreferences("ArkAppLastUsedTime");
    this.val$callback.onEnumInstalledApp(this.val$task.appNameList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.18
 * JD-Core Version:    0.7.0.1
 */