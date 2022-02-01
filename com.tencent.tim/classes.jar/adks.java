import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArWebInfo;

public final class adks
  implements Parcelable.Creator<ArWebInfo>
{
  public ArWebInfo a(Parcel paramParcel)
  {
    return new ArWebInfo(paramParcel);
  }
  
  public ArWebInfo[] a(int paramInt)
  {
    return new ArWebInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adks
 * JD-Core Version:    0.7.0.1
 */