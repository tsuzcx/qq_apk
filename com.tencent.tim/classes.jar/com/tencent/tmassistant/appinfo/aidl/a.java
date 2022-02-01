package com.tencent.tmassistant.appinfo.aidl;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

class a
  implements IGetAppInfoCallback
{
  private IBinder a;
  
  a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void onGetAppInfoResponse(int paramInt1, int paramInt2, List<AppDetail> paramList)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeTypedList(paramList);
      this.a.transact(1, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.aidl.a
 * JD-Core Version:    0.7.0.1
 */