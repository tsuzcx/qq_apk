import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo;

public final class edq
  implements Parcelable.Creator
{
  public FriendGroupListInfo a(Parcel paramParcel)
  {
    return new FriendGroupListInfo(paramParcel);
  }
  
  public FriendGroupListInfo[] a(int paramInt)
  {
    return new FriendGroupListInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edq
 * JD-Core Version:    0.7.0.1
 */