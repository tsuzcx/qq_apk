import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;

public final class anzw
  implements Parcelable.Creator<SharePolicyInfo>
{
  public SharePolicyInfo a(Parcel paramParcel)
  {
    return new SharePolicyInfo(paramParcel);
  }
  
  public SharePolicyInfo[] a(int paramInt)
  {
    return new SharePolicyInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzw
 * JD-Core Version:    0.7.0.1
 */