import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;

public final class wys
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wys
 * JD-Core Version:    0.7.0.1
 */