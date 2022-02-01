import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.event.ExoticEvent;

public final class avtv
  implements Parcelable.Creator<ExoticEvent>
{
  public ExoticEvent a(Parcel paramParcel)
  {
    return new ExoticEvent(paramParcel, null);
  }
  
  public ExoticEvent[] a(int paramInt)
  {
    return new ExoticEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtv
 * JD-Core Version:    0.7.0.1
 */