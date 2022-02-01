import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public final class akbu
  implements Parcelable.Creator<PicInfo>
{
  public PicInfo a(Parcel paramParcel)
  {
    return new PicInfo(paramParcel);
  }
  
  public PicInfo[] a(int paramInt)
  {
    return new PicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbu
 * JD-Core Version:    0.7.0.1
 */