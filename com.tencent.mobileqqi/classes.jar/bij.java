import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ;

public class bij
  implements IAVServiceForQQ
{
  private IBinder a;
  
  public bij(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.av.service.IAVServiceForQQ";
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      if (paramIAVServiceCallback != null) {
        localIBinder = paramIAVServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel.writeByteArray(paramArrayOfByte);
      this.a.transact(2, localParcel, null, 1);
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
  
  public void b(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(3, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bij
 * JD-Core Version:    0.7.0.1
 */