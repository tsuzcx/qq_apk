import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

public final class ajwg
  implements Parcelable.Creator<Comments.Comment>
{
  public Comments.Comment a(Parcel paramParcel)
  {
    return new Comments.Comment(paramParcel);
  }
  
  public Comments.Comment[] a(int paramInt)
  {
    return new Comments.Comment[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwg
 * JD-Core Version:    0.7.0.1
 */