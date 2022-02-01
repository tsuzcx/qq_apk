import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PictureUrl;

public final class avuw
  implements Parcelable.Creator<PictureUrl>
{
  public PictureUrl a(Parcel paramParcel)
  {
    PictureUrl localPictureUrl = new PictureUrl();
    localPictureUrl.url = paramParcel.readString();
    localPictureUrl.width = paramParcel.readInt();
    localPictureUrl.height = paramParcel.readInt();
    localPictureUrl.pictureType = paramParcel.readInt();
    localPictureUrl.pivotXRate = paramParcel.readFloat();
    localPictureUrl.pivotYRate = paramParcel.readFloat();
    localPictureUrl.enlarge_rate = paramParcel.readInt();
    return localPictureUrl;
  }
  
  public PictureUrl[] a(int paramInt)
  {
    return new PictureUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuw
 * JD-Core Version:    0.7.0.1
 */