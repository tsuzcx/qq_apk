import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public final class ajva
  implements Parcelable.Creator<BasicTypeDataParcel>
{
  public BasicTypeDataParcel a(Parcel paramParcel)
  {
    return new BasicTypeDataParcel(paramParcel);
  }
  
  public BasicTypeDataParcel[] a(int paramInt)
  {
    return new BasicTypeDataParcel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajva
 * JD-Core Version:    0.7.0.1
 */