import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public final class btd
  implements Parcelable.Creator
{
  public SessionInfo a(Parcel paramParcel)
  {
    return new SessionInfo(paramParcel);
  }
  
  public SessionInfo[] a(int paramInt)
  {
    return new SessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     btd
 * JD-Core Version:    0.7.0.1
 */