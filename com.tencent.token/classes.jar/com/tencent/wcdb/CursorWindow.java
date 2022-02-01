package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.token.aiq;

public class CursorWindow
  extends aiq
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator() {};
  private static int c;
  public long a;
  public int b;
  private final String d;
  
  static
  {
    int i = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
    if (i != 0) {
      c = Resources.getSystem().getInteger(i) * 1024;
    } else {
      c = 2097152;
    }
  }
  
  private CursorWindow()
  {
    throw new UnsupportedOperationException();
  }
  
  public CursorWindow(String paramString)
  {
    this.b = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "<unnamed>";
    }
    this.d = paramString;
    this.a = nativeCreate(this.d, c);
    if (this.a != 0L) {
      return;
    }
    paramString = new StringBuilder("Cursor window allocation of ");
    paramString.append(c / 1024);
    paramString.append(" kb failed. ");
    throw new CursorWindowAllocationException(paramString.toString());
  }
  
  public static CursorWindow a(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }
  
  private void f()
  {
    long l = this.a;
    if (l != 0L)
    {
      nativeDispose(l);
      this.a = 0L;
    }
  }
  
  private static native boolean nativeAllocRow(long paramLong);
  
  private static native void nativeClear(long paramLong);
  
  public static native void nativeCopyStringToBuffer(long paramLong, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer);
  
  private static native long nativeCreate(String paramString, int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeFreeLastRow(long paramLong);
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt1, int paramInt2);
  
  private static native double nativeGetDouble(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nativeGetLong(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetNumRows(long paramLong);
  
  private static native String nativeGetString(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nativeGetType(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutBlob(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native boolean nativePutDouble(long paramLong, double paramDouble, int paramInt1, int paramInt2);
  
  private static native boolean nativePutLong(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native boolean nativePutNull(long paramLong, int paramInt1, int paramInt2);
  
  private static native boolean nativePutString(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private static native boolean nativeSetNumColumns(long paramLong, int paramInt);
  
  public final int a(int paramInt1, int paramInt2)
  {
    d();
    try
    {
      paramInt1 = nativeGetType(this.a, paramInt1 - this.b, paramInt2);
      return paramInt1;
    }
    finally
    {
      e();
    }
  }
  
  public final void a()
  {
    d();
    try
    {
      this.b = 0;
      nativeClear(this.a);
      return;
    }
    finally
    {
      e();
    }
  }
  
  public final int b()
  {
    d();
    try
    {
      int i = nativeGetNumRows(this.a);
      return i;
    }
    finally
    {
      e();
    }
  }
  
  public final byte[] b(int paramInt1, int paramInt2)
  {
    d();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.a, paramInt1 - this.b, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      e();
    }
  }
  
  public final String c(int paramInt1, int paramInt2)
  {
    d();
    try
    {
      String str = nativeGetString(this.a, paramInt1 - this.b, paramInt2);
      return str;
    }
    finally
    {
      e();
    }
  }
  
  public final void c()
  {
    f();
  }
  
  public final long d(int paramInt1, int paramInt2)
  {
    d();
    try
    {
      long l = nativeGetLong(this.a, paramInt1 - this.b, paramInt2);
      return l;
    }
    finally
    {
      e();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final double e(int paramInt1, int paramInt2)
  {
    d();
    try
    {
      double d1 = nativeGetDouble(this.a, paramInt1 - this.b, paramInt2);
      return d1;
    }
    finally
    {
      e();
    }
  }
  
  protected void finalize()
  {
    try
    {
      f();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(" {");
    localStringBuilder.append(Long.toHexString(this.a));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorWindow
 * JD-Core Version:    0.7.0.1
 */