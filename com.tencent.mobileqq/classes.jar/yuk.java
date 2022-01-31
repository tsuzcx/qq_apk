import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;

public final class yuk
  implements Parcelable.Creator<GdtInterstitialParams>
{
  public GdtInterstitialParams a(Parcel paramParcel)
  {
    return new GdtInterstitialParams(paramParcel);
  }
  
  public GdtInterstitialParams[] a(int paramInt)
  {
    return new GdtInterstitialParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuk
 * JD-Core Version:    0.7.0.1
 */