package com.tencent.common.app;

import anpc;
import java.util.HashMap;

class BaseApplicationImpl$3
  implements Runnable
{
  BaseApplicationImpl$3(BaseApplicationImpl paramBaseApplicationImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(this.bzL));
    localHashMap.put("param_uin", this.val$uin);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.val$uin, "PcActiveSuccB", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl.3
 * JD-Core Version:    0.7.0.1
 */