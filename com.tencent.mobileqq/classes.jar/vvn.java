import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vvn
  implements vqp<wfg, wgr>
{
  vvn(vvl paramvvl) {}
  
  public void a(@NonNull wfg paramwfg, @Nullable wgr paramwgr, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwgr != null))
    {
      xvv.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramwgr.b));
      this.a.jdField_a_of_type_JavaLangObject = new vvo(paramwgr.b, paramwgr.a);
      xvv.c("WeatherDataProvider", "update local weather data.");
      paramwfg = (vuq)vux.a(10);
      paramwfg.b("edit_video_weather_filter_data", Integer.valueOf(paramwgr.b));
      paramwfg.b("edit_video_weather_desc", paramwgr.a);
      vvl.a(this.a, System.currentTimeMillis() + 14400000L);
      paramwfg.b("edit_video_weather_expiry_time", Long.valueOf(vvl.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      xvv.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwfg });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvn
 * JD-Core Version:    0.7.0.1
 */