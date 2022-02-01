package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface IDynamicLoader
  extends IInterface
{
  public abstract boolean checkUpdate(long paramLong, boolean paramBoolean);
  
  public abstract void closeLibrary(long paramLong);
  
  public abstract long openLibrary(String paramString);
  
  public abstract boolean updateResourceFromRemote(String paramString1, String paramString2);
  
  public static abstract class Stub
    extends Binder
    implements IDynamicLoader
  {
    private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.IDynamicLoader";
    static final int TRANSACTION_checkUpdate = 3;
    static final int TRANSACTION_closeLibrary = 2;
    static final int TRANSACTION_openLibrary = 1;
    static final int TRANSACTION_updateResourceFromRemote = 4;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.arengine.remoteLoader.IDynamicLoader");
    }
    
    public static IDynamicLoader asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
      if ((localIInterface != null) && ((localIInterface instanceof IDynamicLoader))) {
        return (IDynamicLoader)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int i = 0;
      long l;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.huawei.arengine.remoteLoader.IDynamicLoader");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
        l = openLibrary(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
        closeLibrary(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
        l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          bool = checkUpdate(l, bool);
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
      boolean bool = updateResourceFromRemote(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static class a
      implements IDynamicLoader
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
      
      /* Error */
      public boolean checkUpdate(long paramLong, boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 31
        //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: lload_1
        //   23: invokevirtual 39	android/os/Parcel:writeLong	(J)V
        //   26: iload_3
        //   27: ifeq +61 -> 88
        //   30: iconst_1
        //   31: istore 4
        //   33: aload 6
        //   35: iload 4
        //   37: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   40: aload_0
        //   41: getfield 18	com/huawei/arengine/remoteLoader/IDynamicLoader$Stub$a:a	Landroid/os/IBinder;
        //   44: iconst_3
        //   45: aload 6
        //   47: aload 7
        //   49: iconst_0
        //   50: invokeinterface 49 5 0
        //   55: pop
        //   56: aload 7
        //   58: invokevirtual 52	android/os/Parcel:readException	()V
        //   61: aload 7
        //   63: invokevirtual 56	android/os/Parcel:readInt	()I
        //   66: istore 4
        //   68: iload 4
        //   70: ifeq +24 -> 94
        //   73: iload 5
        //   75: istore_3
        //   76: aload 7
        //   78: invokevirtual 59	android/os/Parcel:recycle	()V
        //   81: aload 6
        //   83: invokevirtual 59	android/os/Parcel:recycle	()V
        //   86: iload_3
        //   87: ireturn
        //   88: iconst_0
        //   89: istore 4
        //   91: goto -58 -> 33
        //   94: iconst_0
        //   95: istore_3
        //   96: goto -20 -> 76
        //   99: astore 8
        //   101: aload 7
        //   103: invokevirtual 59	android/os/Parcel:recycle	()V
        //   106: aload 6
        //   108: invokevirtual 59	android/os/Parcel:recycle	()V
        //   111: aload 8
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	a
        //   0	114	1	paramLong	long
        //   0	114	3	paramBoolean	boolean
        //   31	59	4	i	int
        //   1	73	5	bool	boolean
        //   6	101	6	localParcel1	Parcel
        //   11	91	7	localParcel2	Parcel
        //   99	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	26	99	finally
        //   33	68	99	finally
      }
      
      public void closeLibrary(long paramLong)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
          localParcel1.writeLong(paramLong);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public long openLibrary(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
          localParcel1.writeString(paramString);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean updateResourceFromRemote(String paramString1, String paramString2)
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.arengine.remoteLoader.IDynamicLoader");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
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
 * Qualified Name:     com.huawei.arengine.remoteLoader.IDynamicLoader
 * JD-Core Version:    0.7.0.1
 */