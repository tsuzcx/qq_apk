import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.util.BinderWarpper;

public final class hzj
  implements Parcelable.Creator
{
  public BinderWarpper a(Parcel paramParcel)
  {
    return new BinderWarpper(paramParcel.readStrongBinder());
  }
  
  public BinderWarpper[] a(int paramInt)
  {
    return new BinderWarpper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzj
 * JD-Core Version:    0.7.0.1
 */