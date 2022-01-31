import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uwq
  implements urr<vgj, vhu>
{
  uwq(uwo paramuwo) {}
  
  public void a(@NonNull vgj paramvgj, @Nullable vhu paramvhu, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramvhu != null))
    {
      wxe.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramvhu.b));
      this.a.jdField_a_of_type_JavaLangObject = new uwr(paramvhu.b, paramvhu.a);
      wxe.c("WeatherDataProvider", "update local weather data.");
      paramvgj = (uvt)uwa.a(10);
      paramvgj.b("edit_video_weather_filter_data", Integer.valueOf(paramvhu.b));
      paramvgj.b("edit_video_weather_desc", paramvhu.a);
      uwo.a(this.a, System.currentTimeMillis() + 14400000L);
      paramvgj.b("edit_video_weather_expiry_time", Long.valueOf(uwo.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      wxe.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramvgj });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwq
 * JD-Core Version:    0.7.0.1
 */