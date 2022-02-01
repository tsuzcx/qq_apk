import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wki
  implements wfk<wub, wvm>
{
  wki(wkg paramwkg) {}
  
  public void a(@NonNull wub paramwub, @Nullable wvm paramwvm, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramwvm != null))
    {
      ykq.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramwvm.b));
      this.a.jdField_a_of_type_JavaLangObject = new wkj(paramwvm.b, paramwvm.a);
      ykq.c("WeatherDataProvider", "update local weather data.");
      paramwub = (wjl)wjs.a(10);
      paramwub.b("edit_video_weather_filter_data", Integer.valueOf(paramwvm.b));
      paramwub.b("edit_video_weather_desc", paramwvm.a);
      wkg.a(this.a, System.currentTimeMillis() + 14400000L);
      paramwub.b("edit_video_weather_expiry_time", Long.valueOf(wkg.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      ykq.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwub });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wki
 * JD-Core Version:    0.7.0.1
 */