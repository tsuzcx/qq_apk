package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.List;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;

public abstract interface IWtloginService
  extends IInterface
{
  public abstract int CheckPictureAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int CheckSMSAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int CloseCode(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte, int paramInt, List paramList, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int GetA1WithA1(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int GetStWithPasswd(String paramString1, String paramString2, long paramLong, String paramString3, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int GetStWithoutPasswd(String paramString1, String paramString2, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int RefreshPictureData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int RefreshSMSData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract int VerifyCode(String paramString1, String paramString2, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public abstract void removeRemoteHelper(String paramString)
    throws RemoteException;
  
  public abstract void setTestHost(String paramString1, int paramInt, String paramString2, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IWtloginService
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IWtloginService";
    static final int TRANSACTION_CheckPictureAndGetSt = 4;
    static final int TRANSACTION_CheckSMSAndGetSt = 10;
    static final int TRANSACTION_CloseCode = 7;
    static final int TRANSACTION_GetA1WithA1 = 8;
    static final int TRANSACTION_GetStWithPasswd = 1;
    static final int TRANSACTION_GetStWithoutPasswd = 3;
    static final int TRANSACTION_RefreshPictureData = 5;
    static final int TRANSACTION_RefreshSMSData = 9;
    static final int TRANSACTION_VerifyCode = 6;
    static final int TRANSACTION_removeRemoteHelper = 2;
    static final int TRANSACTION_setTestHost = 11;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IWtloginService");
    }
    
    public static IWtloginService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IWtloginService");
      if ((localIInterface != null) && ((localIInterface instanceof IWtloginService))) {
        return (IWtloginService)localIInterface;
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
      Object localObject1;
      String str;
      long l1;
      Object localObject2;
      WUserSigInfo localWUserSigInfo;
      long l2;
      Object localObject3;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.qphone.base.remote.IWtloginService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = GetStWithPasswd((String)localObject1, str, l1, (String)localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        removeRemoteHelper(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        l2 = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = GetStWithoutPasswd((String)localObject1, str, l1, l2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject2 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = CheckPictureAndGetSt((String)localObject1, str, (byte[])localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = RefreshPictureData((String)localObject1, str, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 6: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        boolean bool;
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          localObject2 = paramParcel1.createByteArray();
          localObject3 = paramParcel1.createIntArray();
          paramInt1 = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0) {
            break label598;
          }
        }
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = VerifyCode((String)localObject1, str, l1, bool, (byte[])localObject2, (int[])localObject3, paramInt1, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
          bool = false;
          break;
        }
      case 7: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        localObject2 = paramParcel1.createByteArray();
        paramInt1 = paramParcel1.readInt();
        localObject3 = paramParcel1.readArrayList(getClass().getClassLoader());
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = CloseCode((String)localObject1, str, l1, (byte[])localObject2, paramInt1, (List)localObject3, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 8: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        str = paramParcel1.readString();
        localObject2 = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        l2 = paramParcel1.readLong();
        localObject3 = paramParcel1.createByteArray();
        long l3 = paramParcel1.readLong();
        long l4 = paramParcel1.readLong();
        long l5 = paramParcel1.readLong();
        byte[] arrayOfByte1 = paramParcel1.createByteArray();
        byte[] arrayOfByte2 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0)
        {
          localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label876;
          }
        }
        for (localObject1 = (WFastLoginInfo)WFastLoginInfo.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          paramInt1 = GetA1WithA1(str, (String)localObject2, l1, l2, (byte[])localObject3, l3, l4, l5, arrayOfByte1, arrayOfByte2, localWUserSigInfo, (WFastLoginInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
          localWUserSigInfo = null;
          break;
        }
      case 9: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = RefreshSMSData((String)localObject1, str, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 10: 
        label598:
        label876:
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject1 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject2 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {}
        for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
        {
          paramInt1 = CheckSMSAndGetSt((String)localObject1, str, (byte[])localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      setTestHost(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IWtloginService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public int CheckPictureAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeByteArray(paramArrayOfByte);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int CheckSMSAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeByteArray(paramArrayOfByte);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int CloseCode(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte, int paramInt, List paramList, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeLong(paramLong);
            localParcel1.writeByteArray(paramArrayOfByte);
            localParcel1.writeInt(paramInt);
            localParcel1.writeList(paramList);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramInt = localParcel2.readInt();
                return paramInt;
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
      
      public int GetA1WithA1(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            localParcel1.writeByteArray(paramArrayOfByte1);
            localParcel1.writeLong(paramLong3);
            localParcel1.writeLong(paramLong4);
            localParcel1.writeLong(paramLong5);
            localParcel1.writeByteArray(paramArrayOfByte2);
            localParcel1.writeByteArray(paramArrayOfByte3);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramWFastLoginInfo != null)
              {
                localParcel1.writeInt(1);
                paramWFastLoginInfo.writeToParcel(localParcel1, 0);
                if (paramIWtloginServiceCallbacker == null) {
                  break label214;
                }
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label214:
          paramString1 = null;
        }
      }
      
      public int GetStWithPasswd(String paramString1, String paramString2, long paramLong, String paramString3, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeLong(paramLong);
            localParcel1.writeString(paramString3);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int GetStWithoutPasswd(String paramString1, String paramString2, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeLong(paramLong1);
            localParcel1.writeLong(paramLong2);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int RefreshPictureData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int RefreshSMSData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramWUserSigInfo != null)
            {
              localParcel1.writeInt(1);
              paramWUserSigInfo.writeToParcel(localParcel1, 0);
              if (paramIWtloginServiceCallbacker != null)
              {
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public int VerifyCode(String paramString1, String paramString2, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label179:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeLong(paramLong);
            if (paramBoolean)
            {
              localParcel1.writeInt(i);
              localParcel1.writeByteArray(paramArrayOfByte);
              localParcel1.writeIntArray(paramArrayOfInt);
              localParcel1.writeInt(paramInt);
              if (paramWUserSigInfo != null)
              {
                localParcel1.writeInt(1);
                paramWUserSigInfo.writeToParcel(localParcel1, 0);
                if (paramIWtloginServiceCallbacker == null) {
                  break label179;
                }
                paramString1 = paramIWtloginServiceCallbacker.asBinder();
                localParcel1.writeStrongBinder(paramString1);
                this.mRemote.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
                paramInt = localParcel2.readInt();
                return paramInt;
              }
            }
            else
            {
              i = 0;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.qphone.base.remote.IWtloginService";
      }
      
      public void removeRemoteHelper(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
          localParcel1.writeString(paramString);
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
      
      /* Error */
      public void setTestHost(String paramString1, int paramInt, String paramString2, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: aload_1
        //   20: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 5
        //   25: iload_2
        //   26: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   29: aload 5
        //   31: aload_3
        //   32: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 4
        //   37: ifnull +50 -> 87
        //   40: aload 4
        //   42: invokeinterface 59 1 0
        //   47: astore_1
        //   48: aload 5
        //   50: aload_1
        //   51: invokevirtual 62	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 19	com/tencent/qphone/base/remote/IWtloginService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   58: bipush 11
        //   60: aload 5
        //   62: aload 6
        //   64: iconst_0
        //   65: invokeinterface 68 5 0
        //   70: pop
        //   71: aload 6
        //   73: invokevirtual 71	android/os/Parcel:readException	()V
        //   76: aload 6
        //   78: invokevirtual 78	android/os/Parcel:recycle	()V
        //   81: aload 5
        //   83: invokevirtual 78	android/os/Parcel:recycle	()V
        //   86: return
        //   87: aconst_null
        //   88: astore_1
        //   89: goto -41 -> 48
        //   92: astore_1
        //   93: aload 6
        //   95: invokevirtual 78	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: invokevirtual 78	android/os/Parcel:recycle	()V
        //   103: aload_1
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	Proxy
        //   0	105	1	paramString1	String
        //   0	105	2	paramInt	int
        //   0	105	3	paramString2	String
        //   0	105	4	paramIWtloginServiceCallbacker	IWtloginServiceCallbacker
        //   3	96	5	localParcel1	Parcel
        //   8	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	35	92	finally
        //   40	48	92	finally
        //   48	76	92	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService
 * JD-Core Version:    0.7.0.1
 */