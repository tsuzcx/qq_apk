import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.LocalImageShootInfo;

public final class avus
  implements Parcelable.Creator<LocalImageShootInfo>
{
  public LocalImageShootInfo a(Parcel paramParcel)
  {
    return new LocalImageShootInfo(paramParcel);
  }
  
  public LocalImageShootInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avus
 * JD-Core Version:    0.7.0.1
 */