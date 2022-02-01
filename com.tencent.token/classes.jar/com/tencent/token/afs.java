package com.tencent.token;

import android.database.CharArrayBuffer;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.StaleDataException;

public abstract class afs
  extends afr
{
  protected CursorWindow i;
  
  protected final void a()
  {
    super.a();
    c();
  }
  
  protected final void a(String paramString)
  {
    CursorWindow localCursorWindow = this.i;
    if (localCursorWindow == null)
    {
      this.i = new CursorWindow(paramString);
      return;
    }
    localCursorWindow.a();
  }
  
  protected final void b()
  {
    super.b();
    if (this.i != null) {
      return;
    }
    throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
  }
  
  protected final void c()
  {
    CursorWindow localCursorWindow = this.i;
    if (localCursorWindow != null)
    {
      localCursorWindow.close();
      this.i = null;
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    b();
    CursorWindow localCursorWindow = this.i;
    int j = this.b;
    if (paramCharArrayBuffer != null)
    {
      localCursorWindow.d();
      try
      {
        CursorWindow.nativeCopyStringToBuffer(localCursorWindow.a, j - localCursorWindow.b, paramInt, paramCharArrayBuffer);
        return;
      }
      finally
      {
        localCursorWindow.e();
      }
    }
    throw new IllegalArgumentException("CharArrayBuffer should not be null");
  }
  
  public byte[] getBlob(int paramInt)
  {
    b();
    return this.i.b(this.b, paramInt);
  }
  
  public double getDouble(int paramInt)
  {
    b();
    return this.i.e(this.b, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    b();
    return (float)this.i.e(this.b, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    b();
    return (int)this.i.d(this.b, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    b();
    return this.i.d(this.b, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    b();
    return (short)(int)this.i.d(this.b, paramInt);
  }
  
  public String getString(int paramInt)
  {
    b();
    return this.i.c(this.b, paramInt);
  }
  
  public int getType(int paramInt)
  {
    b();
    return this.i.a(this.b, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    b();
    return this.i.a(this.b, paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afs
 * JD-Core Version:    0.7.0.1
 */