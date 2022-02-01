import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;

public final class aczu
  implements Parcelable.Creator<FriendsStatusUtil.UpdateFriendStatusItem>
{
  public FriendsStatusUtil.UpdateFriendStatusItem a(Parcel paramParcel)
  {
    return new FriendsStatusUtil.UpdateFriendStatusItem(paramParcel);
  }
  
  public FriendsStatusUtil.UpdateFriendStatusItem[] a(int paramInt)
  {
    return new FriendsStatusUtil.UpdateFriendStatusItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczu
 * JD-Core Version:    0.7.0.1
 */