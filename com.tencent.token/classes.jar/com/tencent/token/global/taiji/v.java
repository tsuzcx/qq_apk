package com.tencent.token.global.taiji;

import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;

class v
  implements ITaijiReportManager
{
  v(u paramu) {}
  
  public void reportString(int paramInt, ArrayList paramArrayList)
  {
    TMSDKContext.SaveStringData(paramInt, u.a(paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.v
 * JD-Core Version:    0.7.0.1
 */