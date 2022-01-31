import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;

public final class ygk
  implements Parcelable.Creator
{
  public ResultRecord a(Parcel paramParcel)
  {
    return new ResultRecord(paramParcel, null);
  }
  
  public ResultRecord[] a(int paramInt)
  {
    return new ResultRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygk
 * JD-Core Version:    0.7.0.1
 */