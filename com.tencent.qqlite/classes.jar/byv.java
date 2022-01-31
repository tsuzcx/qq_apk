import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.qphone.base.util.QLog;

public class byv
  implements IAIOImageProviderCallBack
{
  private IBinder a;
  
  public byv(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeLong(paramLong1);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeInt(paramInt3);
      localParcel.writeLong(paramLong2);
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeInt(paramInt3);
      localParcel.writeString(paramString);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, paramString.getMessage(), paramString);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeTypedArray(paramArrayOfAIOImageData, 0);
      localParcel.writeInt(paramInt);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramArrayOfAIOImageData)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProviderCallBack", 2, paramArrayOfAIOImageData.getMessage(), paramArrayOfAIOImageData);
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
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     byv
 * JD-Core Version:    0.7.0.1
 */