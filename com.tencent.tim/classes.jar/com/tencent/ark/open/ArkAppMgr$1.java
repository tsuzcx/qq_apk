package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$1
  implements Runnable
{
  ArkAppMgr$1(ArkAppMgr paramArkAppMgr) {}
  
  public void run()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      ArkAppCacheMgr.setupArkEnvironment(true);
      long l2 = System.currentTimeMillis();
      ArkAppMgr.access$000(this.this$0);
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkAppMgr.init, time1=%d, time2=%d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l2) }));
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", localNoClassDefFoundError.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.1
 * JD-Core Version:    0.7.0.1
 */