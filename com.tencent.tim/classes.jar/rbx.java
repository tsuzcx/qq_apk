import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;

public final class rbx
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbx
 * JD-Core Version:    0.7.0.1
 */