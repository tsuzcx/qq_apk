package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import bik;

public abstract class IQQServiceCallback$Stub
  extends Binder
  implements IQQServiceCallback
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IQQServiceCallback";
  
  public IQQServiceCallback$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IQQServiceCallback");
  }
  
  public static IQQServiceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IQQServiceCallback))) {
      return (IQQServiceCallback)localIInterface;
    }
    return new bik(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IQQServiceCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceCallback.Stub
 * JD-Core Version:    0.7.0.1
 */