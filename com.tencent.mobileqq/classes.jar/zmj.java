import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qrcode.activity.ScannerResult;

public final class zmj
  implements Parcelable.Creator<ScannerResult>
{
  public ScannerResult a(Parcel paramParcel)
  {
    return new ScannerResult(paramParcel);
  }
  
  public ScannerResult[] a(int paramInt)
  {
    return new ScannerResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmj
 * JD-Core Version:    0.7.0.1
 */