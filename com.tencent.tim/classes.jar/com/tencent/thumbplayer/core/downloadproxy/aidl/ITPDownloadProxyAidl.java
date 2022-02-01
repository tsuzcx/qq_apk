package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.Map;

public abstract interface ITPDownloadProxyAidl
  extends IInterface
{
  public abstract String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract String getNativeInfo(int paramInt)
    throws RemoteException;
  
  public abstract String getPlayErrorCodeStr(int paramInt)
    throws RemoteException;
  
  public abstract String getPlayUrl(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int init(String paramString)
    throws RemoteException;
  
  public abstract int pauseDownload(int paramInt)
    throws RemoteException;
  
  public abstract void pushEvent(int paramInt)
    throws RemoteException;
  
  public abstract int resumeDownload(int paramInt)
    throws RemoteException;
  
  public abstract void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws RemoteException;
  
  public abstract boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
    throws RemoteException;
  
  public abstract void setMaxStorageSizeMB(long paramLong)
    throws RemoteException;
  
  public abstract void setPlayState(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void setUpdatePlayerInfoInterval(int paramInt)
    throws RemoteException;
  
  public abstract void setUserData(Map paramMap)
    throws RemoteException;
  
  public abstract int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
    throws RemoteException;
  
  public abstract int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
    throws RemoteException;
  
  public abstract int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
    throws RemoteException;
  
  public abstract void stopPlay(int paramInt)
    throws RemoteException;
  
  public abstract void stopPreload(int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITPDownloadProxyAidl
  {
    private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
    static final int TRANSACTION_getClipPlayUrl = 6;
    static final int TRANSACTION_getNativeInfo = 14;
    static final int TRANSACTION_getPlayErrorCodeStr = 7;
    static final int TRANSACTION_getPlayUrl = 5;
    static final int TRANSACTION_init = 1;
    static final int TRANSACTION_pauseDownload = 9;
    static final int TRANSACTION_pushEvent = 15;
    static final int TRANSACTION_resumeDownload = 10;
    static final int TRANSACTION_setBusinessDownloadStrategy = 18;
    static final int TRANSACTION_setClipInfo = 4;
    static final int TRANSACTION_setMaxStorageSizeMB = 17;
    static final int TRANSACTION_setPlayState = 16;
    static final int TRANSACTION_setUpdatePlayerInfoInterval = 19;
    static final int TRANSACTION_setUserData = 13;
    static final int TRANSACTION_startClipPlay = 3;
    static final int TRANSACTION_startPlay = 2;
    static final int TRANSACTION_startPreload = 11;
    static final int TRANSACTION_stopPlay = 8;
    static final int TRANSACTION_stopPreload = 12;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
    }
    
    public static ITPDownloadProxyAidl asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      if ((localIInterface != null) && ((localIInterface instanceof ITPDownloadProxyAidl))) {
        return (ITPDownloadProxyAidl)localIInterface;
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
      String str1 = null;
      String str2 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = init(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = startPlay(str1, (TPDownloadParamAidl)localObject, ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = startClipPlay(paramParcel1.readString(), paramParcel1.readInt(), ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        str2 = paramParcel1.readString();
        localObject = str1;
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        boolean bool = setClipInfo(paramInt1, paramInt2, str2, (TPDownloadParamAidl)localObject);
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getPlayUrl(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getClipPlayUrl(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getPlayErrorCodeStr(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        stopPlay(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = pauseDownload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = resumeDownload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        str1 = paramParcel1.readString();
        localObject = str2;
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = startPreload(str1, (TPDownloadParamAidl)localObject, ITPPreLoadListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        stopPreload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setUserData(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getNativeInfo(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        pushEvent(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setPlayState(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setMaxStorageSizeMB(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setBusinessDownloadStrategy(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      setUpdatePlayerInfoInterval(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITPDownloadProxyAidl
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
      
      public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
      }
      
      public String getNativeInfo(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      
      public String getPlayErrorCodeStr(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
      
      public String getPlayUrl(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      
      public int init(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
      
      public int pauseDownload(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void pushEvent(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int resumeDownload(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          localParcel1.writeInt(paramInt5);
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              this.mRemote.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
              paramInt1 = localParcel2.readInt();
              if (paramInt1 != 0) {
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            bool = false;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void setMaxStorageSizeMB(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setPlayState(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setUpdatePlayerInfoInterval(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setUserData(Map paramMap)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeMap(paramMap);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
      public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 34
        //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 70	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 4
        //   25: iload_2
        //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   29: aload_3
        //   30: ifnull +55 -> 85
        //   33: aload_3
        //   34: invokeinterface 107 1 0
        //   39: astore_1
        //   40: aload 4
        //   42: aload_1
        //   43: invokevirtual 110	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   46: aload_0
        //   47: getfield 19	com/tencent/thumbplayer/core/downloadproxy/aidl/ITPDownloadProxyAidl$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   50: iconst_3
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 48 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 51	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 74	android/os/Parcel:readInt	()I
        //   72: istore_2
        //   73: aload 5
        //   75: invokevirtual 58	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 58	android/os/Parcel:recycle	()V
        //   83: iload_2
        //   84: ireturn
        //   85: aconst_null
        //   86: astore_1
        //   87: goto -47 -> 40
        //   90: astore_1
        //   91: aload 5
        //   93: invokevirtual 58	android/os/Parcel:recycle	()V
        //   96: aload 4
        //   98: invokevirtual 58	android/os/Parcel:recycle	()V
        //   101: aload_1
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	Proxy
        //   0	103	1	paramString	String
        //   0	103	2	paramInt	int
        //   0	103	3	paramITPPlayListenerAidl	ITPPlayListenerAidl
        //   3	94	4	localParcel1	Parcel
        //   8	84	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	90	finally
        //   33	40	90	finally
        //   40	73	90	finally
      }
      
      public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              if (paramITPPlayListenerAidl != null)
              {
                paramString = paramITPPlayListenerAidl.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
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
      
      public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              if (paramITPPreLoadListenerAidl != null)
              {
                paramString = paramITPPreLoadListenerAidl.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
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
      
      public void stopPlay(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stopPreload(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
 * JD-Core Version:    0.7.0.1
 */