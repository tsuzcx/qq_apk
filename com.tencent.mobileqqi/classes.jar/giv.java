import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.friendlist.remote.FriendListInfo;

public final class giv
  implements Parcelable.Creator
{
  public FriendListInfo a(Parcel paramParcel)
  {
    return new FriendListInfo(paramParcel);
  }
  
  public FriendListInfo[] a(int paramInt)
  {
    return new FriendListInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     giv
 * JD-Core Version:    0.7.0.1
 */