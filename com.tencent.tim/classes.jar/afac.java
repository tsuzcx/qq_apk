import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.PrecoverConfig;

public final class afac
  implements Parcelable.Creator<PrecoverConfig>
{
  public PrecoverConfig a(Parcel paramParcel)
  {
    return new PrecoverConfig(paramParcel);
  }
  
  public PrecoverConfig[] a(int paramInt)
  {
    return new PrecoverConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afac
 * JD-Core Version:    0.7.0.1
 */