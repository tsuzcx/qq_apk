import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.DLFileInfo;

public final class es
  implements Parcelable.Creator
{
  public DLFileInfo a(Parcel paramParcel)
  {
    return new DLFileInfo(paramParcel, null);
  }
  
  public DLFileInfo[] a(int paramInt)
  {
    return new DLFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     es
 * JD-Core Version:    0.7.0.1
 */