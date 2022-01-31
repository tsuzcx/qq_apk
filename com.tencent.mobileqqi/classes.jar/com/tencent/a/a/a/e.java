package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class e
  extends Binder
  implements d
{
  public e()
  {
    attachInterface(this, "com.tencent.assistant.sdk.remote.SDKActionCallback");
  }
  
  public static d a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.SDKActionCallback");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new f(paramIBinder);
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
      paramParcel2.writeString("com.tencent.assistant.sdk.remote.SDKActionCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.SDKActionCallback");
    a(paramParcel1.createByteArray());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */