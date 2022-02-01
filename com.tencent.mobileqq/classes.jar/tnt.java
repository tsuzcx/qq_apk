import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo;

public final class tnt
  implements Parcelable.Creator<BarrageInfo>
{
  public BarrageInfo a(Parcel paramParcel)
  {
    return new BarrageInfo(paramParcel);
  }
  
  public BarrageInfo[] a(int paramInt)
  {
    return new BarrageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnt
 * JD-Core Version:    0.7.0.1
 */