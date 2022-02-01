import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class a
  implements Parcelable.Creator<QQHeadInfo>
{
  public QQHeadInfo a(Parcel paramParcel)
  {
    QQHeadInfo localQQHeadInfo = new QQHeadInfo();
    localQQHeadInfo.readFromParcel(paramParcel);
    return localQQHeadInfo;
  }
  
  public QQHeadInfo[] a(int paramInt)
  {
    return new QQHeadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     a
 * JD-Core Version:    0.7.0.1
 */