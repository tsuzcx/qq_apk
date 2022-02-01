import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;

public final class msb
  implements Parcelable.Creator<LikeAnimationInfo>
{
  public LikeAnimationInfo a(Parcel paramParcel)
  {
    return new LikeAnimationInfo(paramParcel);
  }
  
  public LikeAnimationInfo[] a(int paramInt)
  {
    return new LikeAnimationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msb
 * JD-Core Version:    0.7.0.1
 */