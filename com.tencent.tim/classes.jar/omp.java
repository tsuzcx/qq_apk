import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;

public final class omp
  implements Parcelable.Creator<WSPushStrategyInfo>
{
  public WSPushStrategyInfo a(Parcel paramParcel)
  {
    return new WSPushStrategyInfo(paramParcel);
  }
  
  public WSPushStrategyInfo[] a(int paramInt)
  {
    return new WSPushStrategyInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omp
 * JD-Core Version:    0.7.0.1
 */