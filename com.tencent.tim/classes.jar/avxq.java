import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface avxq
  extends IInterface
{
  public abstract void abV(int paramInt)
    throws RemoteException;
  
  public abstract void bn(float paramFloat)
    throws RemoteException;
  
  public abstract void eBB()
    throws RemoteException;
  
  public abstract void onDownloadCancel()
    throws RemoteException;
  
  public abstract void onDownloadSuccess()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements avxq
  {
    public a()
    {
      attachInterface(this, "cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
    }
    
    public static avxq a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      if ((localIInterface != null) && ((localIInterface instanceof avxq))) {
        return (avxq)localIInterface;
      }
      return new avxq.a.a(paramIBinder);
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
        paramParcel2.writeString("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
        eBB();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
        bn(paramParcel1.readFloat());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
        onDownloadCancel();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
        onDownloadSuccess();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
      abV(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements avxq
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void abV(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
          localParcel1.writeInt(paramInt);
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void bn(float paramFloat)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
          localParcel1.writeFloat(paramFloat);
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
      
      public void eBB()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
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
      
      public void onDownloadCancel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
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
      
      public void onDownloadSuccess()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZoneLiveSoDownloadListener");
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxq
 * JD-Core Version:    0.7.0.1
 */