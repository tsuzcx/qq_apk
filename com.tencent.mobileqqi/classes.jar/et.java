import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.ImageInfo;

public final class et
  implements Parcelable.Creator
{
  public ImageInfo a(Parcel paramParcel)
  {
    return new ImageInfo(paramParcel, null);
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     et
 * JD-Core Version:    0.7.0.1
 */