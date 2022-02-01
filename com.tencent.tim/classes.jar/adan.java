import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.applets.data.AppletItem;

public final class adan
  implements Parcelable.Creator<AppletItem>
{
  public AppletItem a(Parcel paramParcel)
  {
    return new AppletItem(paramParcel);
  }
  
  public AppletItem[] a(int paramInt)
  {
    return new AppletItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adan
 * JD-Core Version:    0.7.0.1
 */