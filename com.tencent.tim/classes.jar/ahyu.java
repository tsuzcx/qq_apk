import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpic.HotPicData;

public final class ahyu
  implements Parcelable.Creator<HotPicData>
{
  public HotPicData a(Parcel paramParcel)
  {
    return new HotPicData(paramParcel);
  }
  
  public HotPicData[] a(int paramInt)
  {
    return new HotPicData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyu
 * JD-Core Version:    0.7.0.1
 */