import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;

public final class mig
  implements Parcelable.Creator<TopicInfo>
{
  public TopicInfo a(Parcel paramParcel)
  {
    return new TopicInfo(paramParcel);
  }
  
  public TopicInfo[] a(int paramInt)
  {
    return new TopicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mig
 * JD-Core Version:    0.7.0.1
 */