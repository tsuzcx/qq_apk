import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public final class zzv
  implements Parcelable.Creator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzv
 * JD-Core Version:    0.7.0.1
 */