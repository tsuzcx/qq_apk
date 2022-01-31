package tmsdk.common.module.pgsdk.manager;

import android.content.Context;

public abstract interface ITaijiFactory
{
  public abstract ITaijiKVProfileManager getKVProfileManager();
  
  public abstract ITaijiPreferenceManager getPreferenceManager(Context paramContext, String paramString, int paramInt);
  
  public abstract ITaijiReportManager getReportManager();
  
  public abstract ITaijiSharkNetwork getSharkNetwork();
  
  public abstract ITaijiTccCryptManager getTccCryptManager();
  
  public abstract ITaijiThreadPoolManager getThreadPoolManager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiFactory
 * JD-Core Version:    0.7.0.1
 */