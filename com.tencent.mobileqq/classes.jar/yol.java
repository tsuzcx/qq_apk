import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.subscribe.widget.comment.component.richtext.element.ContentElement;

public final class yol
  implements Parcelable.Creator<ContentElement>
{
  public ContentElement a(Parcel paramParcel)
  {
    return new ContentElement();
  }
  
  public ContentElement[] a(int paramInt)
  {
    return new ContentElement[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yol
 * JD-Core Version:    0.7.0.1
 */