import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qrcode.activity.QMiniResult;

public final class zjw
  implements Parcelable.Creator<QMiniResult>
{
  public QMiniResult a(Parcel paramParcel)
  {
    return new QMiniResult(paramParcel);
  }
  
  public QMiniResult[] a(int paramInt)
  {
    return new QMiniResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjw
 * JD-Core Version:    0.7.0.1
 */