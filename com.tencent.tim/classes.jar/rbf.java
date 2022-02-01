import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;

public final class rbf
  implements Parcelable.Creator<EditLocalGifSource>
{
  public EditLocalGifSource a(Parcel paramParcel)
  {
    return new EditLocalGifSource(paramParcel);
  }
  
  public EditLocalGifSource[] a(int paramInt)
  {
    return new EditLocalGifSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbf
 * JD-Core Version:    0.7.0.1
 */