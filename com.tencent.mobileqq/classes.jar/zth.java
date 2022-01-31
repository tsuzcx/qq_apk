import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.DeviceInfo;

public final class zth
  implements Parcelable.Creator<DeviceInfo>
{
  public DeviceInfo a(Parcel paramParcel)
  {
    DeviceInfo localDeviceInfo = new DeviceInfo();
    localDeviceInfo.osPlatform = paramParcel.readString();
    localDeviceInfo.osVersion = paramParcel.readString();
    localDeviceInfo.netType = paramParcel.readInt();
    localDeviceInfo.netDetail = paramParcel.readString();
    localDeviceInfo.netAddress = paramParcel.readString();
    localDeviceInfo.netAPN = paramParcel.readString();
    localDeviceInfo.name = paramParcel.readString();
    localDeviceInfo.remark = paramParcel.readString();
    localDeviceInfo.type = paramParcel.readString();
    localDeviceInfo.serialNum = paramParcel.readString();
    localDeviceInfo.productId = paramParcel.readInt();
    localDeviceInfo.appSecret = paramParcel.readString();
    localDeviceInfo.din = paramParcel.readLong();
    localDeviceInfo.isAdmin = paramParcel.readInt();
    localDeviceInfo.status = ((short)paramParcel.readInt());
    localDeviceInfo.userStatus = ((short)paramParcel.readInt());
    localDeviceInfo.productType = ((short)paramParcel.readInt());
    localDeviceInfo.displayName = paramParcel.readString();
    localDeviceInfo.productVer = paramParcel.readInt();
    localDeviceInfo.SSOBid_Platform = paramParcel.readInt();
    localDeviceInfo.SSOBid_Version = paramParcel.readString();
    return localDeviceInfo;
  }
  
  public DeviceInfo[] a(int paramInt)
  {
    return new DeviceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zth
 * JD-Core Version:    0.7.0.1
 */