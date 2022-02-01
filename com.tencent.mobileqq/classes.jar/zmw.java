import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qrcode.ipc.ScannerParams;

public final class zmw
  implements Parcelable.Creator<ScannerParams>
{
  public ScannerParams a(Parcel paramParcel)
  {
    return new ScannerParams(paramParcel);
  }
  
  public ScannerParams[] a(int paramInt)
  {
    return new ScannerParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmw
 * JD-Core Version:    0.7.0.1
 */