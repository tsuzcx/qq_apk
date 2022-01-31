import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.common.NoticeParam;

public final class hop
  implements Parcelable.Creator
{
  public NoticeParam a(Parcel paramParcel)
  {
    return new NoticeParam(paramParcel);
  }
  
  public NoticeParam[] a(int paramInt)
  {
    return new NoticeParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hop
 * JD-Core Version:    0.7.0.1
 */