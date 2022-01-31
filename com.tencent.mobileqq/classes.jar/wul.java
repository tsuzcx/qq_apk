import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;

public final class wul
  implements Parcelable.Creator<EditTakeVideoSource>
{
  public EditTakeVideoSource a(Parcel paramParcel)
  {
    return new EditTakeVideoSource(paramParcel);
  }
  
  public EditTakeVideoSource[] a(int paramInt)
  {
    return new EditTakeVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wul
 * JD-Core Version:    0.7.0.1
 */