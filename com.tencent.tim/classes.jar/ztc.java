import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.TroopClipPic;

public final class ztc
  implements Parcelable.Creator<TroopClipPic>
{
  public TroopClipPic a(Parcel paramParcel)
  {
    return new TroopClipPic(paramParcel);
  }
  
  public TroopClipPic[] a(int paramInt)
  {
    return new TroopClipPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztc
 * JD-Core Version:    0.7.0.1
 */