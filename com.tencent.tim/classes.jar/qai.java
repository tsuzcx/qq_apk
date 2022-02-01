import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class qai
  extends ppu
{
  public final String awA;
  public final String awB;
  public final String awC;
  public final String awy;
  public final String awz;
  
  public qai(qqstory_service.RspGetLocation paramRspGetLocation)
  {
    this.awy = paramRspGetLocation.country.get().toStringUtf8();
    this.awz = paramRspGetLocation.province.get().toStringUtf8();
    this.awA = paramRspGetLocation.city.get().toStringUtf8();
    this.awB = paramRspGetLocation.district.get().toStringUtf8();
    this.awC = paramRspGetLocation.street.get().toStringUtf8();
  }
  
  public String toString()
  {
    return "GetLocationResponse{mCountry='" + this.awy + '\'' + ", mProvince='" + this.awz + '\'' + ", mCity='" + this.awA + '\'' + ", mDistrict='" + this.awB + '\'' + ", mStreet='" + this.awC + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qai
 * JD-Core Version:    0.7.0.1
 */