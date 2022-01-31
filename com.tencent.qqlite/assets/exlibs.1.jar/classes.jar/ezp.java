import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.UnderlinePageIndicator.SavedState;

public final class ezp
  implements Parcelable.Creator
{
  public UnderlinePageIndicator.SavedState a(Parcel paramParcel)
  {
    return new UnderlinePageIndicator.SavedState(paramParcel, null);
  }
  
  public UnderlinePageIndicator.SavedState[] a(int paramInt)
  {
    return new UnderlinePageIndicator.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezp
 * JD-Core Version:    0.7.0.1
 */