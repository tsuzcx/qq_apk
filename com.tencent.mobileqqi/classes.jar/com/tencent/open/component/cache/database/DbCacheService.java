package com.tencent.open.component.cache.database;

import android.content.Context;
import hme;
import hmf;
import java.util.HashMap;

public class DbCacheService
{
  protected static DbCacheService a;
  protected Context a;
  protected hme a;
  public final HashMap a;
  
  protected DbCacheService(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Hme = new hmf(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static DbCacheService a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService != null) {
      return jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService;
    }
    try
    {
      if (jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService == null) {
        jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService = new DbCacheService(paramContext);
      }
      paramContext = jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheService;
      return paramContext;
    }
    finally {}
  }
  
  public DbCacheManager a(Class paramClass, long paramLong, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        throw new RuntimeException("call initiate(Context context) before this");
      }
    }
    if (paramString == null) {
      throw new RuntimeException("invalid table name");
    }
    Object localObject = DbCacheManager.a(paramLong, paramString);
    DbCacheManager localDbCacheManager = (DbCacheManager)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    localObject = localDbCacheManager;
    if (localDbCacheManager == null)
    {
      localObject = new DbCacheManager(this.jdField_a_of_type_AndroidContentContext, paramClass, paramLong, paramString);
      ((DbCacheManager)localObject).a(this.jdField_a_of_type_Hme);
      this.jdField_a_of_type_JavaUtilHashMap.put(((DbCacheManager)localObject).a(), localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheService
 * JD-Core Version:    0.7.0.1
 */