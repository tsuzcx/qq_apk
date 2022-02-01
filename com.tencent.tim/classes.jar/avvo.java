import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastUrl;

public final class avvo
  implements Parcelable.Creator<BroadcastUrl>
{
  public BroadcastUrl a(Parcel paramParcel)
  {
    return new BroadcastUrl(paramParcel);
  }
  
  public BroadcastUrl[] a(int paramInt)
  {
    return new BroadcastUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvo
 * JD-Core Version:    0.7.0.1
 */