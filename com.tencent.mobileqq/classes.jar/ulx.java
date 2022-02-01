import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public final class ulx
  implements Parcelable.Creator<WSRedDotPushMsg>
{
  public WSRedDotPushMsg a(Parcel paramParcel)
  {
    return new WSRedDotPushMsg(paramParcel);
  }
  
  public WSRedDotPushMsg[] a(int paramInt)
  {
    return new WSRedDotPushMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulx
 * JD-Core Version:    0.7.0.1
 */