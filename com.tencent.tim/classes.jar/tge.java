import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtBaseAdItem;

public final class tge
  implements Parcelable.Creator<GdtBaseAdItem>
{
  public GdtBaseAdItem a(Parcel paramParcel)
  {
    return new GdtBaseAdItem(paramParcel);
  }
  
  public GdtBaseAdItem[] a(int paramInt)
  {
    return new GdtBaseAdItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tge
 * JD-Core Version:    0.7.0.1
 */