import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.friendlist.remote.FriendSingleInfo;

public final class edm
  implements Parcelable.Creator
{
  public FriendSingleInfo a(Parcel paramParcel)
  {
    return new FriendSingleInfo(paramParcel);
  }
  
  public FriendSingleInfo[] a(int paramInt)
  {
    return new FriendSingleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edm
 * JD-Core Version:    0.7.0.1
 */