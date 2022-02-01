import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.TempLiteMailIndexInfo;

public final class atnh
  implements Parcelable.Creator<DingdongPluginBizObserver.TempLiteMailIndexInfo>
{
  public DingdongPluginBizObserver.TempLiteMailIndexInfo a(Parcel paramParcel)
  {
    DingdongPluginBizObserver.TempLiteMailIndexInfo localTempLiteMailIndexInfo = new DingdongPluginBizObserver.TempLiteMailIndexInfo();
    localTempLiteMailIndexInfo.feedId = paramParcel.readString();
    localTempLiteMailIndexInfo.sourceType = paramParcel.readInt();
    localTempLiteMailIndexInfo.ayz = paramParcel.readLong();
    return localTempLiteMailIndexInfo;
  }
  
  public DingdongPluginBizObserver.TempLiteMailIndexInfo[] a(int paramInt)
  {
    return new DingdongPluginBizObserver.TempLiteMailIndexInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnh
 * JD-Core Version:    0.7.0.1
 */