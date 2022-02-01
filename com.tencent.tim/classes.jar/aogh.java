import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface aogh
  extends IInterface
{
  public abstract void onComplete(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements aogh
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.theme.IDownloadListener";
    static final int TRANSACTION_onComplete = 2;
    static final int TRANSACTION_onProgress = 1;
    
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.theme.IDownloadListener");
    }
    
    public static aogh asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.theme.IDownloadListener");
      if ((localIInterface != null) && ((localIInterface instanceof aogh))) {
        return (aogh)localIInterface;
      }
      return new aogh.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.theme.IDownloadListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.theme.IDownloadListener");
        onProgress(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.IDownloadListener");
      onComplete(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements aogh
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void onComplete(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.theme.IDownloadListener");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
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
      
      public void onProgress(String paramString, long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.theme.IDownloadListener");
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogh
 * JD-Core Version:    0.7.0.1
 */