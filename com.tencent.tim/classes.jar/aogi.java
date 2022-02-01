import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface aogi
  extends IInterface
{
  public abstract void beginSwitch()
    throws RemoteException;
  
  public abstract void doSwitch(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void onProgress(long paramLong1, long paramLong2)
    throws RemoteException;
  
  public abstract void postSwitch(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements aogi
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.theme.ISwitchCallback";
    static final int TRANSACTION_beginSwitch = 1;
    static final int TRANSACTION_doSwitch = 3;
    static final int TRANSACTION_onProgress = 2;
    static final int TRANSACTION_postSwitch = 4;
    
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.theme.ISwitchCallback");
    }
    
    public static aogi asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.theme.ISwitchCallback");
      if ((localIInterface != null) && ((localIInterface instanceof aogi))) {
        return (aogi)localIInterface;
      }
      return new aogi.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.theme.ISwitchCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
        beginSwitch();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
        onProgress(paramParcel1.readLong(), paramParcel1.readLong());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
        doSwitch(paramParcel1.readString(), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
      postSwitch(paramParcel1.readInt());
      return true;
    }
    
    static class a
      implements aogi
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
      
      public void beginSwitch()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void doSwitch(String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void onProgress(long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
          localParcel.writeLong(paramLong1);
          localParcel.writeLong(paramLong2);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void postSwitch(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogi
 * JD-Core Version:    0.7.0.1
 */