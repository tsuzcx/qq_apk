import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public final class adgi
  implements Parcelable.Creator<ArEffectConfig>
{
  public ArEffectConfig a(Parcel paramParcel)
  {
    return new ArEffectConfig(paramParcel);
  }
  
  public ArEffectConfig[] a(int paramInt)
  {
    return new ArEffectConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgi
 * JD-Core Version:    0.7.0.1
 */