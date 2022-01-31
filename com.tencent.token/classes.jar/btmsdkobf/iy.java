package btmsdkobf;

import android.os.IBinder;
import android.os.Parcel;

class iy
  implements eu
{
  private IBinder a;
  
  iy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
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
      return paramString1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.iy
 * JD-Core Version:    0.7.0.1
 */