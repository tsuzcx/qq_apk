import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.richmedia.subtitles.BarrageParcelItem;

public final class aatl
  implements Parcelable.Creator<BarrageParcelItem>
{
  public BarrageParcelItem a(Parcel paramParcel)
  {
    return new BarrageParcelItem(paramParcel);
  }
  
  public BarrageParcelItem[] a(int paramInt)
  {
    return new BarrageParcelItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatl
 * JD-Core Version:    0.7.0.1
 */