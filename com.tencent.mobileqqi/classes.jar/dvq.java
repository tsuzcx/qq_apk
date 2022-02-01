import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;

public final class dvq
  implements Parcelable.Creator
{
  public ForwardUtils.SectionBase a(Parcel paramParcel)
  {
    return new ForwardUtils.SectionBase(paramParcel);
  }
  
  public ForwardUtils.SectionBase[] a(int paramInt)
  {
    return new ForwardUtils.SectionBase[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dvq
 * JD-Core Version:    0.7.0.1
 */