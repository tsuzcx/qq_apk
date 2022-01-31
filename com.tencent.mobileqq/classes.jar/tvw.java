import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqcircle.events.QCircleFakeFeed;

public final class tvw
  implements Parcelable.Creator<QCircleFakeFeed>
{
  public QCircleFakeFeed a(Parcel paramParcel)
  {
    return new QCircleFakeFeed(paramParcel);
  }
  
  public QCircleFakeFeed[] a(int paramInt)
  {
    return new QCircleFakeFeed[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvw
 * JD-Core Version:    0.7.0.1
 */