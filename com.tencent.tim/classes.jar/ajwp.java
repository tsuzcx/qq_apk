import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.MedalItem;

public final class ajwp
  implements Parcelable.Creator<MedalItem>
{
  public MedalItem a(Parcel paramParcel)
  {
    return new MedalItem(paramParcel);
  }
  
  public MedalItem[] a(int paramInt)
  {
    return new MedalItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwp
 * JD-Core Version:    0.7.0.1
 */