import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.Comments;

public final class ajwf
  implements Parcelable.Creator<Comments>
{
  public Comments a(Parcel paramParcel)
  {
    return new Comments(paramParcel);
  }
  
  public Comments[] a(int paramInt)
  {
    return new Comments[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwf
 * JD-Core Version:    0.7.0.1
 */