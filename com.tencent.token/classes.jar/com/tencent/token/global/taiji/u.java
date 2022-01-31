package com.tencent.token.global.taiji;

import android.content.Context;
import java.util.ArrayList;
import tmsdk.common.module.pgsdk.manager.ITaijiFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiKVProfileManager;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.ITaijiSharkNetwork;
import tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class u
  implements ITaijiFactory
{
  public static String a(ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramArrayList.get(i));
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public ITaijiKVProfileManager getKVProfileManager()
  {
    return x.a();
  }
  
  public ITaijiPreferenceManager getPreferenceManager(Context paramContext, String paramString, int paramInt)
  {
    return new aa(paramString);
  }
  
  public ITaijiReportManager getReportManager()
  {
    return new v(this);
  }
  
  public ITaijiSharkNetwork getSharkNetwork()
  {
    return ab.a();
  }
  
  public ITaijiTccCryptManager getTccCryptManager()
  {
    return new w(this);
  }
  
  public ITaijiThreadPoolManager getThreadPoolManager()
  {
    return af.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.u
 * JD-Core Version:    0.7.0.1
 */