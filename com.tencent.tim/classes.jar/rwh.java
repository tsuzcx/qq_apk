import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qrcode.ipc.ScannerParams;

public final class rwh
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwh
 * JD-Core Version:    0.7.0.1
 */