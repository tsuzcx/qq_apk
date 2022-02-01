package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avvh;
import java.util.HashMap;
import java.util.Map;

public class WeishiOperationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiOperationInfo> CREATOR = new avvh();
  public String actionUrl;
  public Map<Integer, String> qg = new HashMap();
  
  public WeishiOperationInfo(Parcel paramParcel)
  {
    paramParcel.readMap(this.qg, Map.class.getClassLoader());
    this.actionUrl = paramParcel.readString();
  }
  
  public WeishiOperationInfo(Map<Integer, String> paramMap)
  {
    this.qg = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.qg);
    paramParcel.writeString(this.actionUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.WeishiOperationInfo
 * JD-Core Version:    0.7.0.1
 */