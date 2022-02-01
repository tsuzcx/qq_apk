import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.agent.datamodel.Friend;

public final class artk
  implements Parcelable.Creator<Friend>
{
  public Friend a(Parcel paramParcel)
  {
    Friend localFriend = new Friend();
    localFriend.openId = paramParcel.readString();
    localFriend.nickName = paramParcel.readString();
    localFriend.label = paramParcel.readString();
    localFriend.cCh = paramParcel.readString();
    localFriend.ekQ = paramParcel.readInt();
    localFriend.uin = paramParcel.readString();
    return localFriend;
  }
  
  public Friend[] a(int paramInt)
  {
    return new Friend[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artk
 * JD-Core Version:    0.7.0.1
 */