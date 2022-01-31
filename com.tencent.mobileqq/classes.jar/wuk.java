import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;

public final class wuk
  implements Parcelable.Creator<EditTakePhotoSource>
{
  public EditTakePhotoSource a(Parcel paramParcel)
  {
    return new EditTakePhotoSource(paramParcel);
  }
  
  public EditTakePhotoSource[] a(int paramInt)
  {
    return new EditTakePhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuk
 * JD-Core Version:    0.7.0.1
 */