package com.tencent.token;

import android.os.Process;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.database.SQLiteConnection;
import com.tencent.wcdb.database.SQLiteConnectionPool;

public final class agn
{
  public SQLiteConnection a;
  private final SQLiteConnectionPool c;
  private int d;
  private int e;
  private a f;
  private a g;
  
  public agn(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool != null)
    {
      this.c = paramSQLiteConnectionPool;
      return;
    }
    throw new IllegalArgumentException("connectionPool must not be null");
  }
  
  private void a(a parama)
  {
    parama.a = this.f;
    parama.c = null;
    this.f = parama;
  }
  
  private void b(int paramInt, ags paramags)
  {
    if (paramags != null) {
      paramags.a();
    }
    if (this.g == null) {
      a(null, paramInt, paramags);
    }
    try
    {
      if (this.g == null) {
        this.a.a("BEGIN EXCLUSIVE;", null, paramags);
      }
      paramags = e();
      paramags.a = this.g;
      this.g = paramags;
      return;
      return;
    }
    finally
    {
      if (this.g == null) {
        b();
      }
    }
  }
  
  private void b(ags paramags)
  {
    if (paramags != null) {
      paramags.a();
    }
    a locala = this.g;
    int i;
    if ((locala.d) && (!locala.e)) {
      i = 1;
    } else {
      i = 0;
    }
    this.g = locala.a;
    a(locala);
    locala = this.g;
    if (locala != null)
    {
      if (i == 0)
      {
        locala.e = true;
        return;
      }
      return;
    }
    if (i != 0) {}
    try
    {
      this.a.a("COMMIT;", null, paramags);
      break label96;
      this.a.a("ROLLBACK;", null, paramags);
      label96:
      return;
    }
    finally
    {
      b();
    }
  }
  
  private boolean b(String paramString, int paramInt, ags paramags)
  {
    if (paramags != null) {
      paramags.a();
    }
    switch (afy.b(paramString))
    {
    default: 
      return false;
    case 6: 
      a(paramags);
      return true;
    case 5: 
      a();
      a(paramags);
      return true;
    }
    a(paramInt, paramags);
    return true;
  }
  
  private void c()
  {
    if (this.g != null) {
      return;
    }
    throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
  }
  
  private void d()
  {
    a locala = this.g;
    if (locala != null)
    {
      if (!locala.d) {
        return;
      }
      throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }
  }
  
  private a e()
  {
    a locala = this.f;
    if (locala != null)
    {
      this.f = locala.a;
      locala.a = null;
      locala.d = false;
      locala.e = false;
    }
    else
    {
      locala = new a((byte)0);
    }
    locala.b = 2;
    locala.c = null;
    return locala;
  }
  
  public final int a(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, ags paramags)
  {
    if (paramString != null)
    {
      if (paramCursorWindow != null)
      {
        if (b(paramString, paramInt3, paramags))
        {
          paramCursorWindow.a();
          return 0;
        }
        a(paramString, paramInt3, paramags);
        try
        {
          paramInt1 = this.a.a(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramags);
          return paramInt1;
        }
        finally
        {
          b();
        }
      }
      throw new IllegalArgumentException("window must not be null.");
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public final long a(String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramString != null)
    {
      if (b(paramString, paramInt, null)) {
        return 0L;
      }
      a(paramString, paramInt, null);
      try
      {
        long l = this.a.a(paramString, paramArrayOfObject);
        return l;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public final void a()
  {
    c();
    d();
    this.g.d = true;
  }
  
  public final void a(int paramInt, ags paramags)
  {
    d();
    b(paramInt, paramags);
  }
  
  public final void a(ags paramags)
  {
    c();
    if ((!b) && (this.a == null)) {
      throw new AssertionError();
    }
    b(paramags);
  }
  
  public final void a(String paramString, int paramInt, ags paramags)
  {
    if (this.a == null)
    {
      this.a = this.c.a(paramString, paramInt, paramags);
      this.d = paramInt;
      this.a.a(Thread.currentThread(), Process.myTid());
    }
    this.e += 1;
  }
  
  public final int b(String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramString != null)
    {
      if (b(paramString, paramInt, null)) {
        return 0;
      }
      a(paramString, paramInt, null);
      try
      {
        paramInt = this.a.b(paramString, paramArrayOfObject);
        return paramInt;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  public final void b()
  {
    int i = this.e - 1;
    this.e = i;
    if (i == 0) {
      try
      {
        this.a.a(null, 0);
        this.c.a(this.a);
        return;
      }
      finally
      {
        this.a = null;
      }
    }
  }
  
  public final long c(String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramString != null)
    {
      if (b(paramString, paramInt, null)) {
        return 0L;
      }
      a(paramString, paramInt, null);
      try
      {
        long l = this.a.c(paramString, paramArrayOfObject);
        return l;
      }
      finally
      {
        b();
      }
    }
    throw new IllegalArgumentException("sql must not be null.");
  }
  
  static final class a
  {
    public a a;
    public int b;
    public agr c;
    public boolean d;
    public boolean e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agn
 * JD-Core Version:    0.7.0.1
 */