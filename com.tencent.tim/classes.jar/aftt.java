import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;

public final class aftt
  implements Parcelable.Creator<MiniAppRecommInfo>
{
  public MiniAppRecommInfo a(Parcel paramParcel)
  {
    return new MiniAppRecommInfo(paramParcel);
  }
  
  public MiniAppRecommInfo[] a(int paramInt)
  {
    return new MiniAppRecommInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftt
 * JD-Core Version:    0.7.0.1
 */