package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import byv;
import com.tencent.qphone.base.util.QLog;

public abstract class IAIOImageProvider$Stub
  extends Binder
  implements IBinder.DeathRecipient, IAIOImageProvider
{
  private static final String a = "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider";
  static final int f = 1;
  static final int g = 2;
  static final int h = 3;
  static final int i = 4;
  static final int j = 5;
  static final int k = 6;
  static final int l = 7;
  public IAIOImageProviderCallBack a;
  
  protected IAIOImageProvider$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
  }
  
  public static IAIOImageProvider a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    if ((localIInterface != null) && ((localIInterface instanceof IAIOImageProvider))) {
      return (IAIOImageProvider)localIInterface;
    }
    return new byv(paramIBinder);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "binder destoryed");
    }
    this.a = null;
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    try
    {
      paramIAIOImageProviderCallBack.asBinder().linkToDeath(this, 0);
      this.a = paramIAIOImageProviderCallBack;
      return;
    }
    catch (RemoteException paramIAIOImageProviderCallBack)
    {
      binderDied();
    }
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public void binderDied()
  {
    a();
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
    case 1598968902: 
      try
      {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      catch (RuntimeException paramParcel1)
      {
        paramParcel1.printStackTrace();
        throw paramParcel1;
      }
      paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(IAIOImageProviderCallBack.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a(paramParcel1.readLong(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub
 * JD-Core Version:    0.7.0.1
 */