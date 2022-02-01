import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.teamwork.PadIdInfo;

public final class aujx
  implements Parcelable.Creator<PadIdInfo>
{
  public PadIdInfo a(Parcel paramParcel)
  {
    return new PadIdInfo(paramParcel);
  }
  
  public PadIdInfo[] a(int paramInt)
  {
    return new PadIdInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujx
 * JD-Core Version:    0.7.0.1
 */