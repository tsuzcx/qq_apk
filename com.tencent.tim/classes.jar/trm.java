import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.intervideo.nowproxy.proxyinner.channel.ToService;

public final class trm
  implements Parcelable.Creator<ToService>
{
  public ToService a(Parcel paramParcel)
  {
    ToService localToService = new ToService();
    localToService.cmd = paramParcel.readInt();
    localToService.subCmd = paramParcel.readInt();
    localToService.seq = paramParcel.readInt();
    localToService.timeout = paramParcel.readInt();
    localToService.EM = paramParcel.readLong();
    localToService.aJJ = paramParcel.readString();
    localToService.k = paramParcel.readBundle();
    return localToService;
  }
  
  public ToService[] a(int paramInt)
  {
    return new ToService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trm
 * JD-Core Version:    0.7.0.1
 */