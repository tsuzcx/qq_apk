import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;

public final class yqt
  implements Parcelable.Creator<AddFriendBlockedInfo>
{
  public AddFriendBlockedInfo a(Parcel paramParcel)
  {
    return new AddFriendBlockedInfo(paramParcel);
  }
  
  public AddFriendBlockedInfo[] a(int paramInt)
  {
    return new AddFriendBlockedInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqt
 * JD-Core Version:    0.7.0.1
 */