package com.tencent.wcdb.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ICancellationSignal$Stub
  extends Binder
  implements ICancellationSignal
{
  private static final String DESCRIPTOR = "com.tencent.wcdb.support.ICancellationSignal";
  static final int TRANSACTION_cancel = 1;
  
  public ICancellationSignal$Stub()
  {
    attachInterface(this, "com.tencent.wcdb.support.ICancellationSignal");
  }
  
  public static ICancellationSignal asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.support.ICancellationSignal");
    if ((localIInterface != null) && ((localIInterface instanceof ICancellationSignal))) {
      return (ICancellationSignal)localIInterface;
    }
    return new ICancellationSignal.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.wcdb.support.ICancellationSignal");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.wcdb.support.ICancellationSignal");
    cancel();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.ICancellationSignal.Stub
 * JD-Core Version:    0.7.0.1
 */