import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public final class omq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omq
 * JD-Core Version:    0.7.0.1
 */