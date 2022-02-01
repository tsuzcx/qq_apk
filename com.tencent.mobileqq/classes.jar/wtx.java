import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wtx
  implements woy<xdq, xfb>
{
  wtx(wtv paramwtv) {}
  
  public void a(@NonNull xdq paramxdq, @Nullable xfb paramxfb, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxfb != null))
    {
      yuk.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramxfb.b));
      this.a.jdField_a_of_type_JavaLangObject = new wty(paramxfb.b, paramxfb.a);
      yuk.c("WeatherDataProvider", "update local weather data.");
      paramxdq = (wta)wth.a(10);
      paramxdq.b("edit_video_weather_filter_data", Integer.valueOf(paramxfb.b));
      paramxdq.b("edit_video_weather_desc", paramxfb.a);
      wtv.a(this.a, System.currentTimeMillis() + 14400000L);
      paramxdq.b("edit_video_weather_expiry_time", Long.valueOf(wtv.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      yuk.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramxdq });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtx
 * JD-Core Version:    0.7.0.1
 */