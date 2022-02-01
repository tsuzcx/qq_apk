import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.intervideo.nowproxy.proxyinner.channel.FromService;

public final class trl
  implements Parcelable.Creator<FromService>
{
  public FromService a(Parcel paramParcel)
  {
    FromService localFromService = new FromService();
    localFromService.cmd = paramParcel.readInt();
    localFromService.subCmd = paramParcel.readInt();
    localFromService.seq = paramParcel.readInt();
    localFromService.U = paramParcel.readBundle();
    return localFromService;
  }
  
  public FromService[] a(int paramInt)
  {
    return new FromService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trl
 * JD-Core Version:    0.7.0.1
 */