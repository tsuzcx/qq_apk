import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.gdtad.aditem.GdtBaseAdItem;

public final class yjq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjq
 * JD-Core Version:    0.7.0.1
 */