import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.utils.LightAppSettingInfo;

public final class tan
  implements Parcelable.Creator<LightAppSettingInfo>
{
  public LightAppSettingInfo a(Parcel paramParcel)
  {
    LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
    localLightAppSettingInfo.templateType = paramParcel.readInt();
    localLightAppSettingInfo.bAP = paramParcel.readInt();
    localLightAppSettingInfo.productId = paramParcel.readInt();
    localLightAppSettingInfo.din = paramParcel.readLong();
    localLightAppSettingInfo.oA = paramParcel.readArrayList(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.appId = paramParcel.readString();
    localLightAppSettingInfo.packageName = paramParcel.readString();
    localLightAppSettingInfo.deviceType = paramParcel.readInt();
    localLightAppSettingInfo.aIB = paramParcel.readString();
    localLightAppSettingInfo.aIC = paramParcel.readString();
    localLightAppSettingInfo.openId = paramParcel.readString();
    localLightAppSettingInfo.openKey = paramParcel.readString();
    localLightAppSettingInfo.appName = paramParcel.readString();
    localLightAppSettingInfo.bindType = paramParcel.readInt();
    localLightAppSettingInfo.gs = paramParcel.readHashMap(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.aID = paramParcel.readString();
    return localLightAppSettingInfo;
  }
  
  public LightAppSettingInfo[] a(int paramInt)
  {
    return new LightAppSettingInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tan
 * JD-Core Version:    0.7.0.1
 */