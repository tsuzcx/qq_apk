import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;

public final class vay
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vay
 * JD-Core Version:    0.7.0.1
 */