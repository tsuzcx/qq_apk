import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.mediafocus.MediaFocusStackItem;

public final class ajav
  implements Parcelable.Creator<MediaFocusStackItem>
{
  public MediaFocusStackItem a(Parcel paramParcel)
  {
    return new MediaFocusStackItem(paramParcel);
  }
  
  public MediaFocusStackItem[] a(int paramInt)
  {
    return new MediaFocusStackItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajav
 * JD-Core Version:    0.7.0.1
 */