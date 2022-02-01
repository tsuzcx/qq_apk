import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARScanAR;

public final class adeb
  implements Parcelable.Creator<ARScanAR>
{
  public ARScanAR a(Parcel paramParcel)
  {
    return new ARScanAR(paramParcel);
  }
  
  public ARScanAR[] a(int paramInt)
  {
    return new ARScanAR[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adeb
 * JD-Core Version:    0.7.0.1
 */