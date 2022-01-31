package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface RemotePluginManager
  extends IInterface
{
  public abstract void cancelInstall(String paramString)
    throws RemoteException;
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
    throws RemoteException;
  
  public abstract boolean isPlugininstalled(String paramString)
    throws RemoteException;
  
  public abstract boolean isReady()
    throws RemoteException;
  
  public abstract PluginBaseInfo queryPlugin(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements RemotePluginManager
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.RemotePluginManager";
    static final int TRANSACTION_cancelInstall = 4;
    static final int TRANSACTION_installPlugin = 1;
    static final int TRANSACTION_isPlugininstalled = 2;
    static final int TRANSACTION_isReady = 5;
    static final int TRANSACTION_queryPlugin = 3;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.pluginsdk.RemotePluginManager");
    }
    
    public static RemotePluginManager asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      if ((localIInterface != null) && ((localIInterface instanceof RemotePluginManager))) {
        return (RemotePluginManager)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int j = 0;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        installPlugin(paramParcel1.readString(), OnPluginInstallListener.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        bool = isPlugininstalled(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        paramParcel1 = queryPlugin(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        cancelInstall(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      boolean bool = isReady();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static class Proxy
      implements RemotePluginManager
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void cancelInstall(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.mobileqq.pluginsdk.RemotePluginManager";
      }
      
      /* Error */
      public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 34
        //   12: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +45 -> 66
        //   24: aload_2
        //   25: invokeinterface 61 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 64	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_0
        //   37: getfield 19	com/tencent/mobileqq/pluginsdk/RemotePluginManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: iconst_1
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 46 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 49	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 52	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 52	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -37 -> 31
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 52	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 52	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramString	String
        //   0	83	2	paramOnPluginInstallListener	OnPluginInstallListener
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	71	finally
        //   24	31	71	finally
        //   31	56	71	finally
      }
      
      public boolean isPlugininstalled(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      
      public boolean isReady()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public PluginBaseInfo queryPlugin(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 34
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 19	com/tencent/mobileqq/pluginsdk/RemotePluginManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   23: iconst_3
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 46 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 49	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 70	android/os/Parcel:readInt	()I
        //   41: ifeq +26 -> 67
        //   44: getstatic 80	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   47: aload_3
        //   48: invokeinterface 86 2 0
        //   53: checkcast 76	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
        //   56: astore_1
        //   57: aload_3
        //   58: invokevirtual 52	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 52	android/os/Parcel:recycle	()V
        //   65: aload_1
        //   66: areturn
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -12 -> 57
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 52	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 52	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramString	String
        //   3	75	2	localParcel1	Parcel
        //   7	67	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	57	72	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.RemotePluginManager
 * JD-Core Version:    0.7.0.1
 */