package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.HashMap;

class ArkAppMgr$3$1
  implements Runnable
{
  ArkAppMgr$3$1(ArkAppMgr.3 param3, ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask) {}
  
  public void run()
  {
    int i = this.val$updateTask.retCode;
    ??? = this.val$updateTask.errMsg;
    if (i == 0) {
      if (ArkAppMgr.access$300(this.val$updateTask.appPathInfo.desc.version, this.val$getPathTask.minAppVersion) >= 0) {
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.updateAppByName success, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkAppMgr.UpdateAppByNameTask.Result.toString(this.val$updateTask.result), this.val$updateTask.appName, this.val$getPathTask.minAppVersion, this.val$updateTask.appPathInfo.desc.version }));
      }
    }
    for (;;)
    {
      this.val$getPathTask.retCode = i;
      this.val$getPathTask.errMsg = ((String)???);
      if (i == 0)
      {
        this.val$getPathTask.appPathInfo = this.val$updateTask.appPathInfo;
        if (this.val$getPathTask.appPathInfo.appTempInfo == null) {
          ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateAppByName cache app=%s", new Object[] { this.val$getPathTask.appName }));
        }
      }
      synchronized (ArkAppMgr.access$400(this.this$1.this$0))
      {
        ArkAppMgr.access$400(this.this$1.this$0).put(this.val$getPathTask.appName, this.val$getPathTask.appPathInfo);
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateAppByName.notifyGetAppPathByNameTaskResult app=%s", new Object[] { this.val$getPathTask.appName }));
        ArkAppMgr.access$500(this.this$1.this$0, this.val$getPathTask);
        return;
        i = 6;
        ??? = null;
        ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.updateAppByName fail, invalid app version, result=%s, app-name=%s, expect-ver=%s, local-ver=%s", new Object[] { ArkAppMgr.UpdateAppByNameTask.Result.toString(this.val$updateTask.result), this.val$updateTask.appName, this.val$getPathTask.minAppVersion, this.val$updateTask.appPathInfo.desc.version }));
        continue;
        ArkEnvironmentManager localArkEnvironmentManager = ArkAppMgr.access$100();
        String str = this.val$updateTask.appName;
        if (??? != null)
        {
          localObject2 = ???;
          localArkEnvironmentManager.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.updateAppByName fail, retCode=%d, app-name=%s, msg=%s", new Object[] { Integer.valueOf(i), str, localObject2 }));
          continue;
        }
        Object localObject2 = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.3.1
 * JD-Core Version:    0.7.0.1
 */