import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.ImageInfo;

public final class dw
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.7.0.1
 */