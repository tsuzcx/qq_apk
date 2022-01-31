import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.intervideo.nowproxy.proxyinner.channel.FromService;

public final class zyx
  implements Parcelable.Creator<FromService>
{
  public FromService a(Parcel paramParcel)
  {
    FromService localFromService = new FromService();
    localFromService.jdField_a_of_type_Int = paramParcel.readInt();
    localFromService.b = paramParcel.readInt();
    localFromService.c = paramParcel.readInt();
    localFromService.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle();
    return localFromService;
  }
  
  public FromService[] a(int paramInt)
  {
    return new FromService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zyx
 * JD-Core Version:    0.7.0.1
 */