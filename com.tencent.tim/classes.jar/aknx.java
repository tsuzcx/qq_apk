import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public final class aknx
  implements Parcelable.Creator<OcrRecogResult>
{
  public OcrRecogResult a(Parcel paramParcel)
  {
    return new OcrRecogResult(paramParcel);
  }
  
  public OcrRecogResult[] a(int paramInt)
  {
    return new OcrRecogResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknx
 * JD-Core Version:    0.7.0.1
 */