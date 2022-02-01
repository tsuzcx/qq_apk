import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class wva
  extends wfh
{
  public final String a;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  
  public wva(qqstory_service.RspGetLocation paramRspGetLocation)
  {
    this.a = paramRspGetLocation.country.get().toStringUtf8();
    this.c = paramRspGetLocation.province.get().toStringUtf8();
    this.d = paramRspGetLocation.city.get().toStringUtf8();
    this.e = paramRspGetLocation.district.get().toStringUtf8();
    this.f = paramRspGetLocation.street.get().toStringUtf8();
  }
  
  public String toString()
  {
    return "GetLocationResponse{mCountry='" + this.a + '\'' + ", mProvince='" + this.c + '\'' + ", mCity='" + this.d + '\'' + ", mDistrict='" + this.e + '\'' + ", mStreet='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wva
 * JD-Core Version:    0.7.0.1
 */