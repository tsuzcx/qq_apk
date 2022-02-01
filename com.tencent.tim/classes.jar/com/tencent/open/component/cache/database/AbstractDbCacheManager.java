package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.AndroidRuntimeException;
import aryh;
import aryh.a;
import aryh.b;
import aryi;
import arym;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractDbCacheManager
{
  protected aryi a;
  protected aryh.a b;
  protected ArrayList<aryh.b> eX = new ArrayList();
  protected boolean mClosed;
  protected long mUin;
  protected String xN;
  protected boolean xh;
  
  protected AbstractDbCacheManager(Context paramContext, Class<? extends aryh> paramClass, long paramLong, String paramString)
  {
    this.a = aryi.a(paramContext.getApplicationContext(), paramLong);
    this.a.gz(hashCode());
    this.mUin = paramLong;
    this.xN = paramString;
    b(paramClass);
    elW();
    i(a());
  }
  
  public static String l(long paramLong, String paramString)
  {
    return String.valueOf(paramLong) + "_" + paramString;
  }
  
  protected void Mh()
  {
    onChanged();
  }
  
  final int a(SQLiteDatabase paramSQLiteDatabase, aryh paramaryh, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    paramaryh.writeTo(localContentValues);
    return paramSQLiteDatabase.update(this.xN, localContentValues, paramString, null);
  }
  
  final Cursor a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = this.b.sortOrder();
    }
    for (;;)
    {
      return paramSQLiteDatabase.query(this.xN, null, paramString1, null, null, null, paramString2);
    }
  }
  
  protected SQLiteDatabase a()
  {
    if (isClosed()) {
      return null;
    }
    return this.a.getWritableDatabase();
  }
  
  protected aryh a(Cursor paramCursor, int paramInt)
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
            return this.b.a(paramCursor);
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
  
  protected void a(int paramInt, aryh... paramVarArgs)
  {
    if (isClosed()) {}
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
        b(localSQLiteDatabase, paramInt);
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
        Mh();
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
  
  final void a(SQLiteDatabase paramSQLiteDatabase, aryh paramaryh)
  {
    ContentValues localContentValues = new ContentValues();
    paramaryh.writeTo(localContentValues);
    paramSQLiteDatabase.replaceOrThrow(this.xN, null, localContentValues);
  }
  
  protected final void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.delete(this.xN, paramString, null);
  }
  
  protected void a(aryh paramaryh, String paramString)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    if (isClosed()) {
      break label15;
    }
    label15:
    SQLiteDatabase localSQLiteDatabase;
    int j;
    int k;
    for (;;)
    {
      return;
      if (paramaryh != null)
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
            if (a(localSQLiteDatabase, paramaryh, paramString) > 0) {
              i = 1;
            }
            j = i;
            k = i;
            localSQLiteDatabase.setTransactionSuccessful();
          }
          catch (SQLException paramaryh)
          {
            paramaryh = paramaryh;
            paramaryh.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = j;
            }
            catch (Exception paramaryh)
            {
              paramaryh.printStackTrace();
              i = j;
            }
            continue;
          }
          catch (Exception paramaryh)
          {
            paramaryh = paramaryh;
            paramaryh.printStackTrace();
            try
            {
              localSQLiteDatabase.endTransaction();
              i = k;
            }
            catch (Exception paramaryh)
            {
              paramaryh.printStackTrace();
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
            Mh();
            return;
          }
          catch (Exception paramaryh)
          {
            paramaryh.printStackTrace();
          }
        }
      }
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw paramaryh;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected Cursor b(String paramString1, String paramString2)
  {
    if (isClosed()) {}
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
  
  protected void b(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    }
    a(paramSQLiteDatabase, null);
  }
  
  protected void b(Class<? extends aryh> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      paramClass = (aryh.a)paramClass.getField("DB_CREATOR").get(null);
      if (paramClass == null) {
        throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
      }
    }
    catch (IllegalAccessException paramClass)
    {
      throw new BadCacheDataException("IllegalAccessException when access: " + str);
    }
    catch (ClassCastException paramClass)
    {
      throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CREATOR on class " + str);
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new BadCacheDataException("CacheData protocol requires a CacheData.Creator object called  CacheData on class " + str);
    }
    this.b = paramClass;
    paramClass = paramClass.a();
    if (paramClass != null)
    {
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramClass[i];
        if (localObject != null) {
          this.eX.add(localObject);
        }
        i += 1;
      }
    }
    if (this.eX.size() == 0) {
      throw new BadCacheDataException("CacheData protocol requires a valid CacheData.Structure from CacheData.Creator object called  CREATOR on class " + str);
    }
  }
  
  protected void delete(String paramString)
  {
    if (isClosed()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = a();
    } while (localSQLiteDatabase == null);
    try
    {
      a(localSQLiteDatabase, paramString);
      Mh();
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
  
  protected String dp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + this.xN + " (");
    localStringBuilder.append("_id INTEGER PRIMARY KEY");
    Iterator localIterator = this.eX.iterator();
    while (localIterator.hasNext())
    {
      aryh.b localb = (aryh.b)localIterator.next();
      localStringBuilder.append(',');
      localStringBuilder.append(localb.getName());
      localStringBuilder.append(' ');
      localStringBuilder.append(localb.getType());
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  protected String dr()
  {
    return "DROP TABLE IF EXISTS " + this.xN;
  }
  
  protected void elW()
  {
    int i = this.b.version();
    int j = arym.getInt4Uin(this.xN + "_cache_db_version", -1, this.mUin);
    SQLiteDatabase localSQLiteDatabase;
    if ((j == -1) || (j != i))
    {
      localSQLiteDatabase = a();
      if (localSQLiteDatabase == null) {}
    }
    try
    {
      j(localSQLiteDatabase);
      arym.putInt4Uin(this.xN + "_cache_db_version", i, this.mUin);
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
  
  protected void i(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.xh) {}
    try
    {
      paramSQLiteDatabase.execSQL(dp());
      this.xh = true;
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
  
  public final boolean isClosed()
  {
    return this.mClosed;
  }
  
  protected void j(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(dr());
    this.xh = false;
  }
  
  protected abstract void onChanged();
  
  public final String uniqueKey()
  {
    return l(this.mUin, this.xN);
  }
  
  static class BadCacheDataException
    extends AndroidRuntimeException
  {
    public BadCacheDataException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.component.cache.database.AbstractDbCacheManager
 * JD-Core Version:    0.7.0.1
 */