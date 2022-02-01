import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.filemanager.data.TroopForwardFileInfo;

public final class atwi
  implements Parcelable.Creator<TroopForwardFileInfo>
{
  public TroopForwardFileInfo a(Parcel paramParcel)
  {
    return new TroopForwardFileInfo(paramParcel);
  }
  
  public TroopForwardFileInfo[] a(int paramInt)
  {
    return new TroopForwardFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwi
 * JD-Core Version:    0.7.0.1
 */