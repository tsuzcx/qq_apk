package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IAppMainService
  extends IInterface
{
  public abstract void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
    throws RemoteException;
  
  public abstract void preloadMiniApp()
    throws RemoteException;
  
  public abstract Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
    throws RemoteException;
  
  public abstract void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
    throws RemoteException;
  
  public abstract void stopAllMiniApp()
    throws RemoteException;
  
  public abstract void stopMiniApp(MiniAppInfo paramMiniAppInfo)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IAppMainService
  {
    private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.IAppMainService";
    static final int TRANSACTION_onAppLifecycle = 6;
    static final int TRANSACTION_preloadDownloadPackage = 5;
    static final int TRANSACTION_preloadMiniApp = 1;
    static final int TRANSACTION_requestAync = 8;
    static final int TRANSACTION_sendCmd = 7;
    static final int TRANSACTION_startMiniApp = 2;
    static final int TRANSACTION_stopAllMiniApp = 4;
    static final int TRANSACTION_stopMiniApp = 3;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
    }
    
    public static IAppMainService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      if ((localIInterface != null) && ((localIInterface instanceof IAppMainService))) {
        return (IAppMainService)localIInterface;
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
        paramParcel2.writeString("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        preloadMiniApp();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label207;
          }
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label213;
          }
        }
        for (paramParcel1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          startMiniApp((MiniAppInfo)localObject1, (Bundle)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label166;
        }
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          stopMiniApp(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        stopAllMiniApp();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          preloadDownloadPackage(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 6: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        paramInt1 = paramParcel1.readInt();
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label398;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onAppLifecycle(paramInt1, (String)localObject2, (MiniAppInfo)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 7: 
        label166:
        label207:
        label213:
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        label398:
        localObject2 = paramParcel1.readString();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          sendCmd((String)localObject2, str, (Bundle)localObject1, MiniCmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      Object localObject1 = paramParcel1.readString();
      Object localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = requestAync((String)localObject1, (String)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label545;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label545:
        paramParcel2.writeInt(0);
      }
    }
    
    static class Proxy
      implements IAppMainService
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
        return "com.tencent.qqmini.sdk.launcher.ipc.IAppMainService";
      }
      
      public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString);
            if (paramMiniAppInfo != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppInfo.writeToParcel(localParcel1, 0);
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
      
      /* Error */
      public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
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
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 53	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/qqmini/sdk/launcher/ipc/IAppMainService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_5
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
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
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
      
      public void preloadMiniApp()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
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
      
      public Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(8, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString1;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramMiniCmdCallback != null)
              {
                paramString1 = paramMiniCmdCallback.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
            if (paramMiniAppInfo != null)
            {
              localParcel1.writeInt(1);
              paramMiniAppInfo.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                if (paramResultReceiver == null) {
                  break label131;
                }
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
          continue;
          label131:
          localParcel1.writeInt(0);
        }
      }
      
      public void stopAllMiniApp()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
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
      
      /* Error */
      public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
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
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 53	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/qqmini/sdk/launcher/ipc/IAppMainService$Stub$Proxy:mRemote	Landroid/os/IBinder;
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
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IAppMainService
 * JD-Core Version:    0.7.0.1
 */