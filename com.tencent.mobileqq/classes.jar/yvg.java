import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;

public final class yvg
  implements Parcelable.Creator<EditLocalPhotoSource>
{
  public EditLocalPhotoSource a(Parcel paramParcel)
  {
    return new EditLocalPhotoSource(paramParcel);
  }
  
  public EditLocalPhotoSource[] a(int paramInt)
  {
    return new EditLocalPhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvg
 * JD-Core Version:    0.7.0.1
 */