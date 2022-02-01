import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo.Sender;

public final class tnu
  implements Parcelable.Creator<BarrageInfo.Sender>
{
  public BarrageInfo.Sender a(Parcel paramParcel)
  {
    return new BarrageInfo.Sender(paramParcel);
  }
  
  public BarrageInfo.Sender[] a(int paramInt)
  {
    return new BarrageInfo.Sender[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnu
 * JD-Core Version:    0.7.0.1
 */