package com.tencent.open.base.http;

import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HttpCacheService
{
  protected static final int a = 50;
  protected static final long a = 432000000L;
  protected static HttpCacheService a;
  protected static final String a;
  protected static final String b = "http_cache_table";
  protected DbCacheManager a;
  protected HashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = HttpCacheService.class.getName();
    jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService = null;
  }
  
  protected HttpCacheService()
  {
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
          this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = CacheManager.a().a(HttpCacheData.class, 0L, "http_cache_table");
        }
        int j = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a();
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap(j);
        i = 0;
        if (i < j)
        {
          HttpCacheData localHttpCacheData = (HttpCacheData)this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(i);
          if ((localHttpCacheData == null) || (localHttpCacheData.k == null)) {
            break label118;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localHttpCacheData.k, localHttpCacheData);
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      return;
      label118:
      i += 1;
    }
  }
  
  public static HttpCacheService a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService == null) {
        jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService = new HttpCacheService();
      }
      HttpCacheService localHttpCacheService = jdField_a_of_type_ComTencentOpenBaseHttpHttpCacheService;
      return localHttpCacheService;
    }
    finally {}
  }
  
  public long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        paramString = MD5Utils.b(paramString);
        l1 = l2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          l1 = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).a;
        }
      }
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "Get lastModify from cache. lastModify=" + l1);
    return l1;
  }
  
  public String a(String paramString)
  {
    String str2 = "\"\"";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        paramString = MD5Utils.b(paramString);
        str1 = str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          str1 = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).l;
        }
      }
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "Get ETag from cache. ETag=" + str1);
    return str1;
  }
  
  protected void a()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        long l2 = System.currentTimeMillis();
        long l1 = 9223372036854775807L;
        String str = null;
        if (localIterator.hasNext())
        {
          HttpCacheData localHttpCacheData = (HttpCacheData)localIterator.next();
          if (l2 - localHttpCacheData.b >= 432000000L)
          {
            LogUtility.c(jdField_a_of_type_JavaLangString, "Clear out of date cache. urlkey=" + localHttpCacheData.k);
            this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.b("urlKey='" + localHttpCacheData.k + "'");
            localIterator.remove();
          }
          else if (l1 > localHttpCacheData.b)
          {
            l1 = localHttpCacheData.b;
            str = localHttpCacheData.k;
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 50)
          {
            LogUtility.c(jdField_a_of_type_JavaLangString, "Reached max cache count:50. Clear last cache data. urlKey=" + ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(str)).k);
            this.jdField_a_of_type_JavaUtilHashMap.remove(str);
            this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.b("urlKey='" + str + "'");
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = MD5Utils.b(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.b("urlKey='" + paramString + "'");
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (("".equals(paramString1.trim())) || (paramString3 == null))
        {
          LogUtility.e(jdField_a_of_type_JavaLangString, "saveResponse error. params error\n url=" + paramString1 + "; ETag=" + paramString2 + "; lastModify=" + paramLong + "; response=" + paramString3);
          return;
        }
        paramString2 = new HttpCacheData(paramString1, paramString2, paramLong, paramString3);
        paramString1 = MD5Utils.b(paramString1);
        if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
        {
          this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.b(paramString2, "urlKey='" + paramString1 + "'");
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
          LogUtility.c(jdField_a_of_type_JavaLangString, "Get 200, Save response data to cache. urlKey=" + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      a();
      this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(paramString2, 1);
    }
  }
  
  public String b(String paramString)
  {
    String str1 = "";
    String str2 = str1;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str2 = str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        str2 = MD5Utils.b(paramString);
        paramString = str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str2) != null) {
          paramString = ((HttpCacheData)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).m;
        }
        LogUtility.c(jdField_a_of_type_JavaLangString, "Get 304, Load response data from cache. urlKey=" + str2);
        str2 = paramString;
      }
    }
    return str2;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheService
 * JD-Core Version:    0.7.0.1
 */