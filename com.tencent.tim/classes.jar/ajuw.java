import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;

public final class ajuw
  implements Parcelable.Creator<InterestTagInfo>
{
  public InterestTagInfo a(Parcel paramParcel)
  {
    return new InterestTagInfo(paramParcel);
  }
  
  public InterestTagInfo[] a(int paramInt)
  {
    return new InterestTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuw
 * JD-Core Version:    0.7.0.1
 */