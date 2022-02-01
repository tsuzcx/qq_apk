package com.tencent.open.component.cache;

import android.content.Context;
import com.tencent.open.component.cache.database.DbCacheService;
import hmc;
import java.io.File;

public class CacheManager
{
  protected static DbCacheService a;
  
  public static DbCacheService a()
  {
    return a;
  }
  
  protected static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramContext = hmc.a(paramContext); paramContext == null; paramContext = hmc.a(paramContext, "cache")) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static void a(Context paramContext)
  {
    a = DbCacheService.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.component.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */