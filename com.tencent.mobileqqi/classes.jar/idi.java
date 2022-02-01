import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.widget.RadioPreference.SavedState;

public final class idi
  implements Parcelable.Creator
{
  public RadioPreference.SavedState a(Parcel paramParcel)
  {
    return new RadioPreference.SavedState(paramParcel);
  }
  
  public RadioPreference.SavedState[] a(int paramInt)
  {
    return new RadioPreference.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     idi
 * JD-Core Version:    0.7.0.1
 */