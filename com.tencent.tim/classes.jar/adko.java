import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;

public final class adko
  implements Parcelable.Creator<ArFeatureInfo>
{
  public ArFeatureInfo a(Parcel paramParcel)
  {
    return new ArFeatureInfo(paramParcel);
  }
  
  public ArFeatureInfo[] a(int paramInt)
  {
    return new ArFeatureInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adko
 * JD-Core Version:    0.7.0.1
 */