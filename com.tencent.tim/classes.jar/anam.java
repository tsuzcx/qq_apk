import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.friendlist.remote.FriendSingleInfo;

public final class anam
  implements Parcelable.Creator<FriendSingleInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anam
 * JD-Core Version:    0.7.0.1
 */