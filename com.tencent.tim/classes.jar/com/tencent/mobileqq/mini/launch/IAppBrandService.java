package com.tencent.mobileqq.mini.launch;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public abstract interface IAppBrandService
  extends IInterface
{
  public abstract void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void preloadMiniApp()
    throws RemoteException;
  
  public abstract void preloadPackage(MiniAppInfo paramMiniAppInfo)
    throws RemoteException;
  
  public abstract void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
    throws RemoteException;
  
  public abstract void startMiniApp(MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IAppBrandService
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.mini.launch.IAppBrandService";
    static final int TRANSACTION_onAppBackground = 5;
    static final int TRANSACTION_onAppForeground = 6;
    static final int TRANSACTION_onAppStart = 4;
    static final int TRANSACTION_onAppStop = 7;
    static final int TRANSACTION_preloadMiniApp = 1;
    static final int TRANSACTION_preloadPackage = 3;
    static final int TRANSACTION_sendCmd = 8;
    static final int TRANSACTION_startMiniApp = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.mini.launch.IAppBrandService");
    }
    
    public static IAppBrandService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      if ((localIInterface != null) && ((localIInterface instanceof IAppBrandService))) {
        return (IAppBrandService)localIInterface;
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
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.mini.launch.IAppBrandService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        preloadMiniApp();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label184;
          }
        }
        for (paramParcel1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          startMiniApp((MiniAppConfig)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          preloadPackage(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label305;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onAppStart(str, (MiniAppConfig)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label384;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onAppBackground(str, (MiniAppConfig)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label463;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onAppForeground(str, (MiniAppConfig)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 7: 
        label184:
        label463:
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        label305:
        str = paramParcel1.readString();
        label384:
        if (paramParcel1.readInt() != 0)
        {
          localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label542;
          }
        }
        label542:
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onAppStop(str, (MiniAppConfig)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (Object localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        sendCmd(str, (Bundle)localObject, CmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class Proxy
      implements IAppBrandService
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
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.mobileqq.mini.launch.IAppBrandService";
      }
      
      public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            localParcel1.writeString(paramString);
            if (paramMiniAppConfig != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppConfig.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            localParcel1.writeString(paramString);
            if (paramMiniAppConfig != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppConfig.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            localParcel1.writeString(paramString);
            if (paramMiniAppConfig != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppConfig.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            localParcel1.writeString(paramString);
            if (paramMiniAppConfig != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppConfig.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void preloadMiniApp()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void preloadPackage(MiniAppInfo paramMiniAppInfo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/mobileqq/mini/launch/IAppBrandService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_3
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 62 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 65	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 68	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 68	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 68	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 68	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramMiniAppInfo	MiniAppInfo
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramCmdCallback != null)
              {
                paramString = paramCmdCallback.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void startMiniApp(MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.mini.launch.IAppBrandService");
            if (paramMiniAppConfig != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppConfig.writeToParcel(localParcel1, 0);
              if (paramResultReceiver != null)
              {
                localParcel1.writeInt(1);
                paramResultReceiver.writeToParcel(localParcel1, 0);
                this.mRemote.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.IAppBrandService
 * JD-Core Version:    0.7.0.1
 */