import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;

public final class zsc
  implements Parcelable.Creator<PhotoSendParams>
{
  public PhotoSendParams a(Parcel paramParcel)
  {
    return new PhotoSendParams(paramParcel);
  }
  
  public PhotoSendParams[] a(int paramInt)
  {
    return new PhotoSendParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsc
 * JD-Core Version:    0.7.0.1
 */