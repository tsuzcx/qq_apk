import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;

public final class rbv
  implements Parcelable.Creator<EditRecordVideoSource>
{
  public EditRecordVideoSource a(Parcel paramParcel)
  {
    return new EditRecordVideoSource(paramParcel);
  }
  
  public EditRecordVideoSource[] a(int paramInt)
  {
    return new EditRecordVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbv
 * JD-Core Version:    0.7.0.1
 */