import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.api.interstitial.GdtInterstitialStatus;

public final class thu
  implements Parcelable.Creator<GdtInterstitialStatus>
{
  public GdtInterstitialStatus a(Parcel paramParcel)
  {
    return new GdtInterstitialStatus(paramParcel);
  }
  
  public GdtInterstitialStatus[] a(int paramInt)
  {
    return new GdtInterstitialStatus[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thu
 * JD-Core Version:    0.7.0.1
 */