import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo;

public final class iur
  implements Parcelable.Creator<RecvGVideoLevelInfo>
{
  public RecvGVideoLevelInfo a(Parcel paramParcel)
  {
    return new RecvGVideoLevelInfo(paramParcel);
  }
  
  public RecvGVideoLevelInfo[] a(int paramInt)
  {
    return new RecvGVideoLevelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iur
 * JD-Core Version:    0.7.0.1
 */