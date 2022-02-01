import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;

public final class zjw
  implements Parcelable.Creator<SlideItemInfo>
{
  public SlideItemInfo a(Parcel paramParcel)
  {
    return new SlideItemInfo(paramParcel);
  }
  
  public SlideItemInfo[] a(int paramInt)
  {
    return new SlideItemInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjw
 * JD-Core Version:    0.7.0.1
 */