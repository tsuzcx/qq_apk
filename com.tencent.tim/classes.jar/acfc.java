import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails;

public final class acfc
  implements Parcelable.Creator<FriendListHandler.QQHeadDetails>
{
  public FriendListHandler.QQHeadDetails a(Parcel paramParcel)
  {
    FriendListHandler.QQHeadDetails localQQHeadDetails = new FriendListHandler.QQHeadDetails(null);
    localQQHeadDetails.userType = paramParcel.readInt();
    localQQHeadDetails.boh = paramParcel.readString();
    localQQHeadDetails.headImgTimestamp = paramParcel.readLong();
    localQQHeadDetails.bb = paramParcel.readByte();
    return localQQHeadDetails;
  }
  
  public FriendListHandler.QQHeadDetails[] a(int paramInt)
  {
    return new FriendListHandler.QQHeadDetails[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfc
 * JD-Core Version:    0.7.0.1
 */