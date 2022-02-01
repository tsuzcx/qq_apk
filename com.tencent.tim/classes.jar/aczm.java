import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;

public final class aczm
  implements Parcelable.Creator<SosoInterface.SosoWifi>
{
  public SosoInterface.SosoWifi a(Parcel paramParcel)
  {
    return new SosoInterface.SosoWifi(paramParcel);
  }
  
  public SosoInterface.SosoWifi[] a(int paramInt)
  {
    return new SosoInterface.SosoWifi[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczm
 * JD-Core Version:    0.7.0.1
 */