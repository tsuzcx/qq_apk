import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;

public final class uai
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uai
 * JD-Core Version:    0.7.0.1
 */