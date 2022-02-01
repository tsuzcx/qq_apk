import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class qau
  extends ppu
{
  public final String awD;
  public final int blH;
  
  public qau(qqstory_service.RspGetWeather paramRspGetWeather)
  {
    this.blH = paramRspGetWeather.temperature.get();
    this.awD = paramRspGetWeather.wea_desc.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qau
 * JD-Core Version:    0.7.0.1
 */