import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;

public final class vme
  implements Parcelable.Creator<ProfileActivity.CardContactInfo>
{
  public ProfileActivity.CardContactInfo a(Parcel paramParcel)
  {
    ProfileActivity.CardContactInfo localCardContactInfo = new ProfileActivity.CardContactInfo(null);
    localCardContactInfo.aOL = paramParcel.readString();
    localCardContactInfo.phoneNumber = paramParcel.readString();
    localCardContactInfo.aOM = paramParcel.readString();
    return localCardContactInfo;
  }
  
  public ProfileActivity.CardContactInfo[] a(int paramInt)
  {
    return new ProfileActivity.CardContactInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */