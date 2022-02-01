import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.poi.PoiInfo;

public final class ayaf
  implements Parcelable.Creator<PoiInfo>
{
  public PoiInfo a(Parcel paramParcel)
  {
    return new PoiInfo(paramParcel, null);
  }
  
  public PoiInfo[] a(int paramInt)
  {
    return new PoiInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayaf
 * JD-Core Version:    0.7.0.1
 */