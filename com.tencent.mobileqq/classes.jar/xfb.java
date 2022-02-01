import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class xfb
  extends wov
{
  public final String a;
  public final int b;
  
  public xfb(qqstory_service.RspGetWeather paramRspGetWeather)
  {
    this.b = paramRspGetWeather.temperature.get();
    this.a = paramRspGetWeather.wea_desc.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfb
 * JD-Core Version:    0.7.0.1
 */