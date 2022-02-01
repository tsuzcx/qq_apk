package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public abstract interface ITPPlayListenerAidl
  extends IInterface
{
  public abstract long getAdvRemainTime()
    throws RemoteException;
  
  public abstract String getContentType(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract int getCurrentPlayClipNo()
    throws RemoteException;
  
  public abstract long getCurrentPosition()
    throws RemoteException;
  
  public abstract String getDataFilePath(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract long getDataTotalSize(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract String getPlayInfo(String paramString)
    throws RemoteException;
  
  public abstract long getPlayerBufferLength()
    throws RemoteException;
  
  public abstract void onDownloadCdnUrlExpired(Map paramMap)
    throws RemoteException;
  
  public abstract void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;
  
  public abstract void onDownloadCdnUrlUpdate(String paramString)
    throws RemoteException;
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void onDownloadFinish()
    throws RemoteException;
  
  public abstract void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    throws RemoteException;
  
  public abstract void onDownloadProtocolUpdate(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void onDownloadStatusUpdate(int paramInt)
    throws RemoteException;
  
  public abstract void onPcdnDownloadFailed(String paramString)
    throws RemoteException;
  
  public abstract int onPlayCallback(int paramInt, List paramList)
    throws RemoteException;
  
  public abstract void onQuicDownloadStatusUpdate(String paramString)
    throws RemoteException;
  
  public abstract int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    throws RemoteException;
  
  public abstract int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    throws RemoteException;
  
  public abstract int onStopReadData(int paramInt1, String paramString, int paramInt2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITPPlayListenerAidl
  {
    private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
    static final int TRANSACTION_getAdvRemainTime = 14;
    static final int TRANSACTION_getContentType = 21;
    static final int TRANSACTION_getCurrentPlayClipNo = 13;
    static final int TRANSACTION_getCurrentPosition = 12;
    static final int TRANSACTION_getDataFilePath = 20;
    static final int TRANSACTION_getDataTotalSize = 19;
    static final int TRANSACTION_getPlayInfo = 15;
    static final int TRANSACTION_getPlayerBufferLength = 11;
    static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
    static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
    static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
    static final int TRANSACTION_onDownloadError = 3;
    static final int TRANSACTION_onDownloadFinish = 2;
    static final int TRANSACTION_onDownloadProgressUpdate = 1;
    static final int TRANSACTION_onDownloadProtocolUpdate = 9;
    static final int TRANSACTION_onDownloadStatusUpdate = 8;
    static final int TRANSACTION_onPcdnDownloadFailed = 22;
    static final int TRANSACTION_onPlayCallback = 4;
    static final int TRANSACTION_onQuicDownloadStatusUpdate = 10;
    static final int TRANSACTION_onReadData = 17;
    static final int TRANSACTION_onStartReadData = 16;
    static final int TRANSACTION_onStopReadData = 18;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
    }
    
    public static ITPPlayListenerAidl asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      if ((localIInterface != null) && ((localIInterface instanceof ITPPlayListenerAidl))) {
        return (ITPPlayListenerAidl)localIInterface;
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
      long l;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadProgressUpdate(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadFinish();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadError(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramInt1 = onPlayCallback(paramParcel1.readInt(), paramParcel1.readArrayList(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadCdnUrlUpdate(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadCdnUrlInfoUpdate(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadCdnUrlExpired(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadStatusUpdate(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onDownloadProtocolUpdate(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        onQuicDownloadStatusUpdate(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        l = getPlayerBufferLength();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        l = getCurrentPosition();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramInt1 = getCurrentPlayClipNo();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        l = getAdvRemainTime();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramParcel1 = getPlayInfo(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramInt1 = onStartReadData(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramInt1 = onReadData(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramInt1 = onStopReadData(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        l = getDataTotalSize(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramParcel1 = getDataFilePath(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
        paramParcel1 = getContentType(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
      onPcdnDownloadFailed(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITPPlayListenerAidl
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
      
      public long getAdvRemainTime()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      
      public String getContentType(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getCurrentPlayClipNo()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
      
      public long getCurrentPosition()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      public String getDataFilePath(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public long getDataTotalSize(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
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
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
      }
      
      public String getPlayInfo(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public long getPlayerBufferLength()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public void onDownloadCdnUrlExpired(Map paramMap)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeMap(paramMap);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadCdnUrlUpdate(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadError(int paramInt1, int paramInt2, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadFinish()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          localParcel1.writeString(paramString);
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
      
      public void onDownloadProtocolUpdate(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onDownloadStatusUpdate(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
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
      
      public void onPcdnDownloadFailed(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int onPlayCallback(int paramInt, List paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeList(paramList);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
      
      public void onQuicDownloadStatusUpdate(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
      
      public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
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
      
      public int onStopReadData(int paramInt1, String paramString, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
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
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
 * JD-Core Version:    0.7.0.1
 */