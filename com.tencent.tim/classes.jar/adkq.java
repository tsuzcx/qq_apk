import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArModelResource;

public final class adkq
  implements Parcelable.Creator<ArModelResource>
{
  public ArModelResource a(Parcel paramParcel)
  {
    return new ArModelResource(paramParcel);
  }
  
  public ArModelResource[] a(int paramInt)
  {
    return new ArModelResource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkq
 * JD-Core Version:    0.7.0.1
 */