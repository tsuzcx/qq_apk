package com.tencent.unipay.plug;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.unipay.plugsdk.IUnipayServiceCallBack;
import com.tencent.unipay.plugsdk.IUnipayServiceCallBack.Stub;

public abstract interface IUnipayService
  extends IInterface
{
  public abstract void Initialize()
    throws RemoteException;
  
  public abstract void MPSaveGameCoin(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, byte[] paramArrayOfByte, String paramString10, String paramString11, String paramString12, String paramString13)
    throws RemoteException;
  
  public abstract void MPSaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, String paramString10, String paramString11, String paramString12)
    throws RemoteException;
  
  public abstract void OpenServiceWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, boolean paramBoolean, String paramString10)
    throws RemoteException;
  
  public abstract void OpenServiceWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9)
    throws RemoteException;
  
  public abstract void SaveGameCoinWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void SaveGameCoinWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void SaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract String getPaySDKVersion()
    throws RemoteException;
  
  public abstract void registerCallback(IUnipayServiceCallBack paramIUnipayServiceCallBack)
    throws RemoteException;
  
  public abstract void setEnv(String paramString)
    throws RemoteException;
  
  public abstract void setLogEnable(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setNumberVisible(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setOfferId(String paramString)
    throws RemoteException;
  
  public abstract void setPropUnit(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IUnipayService
  {
    private static final String DESCRIPTOR = "com.tencent.unipay.plug.IUnipayService";
    static final int TRANSACTION_Initialize = 1;
    static final int TRANSACTION_MPSaveGameCoin = 13;
    static final int TRANSACTION_MPSaveGoods = 14;
    static final int TRANSACTION_OpenServiceWithNum = 9;
    static final int TRANSACTION_OpenServiceWithoutNum = 10;
    static final int TRANSACTION_SaveGameCoinWithNum = 6;
    static final int TRANSACTION_SaveGameCoinWithoutNum = 7;
    static final int TRANSACTION_SaveGoods = 8;
    static final int TRANSACTION_getPaySDKVersion = 12;
    static final int TRANSACTION_registerCallback = 5;
    static final int TRANSACTION_setEnv = 3;
    static final int TRANSACTION_setLogEnable = 4;
    static final int TRANSACTION_setNumberVisible = 11;
    static final int TRANSACTION_setOfferId = 2;
    static final int TRANSACTION_setPropUnit = 15;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.unipay.plug.IUnipayService");
    }
    
    public static IUnipayService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.unipay.plug.IUnipayService");
      if ((localIInterface != null) && ((localIInterface instanceof IUnipayService))) {
        return (IUnipayService)localIInterface;
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
      boolean bool;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      Object localObject;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.unipay.plug.IUnipayService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        Initialize();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        setOfferId(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        setEnv(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          setLogEnable(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        registerCallback(IUnipayServiceCallBack.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        str3 = paramParcel1.readString();
        str4 = paramParcel1.readString();
        str5 = paramParcel1.readString();
        str6 = paramParcel1.readString();
        str7 = paramParcel1.readString();
        str8 = paramParcel1.readString();
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          SaveGameCoinWithNum(str1, str2, str3, str4, str5, str6, str7, str8, (String)localObject, bool, paramParcel1.createByteArray());
          paramParcel2.writeNoException();
          return true;
        }
      case 7: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        SaveGameCoinWithoutNum(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        SaveGoods(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        str3 = paramParcel1.readString();
        str4 = paramParcel1.readString();
        str5 = paramParcel1.readString();
        str6 = paramParcel1.readString();
        str7 = paramParcel1.readString();
        str8 = paramParcel1.readString();
        localObject = paramParcel1.createByteArray();
        String str9 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          OpenServiceWithNum(str1, str2, str3, str4, str5, str6, str7, str8, (byte[])localObject, str9, bool, paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 10: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        OpenServiceWithoutNum(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          setNumberVisible(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 12: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        paramParcel1 = getPaySDKVersion();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        MPSaveGameCoin(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
        MPSaveGoods(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.unipay.plug.IUnipayService");
      setPropUnit(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IUnipayService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void Initialize()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
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
      
      public void MPSaveGameCoin(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, byte[] paramArrayOfByte, String paramString10, String paramString11, String paramString12, String paramString13)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          localParcel1.writeString(paramString6);
          localParcel1.writeString(paramString7);
          localParcel1.writeString(paramString8);
          localParcel1.writeString(paramString9);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeString(paramString10);
          localParcel1.writeString(paramString11);
          localParcel1.writeString(paramString12);
          localParcel1.writeString(paramString13);
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
      
      public void MPSaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, String paramString10, String paramString11, String paramString12)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          localParcel1.writeString(paramString6);
          localParcel1.writeString(paramString7);
          localParcel1.writeString(paramString8);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeString(paramString9);
          localParcel1.writeString(paramString10);
          localParcel1.writeString(paramString11);
          localParcel1.writeString(paramString12);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      public void OpenServiceWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9, boolean paramBoolean, String paramString10)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 14
        //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 15
        //   10: aload 14
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 14
        //   19: aload_1
        //   20: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 14
        //   25: aload_2
        //   26: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 14
        //   31: aload_3
        //   32: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 14
        //   37: aload 4
        //   39: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 14
        //   44: aload 5
        //   46: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload 14
        //   51: aload 6
        //   53: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   56: aload 14
        //   58: aload 7
        //   60: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   63: aload 14
        //   65: aload 8
        //   67: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   70: aload 14
        //   72: aload 9
        //   74: invokevirtual 57	android/os/Parcel:writeByteArray	([B)V
        //   77: aload 14
        //   79: aload 10
        //   81: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   84: iload 11
        //   86: ifeq +53 -> 139
        //   89: iconst_1
        //   90: istore 13
        //   92: aload 14
        //   94: iload 13
        //   96: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   99: aload 14
        //   101: aload 12
        //   103: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   106: aload_0
        //   107: getfield 19	com/tencent/unipay/plug/IUnipayService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   110: bipush 9
        //   112: aload 14
        //   114: aload 15
        //   116: iconst_0
        //   117: invokeinterface 41 5 0
        //   122: pop
        //   123: aload 15
        //   125: invokevirtual 44	android/os/Parcel:readException	()V
        //   128: aload 15
        //   130: invokevirtual 47	android/os/Parcel:recycle	()V
        //   133: aload 14
        //   135: invokevirtual 47	android/os/Parcel:recycle	()V
        //   138: return
        //   139: iconst_0
        //   140: istore 13
        //   142: goto -50 -> 92
        //   145: astore_1
        //   146: aload 15
        //   148: invokevirtual 47	android/os/Parcel:recycle	()V
        //   151: aload 14
        //   153: invokevirtual 47	android/os/Parcel:recycle	()V
        //   156: aload_1
        //   157: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	158	0	this	Proxy
        //   0	158	1	paramString1	String
        //   0	158	2	paramString2	String
        //   0	158	3	paramString3	String
        //   0	158	4	paramString4	String
        //   0	158	5	paramString5	String
        //   0	158	6	paramString6	String
        //   0	158	7	paramString7	String
        //   0	158	8	paramString8	String
        //   0	158	9	paramArrayOfByte	byte[]
        //   0	158	10	paramString9	String
        //   0	158	11	paramBoolean	boolean
        //   0	158	12	paramString10	String
        //   90	51	13	i	int
        //   3	149	14	localParcel1	Parcel
        //   8	139	15	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	84	145	finally
        //   92	128	145	finally
      }
      
      public void OpenServiceWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, String paramString9)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          localParcel1.writeString(paramString6);
          localParcel1.writeString(paramString7);
          localParcel1.writeString(paramString8);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeString(paramString9);
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
      
      /* Error */
      public void SaveGameCoinWithNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 13
        //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 14
        //   10: aload 13
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 13
        //   19: aload_1
        //   20: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 13
        //   25: aload_2
        //   26: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload 13
        //   31: aload_3
        //   32: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload 13
        //   37: aload 4
        //   39: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   42: aload 13
        //   44: aload 5
        //   46: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   49: aload 13
        //   51: aload 6
        //   53: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   56: aload 13
        //   58: aload 7
        //   60: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   63: aload 13
        //   65: aload 8
        //   67: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   70: aload 13
        //   72: aload 9
        //   74: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   77: iload 10
        //   79: ifeq +53 -> 132
        //   82: iconst_1
        //   83: istore 12
        //   85: aload 13
        //   87: iload 12
        //   89: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   92: aload 13
        //   94: aload 11
        //   96: invokevirtual 57	android/os/Parcel:writeByteArray	([B)V
        //   99: aload_0
        //   100: getfield 19	com/tencent/unipay/plug/IUnipayService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   103: bipush 6
        //   105: aload 13
        //   107: aload 14
        //   109: iconst_0
        //   110: invokeinterface 41 5 0
        //   115: pop
        //   116: aload 14
        //   118: invokevirtual 44	android/os/Parcel:readException	()V
        //   121: aload 14
        //   123: invokevirtual 47	android/os/Parcel:recycle	()V
        //   126: aload 13
        //   128: invokevirtual 47	android/os/Parcel:recycle	()V
        //   131: return
        //   132: iconst_0
        //   133: istore 12
        //   135: goto -50 -> 85
        //   138: astore_1
        //   139: aload 14
        //   141: invokevirtual 47	android/os/Parcel:recycle	()V
        //   144: aload 13
        //   146: invokevirtual 47	android/os/Parcel:recycle	()V
        //   149: aload_1
        //   150: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	151	0	this	Proxy
        //   0	151	1	paramString1	String
        //   0	151	2	paramString2	String
        //   0	151	3	paramString3	String
        //   0	151	4	paramString4	String
        //   0	151	5	paramString5	String
        //   0	151	6	paramString6	String
        //   0	151	7	paramString7	String
        //   0	151	8	paramString8	String
        //   0	151	9	paramString9	String
        //   0	151	10	paramBoolean	boolean
        //   0	151	11	paramArrayOfByte	byte[]
        //   83	51	12	i	int
        //   3	142	13	localParcel1	Parcel
        //   8	132	14	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	77	138	finally
        //   85	121	138	finally
      }
      
      public void SaveGameCoinWithoutNum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          localParcel1.writeString(paramString6);
          localParcel1.writeString(paramString7);
          localParcel1.writeString(paramString8);
          localParcel1.writeByteArray(paramArrayOfByte);
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
      
      public void SaveGoods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          localParcel1.writeString(paramString6);
          localParcel1.writeString(paramString7);
          localParcel1.writeString(paramString8);
          localParcel1.writeByteArray(paramArrayOfByte);
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.unipay.plug.IUnipayService";
      }
      
      public String getPaySDKVersion()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public void registerCallback(IUnipayServiceCallBack paramIUnipayServiceCallBack)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 86 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 89	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 19	com/tencent/unipay/plug/IUnipayService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: iconst_5
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 47	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 47	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 47	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	Proxy
        //   0	73	1	paramIUnipayServiceCallBack	IUnipayServiceCallBack
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public void setEnv(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
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
      
      public void setLogEnable(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
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
      
      public void setNumberVisible(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setOfferId(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
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
      
      public void setPropUnit(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plug.IUnipayService");
          localParcel1.writeString(paramString);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.unipay.plug.IUnipayService
 * JD-Core Version:    0.7.0.1
 */