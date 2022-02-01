package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import java.util.ArrayList;
import java.util.Iterator;

class ArkAppMgr$7
  implements Runnable
{
  ArkAppMgr$7(ArkAppMgr paramArkAppMgr, Object paramObject, ArrayList paramArrayList, ArkAppMgr.IUpdateAppByNameCallback paramIUpdateAppByNameCallback) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((this.val$userdata instanceof ArkAppMgr.GetAppPathByNameTask)) {}
    label505:
    String str3;
    for (String str1 = ((ArkAppMgr.GetAppPathByNameTask)this.val$userdata).appView;; str3 = "")
    {
      Iterator localIterator = this.val$appNameList.iterator();
      ArkAppCGIMgr.AppNameVersion localAppNameVersion;
      String str4;
      if (localIterator.hasNext())
      {
        localAppNameVersion = (ArkAppCGIMgr.AppNameVersion)localIterator.next();
        str4 = localAppNameVersion.appName;
      }
      for (;;)
      {
        synchronized (ArkAppMgr.access$900(this.this$0))
        {
          ??? = ArkAppMgr.access$900(this.this$0).iterator();
          if (!((Iterator)???).hasNext()) {
            break label505;
          }
          localUpdateAppByNameTask = (ArkAppMgr.UpdateAppByNameTask)((Iterator)???).next();
          if ((!localUpdateAppByNameTask.appName.equalsIgnoreCase(str4)) || ((!TextUtils.isEmpty(str1)) && ((TextUtils.isEmpty(str1)) || (!str1.equals(localUpdateAppByNameTask.appView))))) {
            continue;
          }
          localUpdateAppByNameTask.userdata.add(this.val$userdata);
          localUpdateAppByNameTask.callback.add(this.val$cb);
          ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.updateAppByNameBatch, merged, appname=%s", new Object[] { str4, ", appview=%s", str1, ", task.name=%s", localUpdateAppByNameTask.appName, ", task.view=%s", localUpdateAppByNameTask.appView }));
          i = 1;
          if (i != 0) {
            ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.updateAppByNameBatch, request merged, appname=%s", new Object[] { str4, ", appview=%s", str1 }));
          }
        }
        ??? = ArkAppMgr.access$1000(str4, str2);
        ArkAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = new ArkAppMgr.UpdateAppByNameTask(null);
        localUpdateAppByNameTask.appName = str4;
        localUpdateAppByNameTask.appView = str2;
        localUpdateAppByNameTask.localAppPathInfo = ((ArkAppMgr.AppPathInfo)???);
        localUpdateAppByNameTask.appPathInfo = null;
        localUpdateAppByNameTask.userdata.add(this.val$userdata);
        localUpdateAppByNameTask.callback.add(this.val$cb);
        for (;;)
        {
          synchronized (ArkAppMgr.access$900(this.this$0))
          {
            ArkAppMgr.access$900(this.this$0).add(localUpdateAppByNameTask);
            localArrayList1.add(localUpdateAppByNameTask);
            ??? = new ArkAppCGIMgr.AppNameVersion();
            ((ArkAppCGIMgr.AppNameVersion)???).appName = str4;
            if ((??? != null) && (((ArkAppMgr.AppPathInfo)???).desc != null) && (((ArkAppMgr.AppPathInfo)???).appTempInfo == null))
            {
              ((ArkAppCGIMgr.AppNameVersion)???).appVersion = ((ArkAppMgr.AppPathInfo)???).desc.version;
              ((ArkAppCGIMgr.AppNameVersion)???).expectAppVersion = localAppNameVersion.expectAppVersion;
              localArrayList2.add(???);
            }
          }
          ((ArkAppCGIMgr.AppNameVersion)???).appVersion = "0.0.0.0";
        }
        ArkAppCGIMgr.getInstance().queryAppInfoByAppNameBatch(localArrayList2, localArrayList1, new ArkAppMgr.7.1(this));
        return;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.7
 * JD-Core Version:    0.7.0.1
 */