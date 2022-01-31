package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.component.cache.util.LocalConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractDbCacheManager
{
  protected static final String a = "CacheManager";
  protected static final String b = "_cache_db_version";
  protected static final String c = "_id";
  protected long a;
  protected DbCacheData.DbCreator a;
  protected DbCacheDatabase a;
  protected ArrayList a;
  protected boolean a;
  protected boolean b = false;
  protected String d;
  
  protected AbstractDbCacheManager(Context paramContext, Class paramClass, long paramLong, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheDatabase = DbCacheDatabase.a(paramContext.getApplicationContext(), paramLong);
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheDatabase.a(hashCode());
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString;
    a(paramClass);
    e();
    a(a());
  }
  
  static String a(long paramLong, String paramString)
  {
    return String.valueOf(paramLong) + "_" + paramString;
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, DbCacheData paramDbCacheData, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    paramDbCacheData.a(localContentValues);
    return paramSQLiteDatabase.update(this.d, localContentValues, paramString, null);
  }
  
  final Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator.a();
    }
    for (;;)
    {
      return paramSQLiteDatabase.query(this.d, null, paramString1, null, null, null, paramString2);
    }
  }
  
  protected Cursor a(String paramString1, String paramString2)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return null;
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    try
    {
      paramString1 = a(localSQLiteDatabase, paramString1, paramString2);
      return paramString1;
    }
    catch (SQLException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected SQLiteDatabase a()
  {
    if (a()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheDatabase.getWritableDatabase();
  }
  
  protected DbCacheData a(Cursor paramCursor, int paramInt)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {}
    for (;;)
    {
      return null;
      if ((paramInt >= 0) && (paramInt < paramCursor.getCount())) {
        try
        {
          boolean bool = paramCursor.moveToPosition(paramInt);
          if (bool) {
            return this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator.a(paramCursor);
          }
        }
        catch (Exception paramCursor)
        {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final String a()
  {
    return a(this.jdField_a_of_type_Long, this.d);
  }
  
  protected void a()
  {
    if (a()) {
      return;
    }
    try
    {
      if (a()) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheDatabase.b(hashCode());
    this.b = true;
  }
  
  protected void a(int paramInt, DbCacheData... paramVarArgs)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        return;
      } while (paramVarArgs == null);
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        a(localSQLiteDatabase, paramInt);
        int i = paramVarArgs.length;
        paramInt = 0;
        if (paramInt < i)
        {
          a(localSQLiteDatabase, paramVarArgs[paramInt]);
          paramInt += 1;
          continue;
        }
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (SQLException paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
        try
        {
          localSQLiteDatabase.endTransaction();
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
        continue;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.printStackTrace();
        try
        {
          localSQLiteDatabase.endTransaction();
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.endTransaction();
        d();
        return;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw paramVarArgs;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      paramSQLiteDatabase.execSQL(b());
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    }
    a(paramSQLiteDatabase, null);
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, DbCacheData paramDbCacheData)
  {
    ContentValues localContentValues = new ContentValues();
    paramDbCacheData.a(localContentValues);
    paramSQLiteDatabase.replaceOrThrow(this.d, null, localContentValues);
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.delete(this.d, paramString, null);
  }
  
  protected void a(DbCacheData paramDbCacheData, String paramString)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    if (a()) {
      break label15;
    }
    label15:
    SQLiteDatabase localSQLiteDatabase;
    int j;
    int k;
    for (;;)
    {
      return;
      if (paramDbCacheData != null)
      {
        localSQLiteDatabase = a();
        if (localSQLiteDatabase == null) {
          break;
        }
        j = m;
        k = n;
        for (;;)
        {
          try
          {
            localSQLiteDatabase.beginTransaction();
            j = m;
            k = n;
            if (a(localSQLiteDatabase, paramDbCacheData, paramString) > 0) {
              i = 1;
            }
            j = i;
            k = i;
            localSQLiteDatabase.setTransactionSuccessful();
          }
          catch (SQLException paramDbCacheData)
          {
            paramDbCacheData = paramDbCacheData;
            paramDbCacheData.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = j;
            }
            catch (Exception paramDbCacheData)
            {
              paramDbCacheData.printStackTrace();
              i = j;
            }
            continue;
          }
          catch (Exception paramDbCacheData)
          {
            paramDbCacheData = paramDbCacheData;
            paramDbCacheData.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = k;
            }
            catch (Exception paramDbCacheData)
            {
              paramDbCacheData.printStackTrace();
              i = k;
            }
            continue;
          }
          finally {}
          try
          {
            localSQLiteDatabase.endTransaction();
            if (i == 0) {
              break;
            }
            d();
            return;
          }
          catch (Exception paramDbCacheData)
          {
            paramDbCacheData.printStackTrace();
          }
        }
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw paramDbCacheData;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected void a(Class paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (DbCacheData.DbCreator)paramClass.getField("DB_CREATOR").get(null);
      if (paramClass == null) {
        throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
      }
    }
    catch (IllegalAccessException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("IllegalAccessException when access: " + str);
    }
    catch (ClassCastException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CacheData on class " + str);
    }
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator = paramClass;
    paramClass = paramClass.a();
    if (paramClass != null)
    {
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramClass[i];
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      throw new AbstractDbCacheManager.BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + str);
    }
  }
  
  protected void a(String paramString)
  {
    if (a()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    try
    {
      a(localSQLiteDatabase, paramString);
      d();
      return;
    }
    catch (SQLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + this.d + " (");
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      DbCacheData.Structure localStructure = (DbCacheData.Structure)localIterator.next();
      localStringBuilder.append(',');
      localStringBuilder.append(localStructure.a());
      localStringBuilder.append(' ');
      localStringBuilder.append(localStructure.b());
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  protected abstract void b();
  
  protected void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(c());
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected String c()
  {
    return "DROP TABLE IF EXISTS " + this.d;
  }
  
  protected abstract void c();
  
  protected void d()
  {
    c();
  }
  
  protected void e()
  {
    int i = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheData$DbCreator.a();
    int j = LocalConfig.a(this.d + "_cache_db_version", -1, this.jdField_a_of_type_Long);
    SQLiteDatabase localSQLiteDatabase;
    if ((j == -1) || (j != i))
    {
      localSQLiteDatabase = a();
      if (localSQLiteDatabase == null) {}
    }
    try
    {
      b(localSQLiteDatabase);
      LocalConfig.a(this.d + "_cache_db_version", i, this.jdField_a_of_type_Long);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void finalize()
  {
    a();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.component.cache.database.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */