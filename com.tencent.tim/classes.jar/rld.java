import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public final class rld
  implements Parcelable.Creator<PublishParam>
{
  public PublishParam a(Parcel paramParcel)
  {
    return new PublishParam(paramParcel);
  }
  
  public PublishParam[] a(int paramInt)
  {
    return new PublishParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rld
 * JD-Core Version:    0.7.0.1
 */