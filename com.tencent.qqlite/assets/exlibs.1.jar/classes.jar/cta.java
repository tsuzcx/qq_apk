import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.FriendListHandler.QQHeadDetails;

public final class cta
  implements Parcelable.Creator
{
  public FriendListHandler.QQHeadDetails a(Parcel paramParcel)
  {
    FriendListHandler.QQHeadDetails localQQHeadDetails = new FriendListHandler.QQHeadDetails(null);
    localQQHeadDetails.jdField_a_of_type_Int = paramParcel.readInt();
    localQQHeadDetails.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localQQHeadDetails.jdField_a_of_type_Long = paramParcel.readLong();
    localQQHeadDetails.jdField_a_of_type_Byte = paramParcel.readByte();
    localQQHeadDetails.b = paramParcel.readString();
    return localQQHeadDetails;
  }
  
  public FriendListHandler.QQHeadDetails[] a(int paramInt)
  {
    return new FriendListHandler.QQHeadDetails[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cta
 * JD-Core Version:    0.7.0.1
 */