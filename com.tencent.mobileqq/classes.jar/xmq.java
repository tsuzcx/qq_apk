import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;

public final class xmq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xmq
 * JD-Core Version:    0.7.0.1
 */