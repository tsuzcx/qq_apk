package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import bij;

public abstract class IAVServiceForQQ$Stub
  extends Binder
  implements IAVServiceForQQ
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IAVServiceForQQ";
  static final int b = 2;
  static final int c = 3;
  
  public IAVServiceForQQ$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
  }
  
  public static IAVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IAVServiceForQQ))) {
      return (IAVServiceForQQ)localIInterface;
    }
    return new bij(paramIBinder);
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
      paramParcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
    b(paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.IAVServiceForQQ.Stub
 * JD-Core Version:    0.7.0.1
 */