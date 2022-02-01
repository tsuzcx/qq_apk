package com.tencent.qmsp.sdk.g.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface d
  extends IInterface
{
  public static abstract class a
    extends Binder
    implements d
  {
    public static d a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.heytap.openid.IOpenID");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static class a
      implements d
    {
      public IBinder a;
      
      public a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a(String paramString1, String paramString2, String paramString3)
      {
        String str = "";
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.heytap.openid.IOpenID");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          localParcel2.recycle();
          localParcel1.recycle();
          return paramString1;
        }
        finally
        {
          for (;;)
          {
            localParcel2.recycle();
            localParcel1.recycle();
            try
            {
              throw paramString1;
            }
            catch (RemoteException paramString1)
            {
              paramString1.printStackTrace();
              paramString1 = str;
            }
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.d
 * JD-Core Version:    0.7.0.1
 */