import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public final class aczk
  implements Parcelable.Creator<SosoInterface.SosoLbsInfo>
{
  public SosoInterface.SosoLbsInfo a(Parcel paramParcel)
  {
    return new SosoInterface.SosoLbsInfo(paramParcel);
  }
  
  public SosoInterface.SosoLbsInfo[] a(int paramInt)
  {
    return new SosoInterface.SosoLbsInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczk
 * JD-Core Version:    0.7.0.1
 */