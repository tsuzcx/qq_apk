package com.tencent.wcdb.support;

import android.os.IBinder;
import android.os.Parcel;

class ICancellationSignal$Stub$Proxy
  implements ICancellationSignal
{
  private IBinder mRemote;
  
  ICancellationSignal$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancel()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.wcdb.support.ICancellationSignal");
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.wcdb.support.ICancellationSignal";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.ICancellationSignal.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */