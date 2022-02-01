package com.tencent.moai.database.sqlite;

import android.database.CharArrayBuffer;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import android.util.SparseIntArray;

public class CursorWindow
  extends SQLiteClosable
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new CursorWindow.1();
  private static final String STATS_TAG = "CursorWindowStats";
  private static int sCursorWindowSize = 2097152;
  private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
  private final CloseGuard mCloseGuard = CloseGuard.get();
  private int mCurSizeInByte;
  private int mGrowTimes;
  private final String mName;
  private int mStartPos;
  public int mWindowPtr;
  
  private CursorWindow(Parcel paramParcel)
  {
    this.mStartPos = paramParcel.readInt();
    this.mWindowPtr = nativeCreateFromParcel(paramParcel);
    if (this.mWindowPtr == 0) {
      throw new CursorWindowAllocationException("Cursor window could not be created from binder.");
    }
    this.mName = nativeGetName(this.mWindowPtr);
    this.mCloseGuard.open("close");
  }
  
  public CursorWindow(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (;;)
    {
      this.mName = paramString;
      create(sCursorWindowSize, null);
      return;
      paramString = "<unnamed>";
    }
  }
  
  @Deprecated
  public CursorWindow(boolean paramBoolean)
  {
    this((String)null);
  }
  
  private void create(int paramInt, Throwable paramThrowable)
  {
    int i = paramInt;
    if (paramInt <= 0)
    {
      if (this.mCurSizeInByte == 2147483647) {
        throw new CursorWindowAllocationException("Cursor window cannot allocation more!! grow: " + this.mGrowTimes, paramThrowable);
      }
      i = 2147483647;
    }
    this.mCurSizeInByte = i;
    this.mStartPos = 0;
    this.mWindowPtr = nativeCreate(this.mName, i);
    if (this.mWindowPtr == 0) {
      throw new CursorWindowAllocationException("Cursor window allocation of " + i / 1024 + " kb failed. " + printStats(), paramThrowable);
    }
    this.mCloseGuard.open("close");
    recordNewWindow(Binder.getCallingPid(), this.mWindowPtr);
  }
  
  private void dispose()
  {
    if (this.mCloseGuard != null) {
      this.mCloseGuard.close();
    }
    if (this.mWindowPtr != 0)
    {
      recordClosingOfWindow(this.mWindowPtr);
      nativeDispose(this.mWindowPtr);
      this.mWindowPtr = 0;
    }
  }
  
  public static int getDefaultSize()
  {
    return sCursorWindowSize / 1024;
  }
  
  private static native boolean nativeAllocRow(int paramInt);
  
  private static native void nativeClear(int paramInt);
  
  private static native void nativeCopyStringToBuffer(int paramInt1, int paramInt2, int paramInt3, CharArrayBuffer paramCharArrayBuffer);
  
  private static native int nativeCreate(String paramString, int paramInt);
  
  private static native int nativeCreateFromParcel(Parcel paramParcel);
  
  private static native void nativeDispose(int paramInt);
  
  private static native void nativeFreeLastRow(int paramInt);
  
  private static native byte[] nativeGetBlob(int paramInt1, int paramInt2, int paramInt3);
  
  private static native double nativeGetDouble(int paramInt1, int paramInt2, int paramInt3);
  
  private static native long nativeGetLong(int paramInt1, int paramInt2, int paramInt3);
  
  private static native String nativeGetName(int paramInt);
  
  private static native int nativeGetNumRows(int paramInt);
  
  private static native String nativeGetString(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGetType(int paramInt1, int paramInt2, int paramInt3);
  
  private static native boolean nativePutBlob(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private static native boolean nativePutDouble(int paramInt1, double paramDouble, int paramInt2, int paramInt3);
  
  private static native boolean nativePutLong(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  private static native boolean nativePutNull(int paramInt1, int paramInt2, int paramInt3);
  
  private static native boolean nativePutString(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  private static native boolean nativeSetNumColumns(int paramInt1, int paramInt2);
  
  private static native void nativeWriteToParcel(int paramInt, Parcel paramParcel);
  
  public static CursorWindow newFromParcel(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }
  
  private String printStats()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = Process.myPid();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    for (;;)
    {
      int j;
      int n;
      synchronized (sWindowToPidMap)
      {
        j = sWindowToPidMap.size();
        if (j != 0) {
          break label280;
        }
        return "";
        if (i < j)
        {
          m = sWindowToPidMap.valueAt(i);
          localSparseIntArray.put(m, localSparseIntArray.get(m) + 1);
          i += 1;
          continue;
        }
        int m = localSparseIntArray.size();
        i = 0;
        j = 0;
        if (i >= m) {
          break label223;
        }
        localStringBuilder.append(" (# cursors opened by ");
        n = localSparseIntArray.keyAt(i);
        if (n == k)
        {
          localStringBuilder.append("this proc=");
          n = localSparseIntArray.get(n);
          localStringBuilder.append(n + ")");
          j += n;
          i += 1;
        }
      }
      localObject2.append("pid " + n + "=");
      continue;
      label223:
      if (localObject2.length() > 980) {}
      for (??? = localObject2.substring(0, 980);; ??? = localObject2.toString()) {
        return "# Open Cursors=" + j + (String)???;
      }
      label280:
      int i = 0;
    }
  }
  
  private void recordClosingOfWindow(int paramInt)
  {
    synchronized (sWindowToPidMap)
    {
      if (sWindowToPidMap.size() == 0) {
        return;
      }
      sWindowToPidMap.delete(paramInt);
      return;
    }
  }
  
  private void recordNewWindow(int paramInt1, int paramInt2)
  {
    synchronized (sWindowToPidMap)
    {
      sWindowToPidMap.put(paramInt2, paramInt1);
      if (Log.isLoggable("CursorWindowStats", 2)) {
        SQLiteDebug.Log.i("CursorWindowStats", "Created a new Cursor. " + printStats());
      }
      return;
    }
  }
  
  public static void setDefaultSize(int paramInt)
  {
    if (paramInt > 0) {
      sCursorWindowSize = paramInt * 1024;
    }
  }
  
  public boolean allocRow()
  {
    acquireReference();
    try
    {
      boolean bool = nativeAllocRow(this.mWindowPtr);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void clear()
  {
    acquireReference();
    try
    {
      this.mStartPos = 0;
      nativeClear(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void copyStringToBuffer(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("CharArrayBuffer should not be null");
    }
    acquireReference();
    try
    {
      nativeCopyStringToBuffer(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2, paramCharArrayBuffer);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mCloseGuard != null) {
        this.mCloseGuard.warnIfOpen();
      }
      dispose();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void freeLastRow()
  {
    acquireReference();
    try
    {
      nativeFreeLastRow(this.mWindowPtr);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      byte[] arrayOfByte = nativeGetBlob(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getCurSize()
  {
    return this.mCurSizeInByte / 1024;
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      double d = nativeGetDouble(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return d;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    return (float)getDouble(paramInt1, paramInt2);
  }
  
  public int getGrowTimes()
  {
    return this.mGrowTimes;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    return (int)getLong(paramInt1, paramInt2);
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      long l = nativeGetLong(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return l;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getNumRows()
  {
    acquireReference();
    try
    {
      int i = nativeGetNumRows(this.mWindowPtr);
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    return (short)(int)getLong(paramInt1, paramInt2);
  }
  
  public int getStartPosition()
  {
    return this.mStartPos;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      String str = nativeGetString(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      paramInt1 = nativeGetType(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return paramInt1;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void grow(Throwable paramThrowable)
  {
    dispose();
    int i = sCursorWindowSize;
    int j = this.mGrowTimes + 1;
    this.mGrowTimes = j;
    create(i << j, paramThrowable);
  }
  
  @Deprecated
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    paramInt1 = getType(paramInt1, paramInt2);
    return (paramInt1 == 4) || (paramInt1 == 0);
  }
  
  @Deprecated
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 2;
  }
  
  @Deprecated
  public boolean isLong(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 1;
  }
  
  @Deprecated
  public boolean isNull(int paramInt1, int paramInt2)
  {
    return getType(paramInt1, paramInt2) == 0;
  }
  
  @Deprecated
  public boolean isString(int paramInt1, int paramInt2)
  {
    paramInt1 = getType(paramInt1, paramInt2);
    return (paramInt1 == 3) || (paramInt1 == 0);
  }
  
  protected void onAllReferencesReleased()
  {
    dispose();
  }
  
  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutBlob(this.mWindowPtr, paramArrayOfByte, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutDouble(this.mWindowPtr, paramDouble, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutLong(this.mWindowPtr, paramLong, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putNull(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutNull(this.mWindowPtr, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = nativePutString(this.mWindowPtr, paramString, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    acquireReference();
    try
    {
      boolean bool = nativeSetNumColumns(this.mWindowPtr, paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public String toString()
  {
    return getName() + " {" + Integer.toHexString(this.mWindowPtr) + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    acquireReference();
    try
    {
      paramParcel.writeInt(this.mStartPos);
      nativeWriteToParcel(this.mWindowPtr, paramParcel);
      releaseReference();
      if ((paramInt & 0x1) != 0) {}
      return;
    }
    finally
    {
      releaseReference();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.sqlite.CursorWindow
 * JD-Core Version:    0.7.0.1
 */