import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;

public final class bbb
  implements Parcelable.Creator
{
  public ProfileActivity.CardContactInfo a(Parcel paramParcel)
  {
    ProfileActivity.CardContactInfo localCardContactInfo = new ProfileActivity.CardContactInfo(null);
    localCardContactInfo.a = paramParcel.readString();
    localCardContactInfo.c = paramParcel.readString();
    localCardContactInfo.b = paramParcel.readString();
    return localCardContactInfo;
  }
  
  public ProfileActivity.CardContactInfo[] a(int paramInt)
  {
    return new ProfileActivity.CardContactInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bbb
 * JD-Core Version:    0.7.0.1
 */