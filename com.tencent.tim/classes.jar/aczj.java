import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;

public final class aczj
  implements Parcelable.Creator<SosoInterface.SosoCell>
{
  public SosoInterface.SosoCell a(Parcel paramParcel)
  {
    return new SosoInterface.SosoCell(paramParcel);
  }
  
  public SosoInterface.SosoCell[] a(int paramInt)
  {
    return new SosoInterface.SosoCell[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczj
 * JD-Core Version:    0.7.0.1
 */