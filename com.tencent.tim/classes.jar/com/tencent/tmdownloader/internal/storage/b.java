package com.tencent.tmdownloader.internal.storage;

import android.content.Context;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.ShareUrlConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b b;
  private Map<String, JceStruct> a = new ConcurrentHashMap();
  private ShareUrlConfig c;
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
    finally {}
  }
  
  public <T extends JceStruct> T a(String paramString, Class<T> paramClass)
  {
    if (this.a.containsKey(paramString)) {
      try
      {
        paramClass = (JceStruct)this.a.get(paramString);
        ab.c("JceCacheManager", "value of " + paramString + " found, return");
        return paramClass;
      }
      catch (Exception paramString)
      {
        ab.e("JceCacheManager", "<get> type cast error!");
      }
    }
    for (;;)
    {
      return null;
      byte[] arrayOfByte = Settings.getInstance().getBlob(paramString);
      if (arrayOfByte != null)
      {
        try
        {
          paramClass = ProtocolPackage.bytes2JceObj(arrayOfByte, paramClass);
          if (paramClass == null) {
            break label144;
          }
          this.a.put(paramString, paramClass);
          ab.c("JceCacheManager", "<get> Get value of " + paramString + " from database and save it to cache");
          return paramClass;
        }
        catch (Exception paramString)
        {
          ab.e("JceCacheManager", "<get> type cast error!");
        }
        continue;
        label144:
        ab.c("JceCacheManager", "<get> value of " + paramString + " is null !");
      }
    }
  }
  
  public List<String> a(Context paramContext)
  {
    if (GlobalUtil.getInstance().getContext() == null)
    {
      ab.c("JceCacheManager", "<getFilterConfig> GlobalUtil context is null, set it");
      GlobalUtil.getInstance().setContext(paramContext.getApplicationContext());
    }
    if (this.c != null)
    {
      ab.c("JceCacheManager", "<getFilterConfig> cache is available using cache");
      return this.c.blackList;
    }
    paramContext = Settings.getInstance().getBlob("key_filter_config");
    StringBuilder localStringBuilder;
    if (paramContext != null) {
      try
      {
        paramContext = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramContext, ShareUrlConfig.class);
        localStringBuilder = new StringBuilder();
        Iterator localIterator = paramContext.blackList.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append((String)localIterator.next());
          localStringBuilder.append("\n");
        }
        ab.c("JceCacheManager", "<getFilterConfig> data is null");
      }
      catch (Exception paramContext)
      {
        ab.e("JceCacheManager", "<getFilterConfig> decode ShareUrlConfig error!!! error = " + paramContext.getMessage());
      }
    } else {
      return new ArrayList();
    }
    ab.c("JceCacheManager", "<getFilterConfig> config content : " + localStringBuilder.toString() + ", and setting cache");
    this.c = paramContext;
    paramContext = paramContext.blackList;
    return paramContext;
  }
  
  public <T extends JceStruct> void a(String paramString, byte[] paramArrayOfByte, Class<T> paramClass)
  {
    k.a().post(new c(this, paramString, paramArrayOfByte, paramClass));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Settings.getInstance().setBlob("key_report_config", paramArrayOfByte);
  }
  
  public BatchReportConfig b()
  {
    byte[] arrayOfByte = Settings.getInstance().getBlob("key_report_config");
    if (arrayOfByte != null) {
      return (BatchReportConfig)ProtocolPackage.bytes2JceObj(arrayOfByte, BatchReportConfig.class);
    }
    return null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    try
    {
      ShareUrlConfig localShareUrlConfig = (ShareUrlConfig)ProtocolPackage.bytes2JceObj(paramArrayOfByte, ShareUrlConfig.class);
      if (localShareUrlConfig != null)
      {
        ab.c("JceCacheManager", "ShareUrlConfig is ok, config.blackList = " + localShareUrlConfig.blackList);
        this.c = localShareUrlConfig;
      }
      for (;;)
      {
        Settings.getInstance().setBlob("key_filter_config", paramArrayOfByte);
        return;
        ab.c("JceCacheManager", "ShareUrlConfig is null");
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.c("JceCacheManager", "saveFilterConfig error " + paramArrayOfByte.getMessage());
    }
  }
  
  public NewQqCenterConfig c()
  {
    byte[] arrayOfByte = Settings.getInstance().getBlob("key_new_app_center_config");
    if (arrayOfByte != null) {
      return (NewQqCenterConfig)ProtocolPackage.bytes2JceObj(arrayOfByte, NewQqCenterConfig.class);
    }
    return null;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    Settings.getInstance().setBlob("key_new_app_center_config", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.b
 * JD-Core Version:    0.7.0.1
 */