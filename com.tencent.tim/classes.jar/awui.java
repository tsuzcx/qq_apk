import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.ae.SessionWrap;

public final class awui
  implements Parcelable.Creator<SessionWrap>
{
  public SessionWrap a(Parcel paramParcel)
  {
    return new SessionWrap(paramParcel);
  }
  
  public SessionWrap[] a(int paramInt)
  {
    return new SessionWrap[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awui
 * JD-Core Version:    0.7.0.1
 */