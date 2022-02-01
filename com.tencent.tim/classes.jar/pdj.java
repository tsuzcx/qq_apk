import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;

public final class pdj
  implements Parcelable.Creator<QCircleWebViewTitleStyle>
{
  public QCircleWebViewTitleStyle a(Parcel paramParcel)
  {
    return new QCircleWebViewTitleStyle(paramParcel);
  }
  
  public QCircleWebViewTitleStyle[] a(int paramInt)
  {
    return new QCircleWebViewTitleStyle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdj
 * JD-Core Version:    0.7.0.1
 */