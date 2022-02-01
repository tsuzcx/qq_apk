import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;

public final class adzu
  implements Parcelable.Creator<CardUinInfo>
{
  public CardUinInfo a(Parcel paramParcel)
  {
    return new CardUinInfo(paramParcel);
  }
  
  public CardUinInfo[] a(int paramInt)
  {
    return new CardUinInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzu
 * JD-Core Version:    0.7.0.1
 */