package com.tencent.unipay.plugsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IUnipayServiceCallBack
  extends IInterface
{
  public abstract void UnipayCallBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void UnipayNeedLogin()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IUnipayServiceCallBack
  {
    private static final String DESCRIPTOR = "com.tencent.unipay.plugsdk.IUnipayServiceCallBack";
    static final int TRANSACTION_UnipayCallBack = 2;
    static final int TRANSACTION_UnipayNeedLogin = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
    }
    
    public static IUnipayServiceCallBack asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
      if ((localIInterface != null) && ((localIInterface instanceof IUnipayServiceCallBack))) {
        return (IUnipayServiceCallBack)localIInterface;
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
        paramParcel2.writeString("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
        UnipayNeedLogin();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
      UnipayCallBack(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IUnipayServiceCallBack
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void UnipayCallBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          localParcel1.writeInt(paramInt5);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
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
      
      public void UnipayNeedLogin()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.unipay.plugsdk.IUnipayServiceCallBack");
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.unipay.plugsdk.IUnipayServiceCallBack";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.unipay.plugsdk.IUnipayServiceCallBack
 * JD-Core Version:    0.7.0.1
 */