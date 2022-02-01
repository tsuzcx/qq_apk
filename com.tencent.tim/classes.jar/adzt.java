import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

public final class adzt
  implements Parcelable.Creator<CardOCRInfo>
{
  public CardOCRInfo a(Parcel paramParcel)
  {
    return new CardOCRInfo(paramParcel);
  }
  
  public CardOCRInfo[] a(int paramInt)
  {
    return new CardOCRInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzt
 * JD-Core Version:    0.7.0.1
 */