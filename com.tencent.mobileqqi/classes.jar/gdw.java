import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.CompressInfo;

public final class gdw
  implements Parcelable.Creator
{
  public CompressInfo a(Parcel paramParcel)
  {
    return new CompressInfo(paramParcel, null);
  }
  
  public CompressInfo[] a(int paramInt)
  {
    return new CompressInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdw
 * JD-Core Version:    0.7.0.1
 */