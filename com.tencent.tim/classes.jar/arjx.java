import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.Workspace.SavedState;

public final class arjx
  implements Parcelable.Creator<Workspace.SavedState>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjx
 * JD-Core Version:    0.7.0.1
 */