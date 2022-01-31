import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.ShieldOperationItem;

public final class fgr
  implements Parcelable.Creator
{
  public ShieldOperationItem a(Parcel paramParcel)
  {
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.jdField_a_of_type_Int = paramParcel.readInt();
    localShieldOperationItem.b = paramParcel.readInt();
    localShieldOperationItem.c = paramParcel.readInt();
    localShieldOperationItem.jdField_a_of_type_ArrayOfLong = paramParcel.createLongArray();
    return localShieldOperationItem;
  }
  
  public ShieldOperationItem[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgr
 * JD-Core Version:    0.7.0.1
 */