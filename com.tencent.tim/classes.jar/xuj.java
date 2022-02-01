import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;

public abstract interface xuj
  extends IInterface
{
  public abstract void a(CompressInfo paramCompressInfo);
  
  public abstract void b(CompressInfo paramCompressInfo);
  
  public abstract void c(CompressInfo paramCompressInfo);
  
  public static abstract class a
    extends Binder
    implements xuj
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
    }
    
    public static xuj a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      if ((localIInterface != null) && ((localIInterface instanceof xuj))) {
        return (xuj)localIInterface;
      }
      return new xuj.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
        a((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
        b((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      c((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
      return true;
    }
    
    static class a
      implements xuj
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(CompressInfo paramCompressInfo)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
          localParcel.writeParcelable(paramCompressInfo, 1);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramCompressInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void b(CompressInfo paramCompressInfo)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
          localParcel.writeParcelable(paramCompressInfo, 1);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramCompressInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(CompressInfo paramCompressInfo)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
          localParcel.writeParcelable(paramCompressInfo, 1);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramCompressInfo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ICompressionCallBack", 2, paramCompressInfo.getMessage(), paramCompressInfo);
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuj
 * JD-Core Version:    0.7.0.1
 */