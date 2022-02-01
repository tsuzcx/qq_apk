package com.tencent.qmsp.sdk.g.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface a
  extends IInterface
{
  public abstract String a();
  
  public abstract String b();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
      if ((localIInterface == null) || (!(localIInterface instanceof a))) {
        return new a(paramIBinder);
      }
      return (a)localIInterface;
    }
    
    static class a
      implements a
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bun.lib.MsaIdInterface");
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          return "";
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public String b()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bun.lib.MsaIdInterface");
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
          return "";
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean c()
      {
        boolean bool = false;
        localParcel1 = Parcel.obtain();
        localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bun.lib.MsaIdInterface");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            localRemoteException.printStackTrace();
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        localParcel2.recycle();
        localParcel1.recycle();
        return bool;
      }
      
      public boolean d()
      {
        bool = true;
        localParcel1 = Parcel.obtain();
        localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bun.lib.MsaIdInterface");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i == 0) {
            break label65;
          }
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            localRemoteException.printStackTrace();
            bool = false;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        localParcel2.recycle();
        localParcel1.recycle();
        return bool;
      }
      
      public void e()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bun.lib.MsaIdInterface");
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.a
 * JD-Core Version:    0.7.0.1
 */