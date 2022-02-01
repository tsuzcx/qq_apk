import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;

public final class anzq
  implements Parcelable.Creator<DocsGrayTipsInfo>
{
  public DocsGrayTipsInfo a(Parcel paramParcel)
  {
    return new DocsGrayTipsInfo(paramParcel);
  }
  
  public DocsGrayTipsInfo[] a(int paramInt)
  {
    return new DocsGrayTipsInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzq
 * JD-Core Version:    0.7.0.1
 */