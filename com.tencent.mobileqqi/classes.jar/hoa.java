import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.agent.datamodel.Friend;

public final class hoa
  implements Parcelable.Creator
{
  public Friend a(Parcel paramParcel)
  {
    Friend localFriend = new Friend();
    localFriend.a = paramParcel.readString();
    localFriend.b = paramParcel.readString();
    localFriend.c = paramParcel.readString();
    localFriend.d = paramParcel.readString();
    return localFriend;
  }
  
  public Friend[] a(int paramInt)
  {
    return new Friend[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hoa
 * JD-Core Version:    0.7.0.1
 */