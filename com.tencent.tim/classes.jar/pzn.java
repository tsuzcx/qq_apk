import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetWeather;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pzn
  extends ppw<qau>
{
  private static final String CMD = ppf.fQ("StorySvc.get_weather");
  public final int blt;
  public final int blu;
  public final int mCoordinate;
  
  public pzn(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCoordinate = paramInt1;
    this.blt = paramInt2;
    this.blu = paramInt3;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetWeather localRspGetWeather = new qqstory_service.RspGetWeather();
    try
    {
      localRspGetWeather.mergeFrom(paramArrayOfByte);
      return new qau(localRspGetWeather);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetWeather localReqGetWeather = new qqstory_service.ReqGetWeather();
    localReqGetWeather.coordinate.set(this.mCoordinate);
    localReqGetWeather.longitude.set(this.blt);
    localReqGetWeather.latitude.set(this.blu);
    return localReqGetWeather.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzn
 * JD-Core Version:    0.7.0.1
 */