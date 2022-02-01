package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.impl.AGConnectServicesConfigImpl;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AGConnectServicesConfig
{
  private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
  private static final Object INSTANCES_LOCK = new Object();
  
  public static AGConnectServicesConfig fromContext(Context paramContext)
  {
    Object localObject1 = paramContext.getApplicationContext();
    if (localObject1 == null) {}
    for (;;)
    {
      synchronized (INSTANCES_LOCK)
      {
        AGConnectServicesConfig localAGConnectServicesConfig = (AGConnectServicesConfig)INSTANCES.get(paramContext.getPackageName());
        localObject1 = localAGConnectServicesConfig;
        if (localAGConnectServicesConfig == null)
        {
          localObject1 = new AGConnectServicesConfigImpl(paramContext);
          INSTANCES.put(paramContext.getPackageName(), localObject1);
        }
        return localObject1;
      }
      paramContext = (Context)localObject1;
    }
  }
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract String getString(String paramString);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract void overlayWith(LazyInputStream paramLazyInputStream);
  
  public abstract void overlayWith(InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.AGConnectServicesConfig
 * JD-Core Version:    0.7.0.1
 */