import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ush
  implements uni<vca, vdl>
{
  ush(usf paramusf) {}
  
  public void a(@NonNull vca paramvca, @Nullable vdl paramvdl, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvdl != null))
    {
      wsv.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramvdl.b));
      this.a.jdField_a_of_type_JavaLangObject = new usi(paramvdl.b, paramvdl.a);
      wsv.c("WeatherDataProvider", "update local weather data.");
      paramvca = (urk)urr.a(10);
      paramvca.b("edit_video_weather_filter_data", Integer.valueOf(paramvdl.b));
      paramvca.b("edit_video_weather_desc", paramvdl.a);
      usf.a(this.a, System.currentTimeMillis() + 14400000L);
      paramvca.b("edit_video_weather_expiry_time", Long.valueOf(usf.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      wsv.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramvca });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */