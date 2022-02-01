import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;

public final class ymc
  implements Parcelable.Creator<EditTakeGifSource>
{
  public EditTakeGifSource a(Parcel paramParcel)
  {
    return new EditTakeGifSource(paramParcel);
  }
  
  public EditTakeGifSource[] a(int paramInt)
  {
    return new EditTakeGifSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymc
 * JD-Core Version:    0.7.0.1
 */