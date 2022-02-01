import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.SendInfo;

public final class ea
  implements Parcelable.Creator<SendInfo>
{
  public SendInfo a(Parcel paramParcel)
  {
    return new SendInfo(paramParcel, null);
  }
  
  public SendInfo[] a(int paramInt)
  {
    return new SendInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.7.0.1
 */