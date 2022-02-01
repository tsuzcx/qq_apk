import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;

public final class afvk
  implements Parcelable.Creator<ExtendFriendProfileEditFragment.ExtendFriendInfo>
{
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a(Parcel paramParcel)
  {
    return new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramParcel);
  }
  
  public ExtendFriendProfileEditFragment.ExtendFriendInfo[] a(int paramInt)
  {
    return new ExtendFriendProfileEditFragment.ExtendFriendInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvk
 * JD-Core Version:    0.7.0.1
 */