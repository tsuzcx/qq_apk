package cooperation.mailplugin.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IMailRemoteInterface
  extends IInterface
{
  public abstract boolean transfer(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IMailRemoteInterface
  {
    private static final String DESCRIPTOR = "cooperation.mailplugin.ipc.IMailRemoteInterface";
    static final int TRANSACTION_transfer = 1;
    
    public Stub()
    {
      attachInterface(this, "cooperation.mailplugin.ipc.IMailRemoteInterface");
    }
    
    public static IMailRemoteInterface asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.mailplugin.ipc.IMailRemoteInterface");
      if ((localIInterface != null) && ((localIInterface instanceof IMailRemoteInterface))) {
        return (IMailRemoteInterface)localIInterface;
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
        paramParcel2.writeString("cooperation.mailplugin.ipc.IMailRemoteInterface");
        return true;
      }
      paramParcel1.enforceInterface("cooperation.mailplugin.ipc.IMailRemoteInterface");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        boolean bool = transfer(str, paramParcel1);
        paramParcel2.writeNoException();
        if (!bool) {
          break label110;
        }
      }
      label110:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
        paramParcel1 = null;
        break;
      }
    }
    
    static class Proxy
      implements IMailRemoteInterface
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
        return "cooperation.mailplugin.ipc.IMailRemoteInterface";
      }
      
      public boolean transfer(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("cooperation.mailplugin.ipc.IMailRemoteInterface");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              int i = localParcel2.readInt();
              if (i != 0) {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.mailplugin.ipc.IMailRemoteInterface
 * JD-Core Version:    0.7.0.1
 */