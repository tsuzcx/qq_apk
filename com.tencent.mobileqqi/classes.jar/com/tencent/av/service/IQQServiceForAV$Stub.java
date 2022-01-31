package com.tencent.av.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import bil;

public abstract class IQQServiceForAV$Stub
  extends Binder
  implements IQQServiceForAV
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.av.service.IQQServiceForAV";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  static final int k = 11;
  static final int l = 12;
  
  public IQQServiceForAV$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IQQServiceForAV");
  }
  
  public static IQQServiceForAV a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceForAV");
    if ((localIInterface != null) && ((localIInterface instanceof IQQServiceForAV))) {
      return (IQQServiceForAV)localIInterface;
    }
    return new bil(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int n = 0;
    int m = 0;
    boolean bool1;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IQQServiceForAV");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label261;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramParcel1 = a(paramInt1, str1, str2, bool1, bool2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label267;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
        bool1 = false;
        break;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      label261:
      label267:
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a();
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
    paramParcel1 = a(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeLongArray(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceForAV.Stub
 * JD-Core Version:    0.7.0.1
 */