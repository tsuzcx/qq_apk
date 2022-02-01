import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class wqc
  implements wld<wzv, xbg>
{
  wqc(wqa paramwqa) {}
  
  public void a(@NonNull wzv paramwzv, @Nullable xbg paramxbg, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramxbg != null))
    {
      yqp.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramxbg.b));
      this.a.jdField_a_of_type_JavaLangObject = new wqd(paramxbg.b, paramxbg.a);
      yqp.c("WeatherDataProvider", "update local weather data.");
      paramwzv = (wpf)wpm.a(10);
      paramwzv.b("edit_video_weather_filter_data", Integer.valueOf(paramxbg.b));
      paramwzv.b("edit_video_weather_desc", paramxbg.a);
      wqa.a(this.a, System.currentTimeMillis() + 14400000L);
      paramwzv.b("edit_video_weather_expiry_time", Long.valueOf(wqa.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      yqp.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramwzv });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */