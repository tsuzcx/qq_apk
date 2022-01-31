import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem;

public final class xst
  implements Parcelable.Creator
{
  public PacmanParcelItem a(Parcel paramParcel)
  {
    return new PacmanParcelItem(paramParcel);
  }
  
  public PacmanParcelItem[] a(int paramInt)
  {
    return new PacmanParcelItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xst
 * JD-Core Version:    0.7.0.1
 */