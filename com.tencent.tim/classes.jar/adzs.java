import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;

public final class adzs
  implements Parcelable.Creator<CardMobileInfo>
{
  public CardMobileInfo a(Parcel paramParcel)
  {
    return new CardMobileInfo(paramParcel);
  }
  
  public CardMobileInfo[] a(int paramInt)
  {
    return new CardMobileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzs
 * JD-Core Version:    0.7.0.1
 */