import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;

public final class rbk
  implements Parcelable.Creator<EditLocalVideoSource>
{
  public EditLocalVideoSource a(Parcel paramParcel)
  {
    return new EditLocalVideoSource(paramParcel);
  }
  
  public EditLocalVideoSource[] a(int paramInt)
  {
    return new EditLocalVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbk
 * JD-Core Version:    0.7.0.1
 */