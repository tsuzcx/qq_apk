package com.huawei.arengine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public abstract interface IAREngine
  extends IInterface
{
  public abstract int[] getMetaData();
  
  public abstract ParcelFileDescriptor getSharedFile(String paramString);
  
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
  
  public static abstract class Stub
    extends Binder
    implements IAREngine
  {
    private static final String DESCRIPTOR = "com.huawei.arengine.service.IAREngine";
    static final int TRANSACTION_getMetaData = 3;
    static final int TRANSACTION_getSharedFile = 4;
    static final int TRANSACTION_getVersionCode = 2;
    static final int TRANSACTION_getVersionName = 1;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.arengine.service.IAREngine");
    }
    
    public static IAREngine asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.service.IAREngine");
      if ((localIInterface != null) && ((localIInterface instanceof IAREngine))) {
        return (IAREngine)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.huawei.arengine.service.IAREngine");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
        paramParcel1 = getVersionName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
        paramInt1 = getVersionCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
        paramParcel1 = getMetaData();
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
      paramParcel1 = getSharedFile(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    static class a
      implements IAREngine
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public int[] getMetaData()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int[] arrayOfInt = localParcel2.createIntArray();
          return arrayOfInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public ParcelFileDescriptor getSharedFile(String paramString)
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/huawei/arengine/service/IAREngine$Stub$a:a	Landroid/os/IBinder;
        //   23: iconst_4
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 41 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 44	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 59	android/os/Parcel:readInt	()I
        //   41: ifeq +26 -> 67
        //   44: getstatic 65	android/os/ParcelFileDescriptor:CREATOR	Landroid/os/Parcelable$Creator;
        //   47: aload_3
        //   48: invokeinterface 71 2 0
        //   53: checkcast 61	android/os/ParcelFileDescriptor
        //   56: astore_1
        //   57: aload_3
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 50	android/os/Parcel:recycle	()V
        //   65: aload_1
        //   66: areturn
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -12 -> 57
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 50	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramString	String
        //   3	75	2	localParcel1	Parcel
        //   7	67	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	57	72	finally
      }
      
      public int getVersionCode()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getVersionName()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.arengine.service.IAREngine
 * JD-Core Version:    0.7.0.1
 */