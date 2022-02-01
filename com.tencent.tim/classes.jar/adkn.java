import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;

public final class adkn
  implements Parcelable.Creator<ArDefaultSetting>
{
  public ArDefaultSetting a(Parcel paramParcel)
  {
    return new ArDefaultSetting(paramParcel);
  }
  
  public ArDefaultSetting[] a(int paramInt)
  {
    return new ArDefaultSetting[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkn
 * JD-Core Version:    0.7.0.1
 */