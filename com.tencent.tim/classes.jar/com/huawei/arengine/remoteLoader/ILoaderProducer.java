package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface ILoaderProducer
  extends IInterface
{
  public abstract IDynamicLoader newDynamicLoader(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2);
  
  public static abstract class Stub
    extends Binder
    implements ILoaderProducer
  {
    private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.ILoaderProducer";
    static final int TRANSACTION_newDynamicLoader = 1;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.arengine.remoteLoader.ILoaderProducer");
    }
    
    public static ILoaderProducer asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.ILoaderProducer");
      if ((localIInterface != null) && ((localIInterface instanceof ILoaderProducer))) {
        return (ILoaderProducer)localIInterface;
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
        paramParcel2.writeString("com.huawei.arengine.remoteLoader.ILoaderProducer");
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.ILoaderProducer");
      paramParcel1 = newDynamicLoader(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    static class a
      implements ILoaderProducer
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
      public IDynamicLoader newDynamicLoader(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 31
        //   16: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +77 -> 97
        //   23: aload_1
        //   24: invokeinterface 39 1 0
        //   29: astore_1
        //   30: aload 4
        //   32: aload_1
        //   33: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_3
        //   37: astore_1
        //   38: aload_2
        //   39: ifnull +10 -> 49
        //   42: aload_2
        //   43: invokeinterface 39 1 0
        //   48: astore_1
        //   49: aload 4
        //   51: aload_1
        //   52: invokevirtual 42	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   55: aload_0
        //   56: getfield 18	com/huawei/arengine/remoteLoader/ILoaderProducer$Stub$a:a	Landroid/os/IBinder;
        //   59: iconst_1
        //   60: aload 4
        //   62: aload 5
        //   64: iconst_0
        //   65: invokeinterface 48 5 0
        //   70: pop
        //   71: aload 5
        //   73: invokevirtual 51	android/os/Parcel:readException	()V
        //   76: aload 5
        //   78: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   81: invokestatic 60	com/huawei/arengine/remoteLoader/IDynamicLoader$Stub:asInterface	(Landroid/os/IBinder;)Lcom/huawei/arengine/remoteLoader/IDynamicLoader;
        //   84: astore_1
        //   85: aload 5
        //   87: invokevirtual 63	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: invokevirtual 63	android/os/Parcel:recycle	()V
        //   95: aload_1
        //   96: areturn
        //   97: aconst_null
        //   98: astore_1
        //   99: goto -69 -> 30
        //   102: astore_1
        //   103: aload 5
        //   105: invokevirtual 63	android/os/Parcel:recycle	()V
        //   108: aload 4
        //   110: invokevirtual 63	android/os/Parcel:recycle	()V
        //   113: aload_1
        //   114: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	115	0	this	a
        //   0	115	1	paramIObjectWrapper1	IObjectWrapper
        //   0	115	2	paramIObjectWrapper2	IObjectWrapper
        //   1	36	3	localObject	Object
        //   5	104	4	localParcel1	Parcel
        //   10	94	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	19	102	finally
        //   23	30	102	finally
        //   30	36	102	finally
        //   42	49	102	finally
        //   49	85	102	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.ILoaderProducer
 * JD-Core Version:    0.7.0.1
 */