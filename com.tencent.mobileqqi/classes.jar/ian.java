import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.CirclePageIndicator.SavedState;

public final class ian
  implements Parcelable.Creator
{
  public CirclePageIndicator.SavedState a(Parcel paramParcel)
  {
    return new CirclePageIndicator.SavedState(paramParcel, null);
  }
  
  public CirclePageIndicator.SavedState[] a(int paramInt)
  {
    return new CirclePageIndicator.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ian
 * JD-Core Version:    0.7.0.1
 */