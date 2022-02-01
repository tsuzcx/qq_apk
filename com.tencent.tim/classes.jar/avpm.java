import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.WifiInfo;

public final class avpm
  implements Parcelable.Creator<LbsDataV2.WifiInfo>
{
  public LbsDataV2.WifiInfo a(Parcel paramParcel)
  {
    LbsDataV2.WifiInfo localWifiInfo = new LbsDataV2.WifiInfo();
    if (paramParcel != null)
    {
      localWifiInfo.mac = paramParcel.readString();
      localWifiInfo.rssi = paramParcel.readInt();
    }
    return localWifiInfo;
  }
  
  public LbsDataV2.WifiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpm
 * JD-Core Version:    0.7.0.1
 */