import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.Workspace.SavedState;

public final class hib
  implements Parcelable.Creator
{
  public Workspace.SavedState a(Parcel paramParcel)
  {
    return new Workspace.SavedState(paramParcel, null);
  }
  
  public Workspace.SavedState[] a(int paramInt)
  {
    return new Workspace.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hib
 * JD-Core Version:    0.7.0.1
 */