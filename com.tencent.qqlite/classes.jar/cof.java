import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;

public final class cof
  implements Parcelable.Creator
{
  public SelectMemberActivity.ResultRecord a(Parcel paramParcel)
  {
    return new SelectMemberActivity.ResultRecord(paramParcel, null);
  }
  
  public SelectMemberActivity.ResultRecord[] a(int paramInt)
  {
    return new SelectMemberActivity.ResultRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cof
 * JD-Core Version:    0.7.0.1
 */