package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.io.File;
import java.util.HashMap;

class ArkAppCGIMgr$4
  implements Runnable
{
  ArkAppCGIMgr$4(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.QueryTask paramQueryTask) {}
  
  public void run()
  {
    try
    {
      IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
      if (localIArkDelegateNet != null)
      {
        HashMap localHashMap = new HashMap(2);
        if (this.val$task.cookie != null) {
          localHashMap.put("Cookie", this.val$task.cookie);
        }
        if (this.val$task.referer != null) {
          localHashMap.put("Referer", this.val$task.referer);
        }
        File localFile = new File(ArkAppCGIMgr.access$500());
        this.val$task.rspFile = localFile;
        localIArkDelegateNet.download(this.val$task.url, true, true, localHashMap, localFile, new ArkAppCGIMgr.4.1(this, localFile));
        return;
      }
      ArkAppCGIMgr.access$100().logI("ArkApp.ArkAppCGIMgr", String.format("download fail, url=%s for ark net delegate is null", new Object[] { this.val$task.url }));
      return;
    }
    catch (Exception localException)
    {
      ArkAppCGIMgr.access$100().logI("ArkApp.ArkAppCGIMgr", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.val$task.url, localException.getMessage() }));
      ArkAppCGIMgr.access$600(this.this$0, this.val$task, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.4
 * JD-Core Version:    0.7.0.1
 */