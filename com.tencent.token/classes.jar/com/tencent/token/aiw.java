package com.tencent.token;

import com.tencent.wcdb.database.SQLiteConnection;
import com.tencent.wcdb.database.SQLiteConnection.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteMisuseException;
import java.util.Arrays;

public abstract class aiw
  extends aiq
{
  private static final String[] g = new String[0];
  final SQLiteDatabase a;
  final String b;
  final boolean c;
  final String[] d;
  final Object[] e;
  protected SQLiteConnection.c f;
  private final int h;
  private aiz i;
  
  protected aiw(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, aje paramaje)
  {
    this.a = paramSQLiteDatabase;
    this.b = paramString.trim();
    int j = aik.b(this.b);
    switch (j)
    {
    default: 
      bool = true;
      if (j != 1) {
        break;
      }
      break;
    case 4: 
    case 5: 
    case 6: 
      this.c = false;
      this.d = g;
      this.h = 0;
      break;
    }
    boolean bool = false;
    paramString = new ajb();
    paramSQLiteDatabase = paramSQLiteDatabase.b();
    String str = this.b;
    j = SQLiteDatabase.a(bool);
    if (str != null)
    {
      if (paramaje != null) {
        paramaje.a();
      }
      paramSQLiteDatabase.a(str, j, paramaje);
      try
      {
        paramSQLiteDatabase.a.a(str, paramString);
        paramSQLiteDatabase.b();
        this.c = paramString.c;
        this.d = paramString.b;
        this.h = paramString.a;
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > this.h))
        {
          paramSQLiteDatabase = new StringBuilder("Too many bind arguments.  ");
          paramSQLiteDatabase.append(paramArrayOfObject.length);
          paramSQLiteDatabase.append(" arguments were provided but the statement needs ");
          paramSQLiteDatabase.append(this.h);
          paramSQLiteDatabase.append(" arguments.");
          throw new IllegalArgumentException(paramSQLiteDatabase.toString());
        }
        j = this.h;
        if (j != 0)
        {
          this.e = new Object[j];
          if (paramArrayOfObject != null) {
            System.arraycopy(paramArrayOfObject, 0, this.e, 0, paramArrayOfObject.length);
          }
        }
        else
        {
          this.e = null;
        }
        this.f = null;
        this.i = null;
        return;
      }
      finally
      {
        paramSQLiteDatabase.b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  private void b()
  {
    try
    {
      Object localObject1;
      if (this.i == null)
      {
        localObject1 = this.f;
        if (localObject1 == null) {
          return;
        }
      }
      if ((this.i != null) && (this.f != null))
      {
        if (this.i == this.a.b())
        {
          localObject1 = this.i;
          SQLiteConnection.c localc = this.f;
          if (((aiz)localObject1).a != null)
          {
            ((aiz)localObject1).a.a(localc);
            ((aiz)localObject1).b();
          }
          this.f = null;
          this.i = null;
          return;
        }
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");
      }
      throw new IllegalStateException("Internal state error.");
    }
    finally {}
  }
  
  protected final void a()
  {
    SQLiteDebug.a(this.a);
    this.a.a();
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if ((paramInt > 0) && (paramInt <= this.h))
    {
      this.e[(paramInt - 1)] = paramObject;
      return;
    }
    paramObject = new StringBuilder("Cannot bind argument at index ");
    paramObject.append(paramInt);
    paramObject.append(" because the index is out of range.  The statement has ");
    paramObject.append(this.h);
    paramObject.append(" parameters.");
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  protected void c()
  {
    b();
    Object[] arrayOfObject = this.e;
    if (arrayOfObject != null) {
      Arrays.fill(arrayOfObject, null);
    }
  }
  
  protected void finalize()
  {
    try
    {
      if ((this.i == null) && (this.f == null))
      {
        super.finalize();
        return;
      }
      throw new SQLiteMisuseException("Acquired prepared statement is not released.");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiw
 * JD-Core Version:    0.7.0.1
 */