import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.CirclePageIndicator.SavedState;

public final class autc
  implements Parcelable.Creator<CirclePageIndicator.SavedState>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autc
 * JD-Core Version:    0.7.0.1
 */