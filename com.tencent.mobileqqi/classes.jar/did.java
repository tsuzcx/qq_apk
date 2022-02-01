import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;

public final class did
  implements Parcelable.Creator
{
  public SetTroopAdminsActivity.TroopAdmin a(Parcel paramParcel)
  {
    return new SetTroopAdminsActivity.TroopAdmin(paramParcel, null);
  }
  
  public SetTroopAdminsActivity.TroopAdmin[] a(int paramInt)
  {
    return new SetTroopAdminsActivity.TroopAdmin[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     did
 * JD-Core Version:    0.7.0.1
 */