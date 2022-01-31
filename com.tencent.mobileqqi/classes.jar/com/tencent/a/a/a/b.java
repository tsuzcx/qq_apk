package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b
  extends Binder
  implements a
{
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.BaseService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new c(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.assistant.sdk.remote.BaseService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readString(), e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramInt1 = a(e.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
    b(paramParcel1.readString(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */