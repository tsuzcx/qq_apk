import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.RiskInfoItem;

public final class vsu
  implements Parcelable.Creator<RiskInfoItem>
{
  public RiskInfoItem a(Parcel paramParcel)
  {
    return new RiskInfoItem(paramParcel, null);
  }
  
  public RiskInfoItem[] a(int paramInt)
  {
    return new RiskInfoItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsu
 * JD-Core Version:    0.7.0.1
 */