import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;

public final class agna
  implements Parcelable.Creator<FavFileInfo>
{
  public FavFileInfo a(Parcel paramParcel)
  {
    return new FavFileInfo(paramParcel);
  }
  
  public FavFileInfo[] a(int paramInt)
  {
    return new FavFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agna
 * JD-Core Version:    0.7.0.1
 */