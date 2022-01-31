import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.LBSInfo;

public final class jk
  implements Parcelable.Creator
{
  public LBSInfo a(Parcel paramParcel)
  {
    return new LBSInfo(paramParcel);
  }
  
  public LBSInfo[] a(int paramInt)
  {
    return new LBSInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     jk
 * JD-Core Version:    0.7.0.1
 */