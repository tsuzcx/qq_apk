package com.tencent.token;

import android.content.Context;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConnectionPool;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.a;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wcdb.support.Log;

public abstract class ahv
{
  private final Context a;
  private final String b;
  private final SQLiteDatabase.a c;
  private final int d;
  private SQLiteDatabase e;
  private boolean f;
  private boolean g;
  private final ahj h;
  private byte[] i;
  private SQLiteCipherSpec j;
  private int k;
  private boolean l;
  
  static {}
  
  public ahv(Context paramContext, String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, ahj paramahj)
  {
    this.a = paramContext;
    this.b = paramString;
    paramContext = null;
    this.c = null;
    this.d = 1;
    this.h = paramahj;
    this.i = paramArrayOfByte;
    if (paramSQLiteCipherSpec != null) {
      paramContext = new SQLiteCipherSpec(paramSQLiteCipherSpec);
    }
    this.j = paramContext;
    this.l = false;
  }
  
  private SQLiteDatabase a(SQLiteDatabase paramSQLiteDatabase)
  {
    int m = paramSQLiteDatabase.k();
    StringBuilder localStringBuilder2;
    if (m != this.d) {
      if (!paramSQLiteDatabase.l())
      {
        paramSQLiteDatabase.g();
        if (m != 0) {}
        try
        {
          if (m > this.d)
          {
            int n = this.d;
            StringBuilder localStringBuilder1 = new StringBuilder("Can't downgrade database from version ");
            localStringBuilder1.append(m);
            localStringBuilder1.append(" to ");
            localStringBuilder1.append(n);
            throw new SQLiteException(localStringBuilder1.toString());
          }
          paramSQLiteDatabase.b("PRAGMA user_version = ".concat(String.valueOf(this.d)));
          paramSQLiteDatabase.i();
        }
        finally
        {
          paramSQLiteDatabase.h();
        }
      }
      else
      {
        localStringBuilder2 = new StringBuilder("Can't upgrade read-only database from version ");
        localStringBuilder2.append(paramSQLiteDatabase.k());
        localStringBuilder2.append(" to ");
        localStringBuilder2.append(this.d);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.b);
        throw new SQLiteException(localStringBuilder2.toString());
      }
    }
    if (paramSQLiteDatabase.l())
    {
      localStringBuilder2 = new StringBuilder("Opened ");
      localStringBuilder2.append(this.b);
      localStringBuilder2.append(" in read-only mode");
      Log.b("WCDB.SQLiteOpenHelper", localStringBuilder2.toString());
    }
    this.e = paramSQLiteDatabase;
    return paramSQLiteDatabase;
  }
  
  private SQLiteDatabase c()
  {
    Object localObject1 = this.e;
    if (localObject1 != null) {
      if (!((SQLiteDatabase)localObject1).n()) {
        this.e = null;
      } else if (!this.e.l()) {
        return this.e;
      }
    }
    SQLiteDatabase localSQLiteDatabase2;
    SQLiteDatabase localSQLiteDatabase1;
    if (!this.f)
    {
      localSQLiteDatabase2 = this.e;
      localSQLiteDatabase1 = localSQLiteDatabase2;
    }
    for (;;)
    {
      try
      {
        this.f = true;
        Object localObject3;
        if (localSQLiteDatabase2 != null)
        {
          localObject1 = localSQLiteDatabase2;
          localSQLiteDatabase1 = localSQLiteDatabase2;
          if (localSQLiteDatabase2.l())
          {
            localSQLiteDatabase1 = localSQLiteDatabase2;
            localObject1 = localSQLiteDatabase2.a;
            localSQLiteDatabase1 = localSQLiteDatabase2;
            try
            {
              localSQLiteDatabase2.r();
              if (!localSQLiteDatabase2.m())
              {
                localObject1 = localSQLiteDatabase2;
                continue;
              }
              m = localSQLiteDatabase2.b.d;
              localSQLiteDatabase2.b.d = (localSQLiteDatabase2.b.d & 0xFFFFFFFE | 0x0);
              try
              {
                localSQLiteDatabase2.c.a(localSQLiteDatabase2.b);
              }
              catch (RuntimeException localRuntimeException)
              {
                localSQLiteDatabase2.b.d = m;
                throw localRuntimeException;
              }
              localObject3 = localSQLiteDatabase2;
            }
            finally
            {
              localObject3 = localSQLiteDatabase2;
            }
          }
        }
        else if (this.b == null)
        {
          localObject3 = localSQLiteDatabase2;
          localObject1 = SQLiteDatabase.j();
        }
        else
        {
          localObject3 = localSQLiteDatabase2;
        }
        try
        {
          this.l = true;
          localObject3 = localSQLiteDatabase2;
          if (!this.g) {
            break label347;
          }
          m = 8;
          localObject3 = localSQLiteDatabase2;
          this.k = m;
          localObject3 = localSQLiteDatabase2;
          localObject1 = aif.a(this.a, this.b, this.i, this.j, this.k, this.c, this.h);
          localObject3 = localObject1;
          localSQLiteDatabase2 = a((SQLiteDatabase)localObject1);
          this.f = false;
          if ((localObject1 != null) && (localObject1 != this.e)) {
            ((SQLiteDatabase)localObject1).close();
          }
          return localSQLiteDatabase2;
        }
        catch (SQLiteException localSQLiteException)
        {
          localObject3 = localSQLiteDatabase2;
          throw localSQLiteException;
        }
        throw new IllegalStateException("getDatabase called recursively");
      }
      finally
      {
        this.f = false;
        if ((localObject3 != null) && (localObject3 != this.e)) {
          ((SQLiteDatabase)localObject3).close();
        }
      }
      label347:
      int m = 0;
    }
  }
  
  public final SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c();
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public final void b()
  {
    try
    {
      if (!this.f)
      {
        if ((this.e != null) && (this.e.n()))
        {
          this.e.close();
          this.e = null;
        }
        return;
      }
      throw new IllegalStateException("Closed during initialization");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahv
 * JD-Core Version:    0.7.0.1
 */