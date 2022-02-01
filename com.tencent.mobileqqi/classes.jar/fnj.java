import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.QQPhotoInfo;

public final class fnj
  implements Parcelable.Creator
{
  public QQPhotoInfo a(Parcel paramParcel)
  {
    return new QQPhotoInfo(paramParcel, null);
  }
  
  public QQPhotoInfo[] a(int paramInt)
  {
    return new QQPhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fnj
 * JD-Core Version:    0.7.0.1
 */