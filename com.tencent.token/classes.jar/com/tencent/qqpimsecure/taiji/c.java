package com.tencent.qqpimsecure.taiji;

import android.content.Context;
import tmsdk.common.module.pgsdk.manager.ITaijiFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class c
{
  private ITaijiFactory a;
  
  public static c a()
  {
    return a.a();
  }
  
  public ITaijiPreferenceManager a(Context paramContext, String paramString, int paramInt)
  {
    return this.a.getPreferenceManager(paramContext, paramString, paramInt);
  }
  
  public void a(ITaijiFactory paramITaijiFactory)
  {
    this.a = paramITaijiFactory;
  }
  
  public ITaijiSharkNetwork b()
  {
    return this.a.getSharkNetwork();
  }
  
  public ITaijiKVProfileManager c()
  {
    return this.a.getKVProfileManager();
  }
  
  public ITaijiThreadPoolManager d()
  {
    return this.a.getThreadPoolManager();
  }
  
  public ITaijiReportManager e()
  {
    return this.a.getReportManager();
  }
  
  public ITaijiTccCryptManager f()
  {
    return this.a.getTccCryptManager();
  }
  
  private static final class a
  {
    private static final c a = new c(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.c
 * JD-Core Version:    0.7.0.1
 */