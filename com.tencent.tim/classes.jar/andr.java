import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo;

public final class andr
  implements Parcelable.Creator<QZoneTitleTabManager.TabInfo>
{
  public QZoneTitleTabManager.TabInfo a(Parcel paramParcel)
  {
    return new QZoneTitleTabManager.TabInfo(paramParcel);
  }
  
  public QZoneTitleTabManager.TabInfo[] a(int paramInt)
  {
    return new QZoneTitleTabManager.TabInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andr
 * JD-Core Version:    0.7.0.1
 */