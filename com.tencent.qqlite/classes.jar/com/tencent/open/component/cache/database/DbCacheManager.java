package com.tencent.open.component.cache.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import fdn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DbCacheManager
  extends AbstractDbCacheManager
{
  protected Cursor a;
  protected fdn a;
  protected final ArrayList b = new ArrayList();
  protected String e;
  protected String f;
  
  protected DbCacheManager(Context paramContext, Class paramClass, long paramLong, String paramString)
  {
    super(paramContext, paramClass, paramLong, paramString);
    g();
  }
  
  protected static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
        {
          i = this.jdField_a_of_type_AndroidDatabaseCursor.getCount();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public DbCacheData a(int paramInt)
  {
    try
    {
      DbCacheData localDbCacheData = a(this.jdField_a_of_type_AndroidDatabaseCursor, paramInt);
      return localDbCacheData;
    }
    finally {}
  }
  
  protected List a()
  {
    ArrayList localArrayList1;
    Object localObject2;
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.b.size() <= 0) {
          break;
        }
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.b.iterator();
        if (!localIterator.hasNext()) {
          break label99;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localWeakReference = null;
          if (localWeakReference == null) {
            continue;
          }
          localArrayList1.add(localWeakReference);
        }
      }
      localObject2 = (DbCacheManager.OnChangeListener)localObject1.get();
    }
    for (;;)
    {
      return localObject2;
      localObject2 = null;
      continue;
      label99:
      localObject2 = localArrayList1;
    }
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramSQLiteDatabase, paramInt);
      return;
    }
    a(paramSQLiteDatabase, this.e);
  }
  
  public void a(DbCacheData paramDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, new DbCacheData[] { paramDbCacheData });
      return;
    }
    finally {}
  }
  
  void a(fdn paramfdn)
  {
    this.jdField_a_of_type_Fdn = paramfdn;
  }
  
  public void a(DbCacheData[] paramArrayOfDbCacheData, int paramInt)
  {
    try
    {
      a(paramInt, paramArrayOfDbCacheData);
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
      {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
        this.jdField_a_of_type_AndroidDatabaseCursor = null;
      }
      f();
      d();
      return;
    }
    finally {}
  }
  
  public void b(DbCacheData paramDbCacheData, String paramString)
  {
    try
    {
      a(paramDbCacheData, paramString);
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      a(paramString);
      return;
    }
    finally {}
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidDatabaseCursor != null) {
        this.jdField_a_of_type_AndroidDatabaseCursor.close();
      }
      g();
      d();
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    if (a(this.e, paramString)) {
      return;
    }
    try
    {
      if (a(this.e, paramString)) {
        return;
      }
    }
    finally {}
    this.e = paramString;
    if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
    {
      this.jdField_a_of_type_AndroidDatabaseCursor.close();
      g();
    }
    d();
  }
  
  public String d()
  {
    return this.e;
  }
  
  protected void d()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DbCacheManager.OnChangeListener localOnChangeListener = (DbCacheManager.OnChangeListener)((Iterator)localObject).next();
        if (localOnChangeListener != null) {
          localOnChangeListener.a(this);
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (a(this.f, paramString)) {
      return;
    }
    try
    {
      if (a(this.f, paramString)) {
        return;
      }
    }
    finally {}
    this.f = paramString;
    if (this.jdField_a_of_type_AndroidDatabaseCursor != null)
    {
      this.jdField_a_of_type_AndroidDatabaseCursor.close();
      g();
    }
    d();
  }
  
  public String e()
  {
    return this.f;
  }
  
  protected void f()
  {
    fdn localfdn = this.jdField_a_of_type_Fdn;
    if (localfdn != null) {
      localfdn.a(this);
    }
  }
  
  protected void g()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a(this.e, this.f);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheManager
 * JD-Core Version:    0.7.0.1
 */