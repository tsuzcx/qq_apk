package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.ArrayList;

class ArkAppMgr$13$1
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  ArkAppMgr$13$1(ArkAppMgr.13 param13) {}
  
  public void onGetPredownloadAppList(boolean paramBoolean, ArrayList<String> paramArrayList, ArrayList<ArkAppCGIMgr.AIWordDictInfo> arg3, Object paramObject)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "_updatePredownloadAppList, fail.");
    }
    synchronized (ArkAppMgr.access$1900(this.this$1.this$0))
    {
      ArkAppMgr.access$1900(this.this$1.this$0).clear();
      if (paramArrayList != null) {
        ArkAppMgr.access$1900(this.this$1.this$0).addAll(paramArrayList);
      }
      return;
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", new Object[] { "_updatePredownloadAppList, success, app-count=", Integer.valueOf(paramArrayList.size()), ", applist=", paramArrayList.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.13.1
 * JD-Core Version:    0.7.0.1
 */