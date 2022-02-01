import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;

public final class ajwn
  implements Parcelable.Creator<MedalInfo>
{
  public MedalInfo a(Parcel paramParcel)
  {
    return new MedalInfo(paramParcel);
  }
  
  public MedalInfo[] a(int paramInt)
  {
    return new MedalInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwn
 * JD-Core Version:    0.7.0.1
 */