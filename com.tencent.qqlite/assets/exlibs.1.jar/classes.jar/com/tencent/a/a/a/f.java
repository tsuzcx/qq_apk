package com.tencent.a.a.a;

import android.os.IBinder;
import android.os.Parcel;

final class f
  implements d
{
  private IBinder a;
  
  f(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.assistant.sdk.remote.SDKActionCallback");
      localParcel.writeByteArray(paramArrayOfByte);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */