import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class tot
  extends syn
{
  public final String a;
  public final int b;
  
  public tot(qqstory_service.RspGetWeather paramRspGetWeather)
  {
    this.b = paramRspGetWeather.temperature.get();
    this.a = paramRspGetWeather.wea_desc.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tot
 * JD-Core Version:    0.7.0.1
 */