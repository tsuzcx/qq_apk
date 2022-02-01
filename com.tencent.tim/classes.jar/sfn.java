import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.subscribe.other.story.VSUploadVideoBean;

public final class sfn
  implements Parcelable.Creator<VSUploadVideoBean>
{
  public VSUploadVideoBean a(Parcel paramParcel)
  {
    return new VSUploadVideoBean(paramParcel);
  }
  
  public VSUploadVideoBean[] a(int paramInt)
  {
    return new VSUploadVideoBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfn
 * JD-Core Version:    0.7.0.1
 */