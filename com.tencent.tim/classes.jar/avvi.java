import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiPictureUrl;

public final class avvi
  implements Parcelable.Creator<WeishiPictureUrl>
{
  public WeishiPictureUrl a(Parcel paramParcel)
  {
    return new WeishiPictureUrl(paramParcel);
  }
  
  public WeishiPictureUrl[] a(int paramInt)
  {
    return new WeishiPictureUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvi
 * JD-Core Version:    0.7.0.1
 */