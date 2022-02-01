import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.ShieldOperationItem;

public final class aclq
  implements Parcelable.Creator<ShieldOperationItem>
{
  public ShieldOperationItem a(Parcel paramParcel)
  {
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.opType = paramParcel.readInt();
    localShieldOperationItem.source_id = paramParcel.readInt();
    localShieldOperationItem.source_sub_id = paramParcel.readInt();
    localShieldOperationItem.f = paramParcel.createLongArray();
    localShieldOperationItem.fromType = paramParcel.readInt();
    return localShieldOperationItem;
  }
  
  public ShieldOperationItem[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclq
 * JD-Core Version:    0.7.0.1
 */