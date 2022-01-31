import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public final class fxt
  implements Parcelable.Creator
{
  public WeiYunFileInfo a(Parcel paramParcel)
  {
    return new WeiYunFileInfo(paramParcel);
  }
  
  public WeiYunFileInfo[] a(int paramInt)
  {
    return new WeiYunFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxt
 * JD-Core Version:    0.7.0.1
 */