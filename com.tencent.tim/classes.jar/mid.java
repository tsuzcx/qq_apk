import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;

public final class mid
  implements Parcelable.Creator<SocializeFeedsInfo.UGCVoiceInfo>
{
  public SocializeFeedsInfo.UGCVoiceInfo a(Parcel paramParcel)
  {
    return new SocializeFeedsInfo.UGCVoiceInfo(paramParcel);
  }
  
  public SocializeFeedsInfo.UGCVoiceInfo[] a(int paramInt)
  {
    return new SocializeFeedsInfo.UGCVoiceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mid
 * JD-Core Version:    0.7.0.1
 */