import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.SpecialCareInfo;

public final class afaj
  implements Parcelable.Creator<SpecialCareInfo>
{
  public SpecialCareInfo a(Parcel paramParcel)
  {
    return new SpecialCareInfo(paramParcel);
  }
  
  public SpecialCareInfo[] a(int paramInt)
  {
    return new SpecialCareInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afaj
 * JD-Core Version:    0.7.0.1
 */