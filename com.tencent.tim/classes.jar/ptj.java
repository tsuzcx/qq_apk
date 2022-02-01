import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ptj
  implements ppv.b<pzn, qau>
{
  ptj(pth parampth) {}
  
  public void a(@NonNull pzn parampzn, @Nullable qau paramqau, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramqau != null))
    {
      ram.b("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramqau.blH));
      this.a.data = new pth.a(paramqau.blH, paramqau.awD);
      ram.i("WeatherDataProvider", "update local weather data.");
      parampzn = (psr)psx.a(10);
      parampzn.n("edit_video_weather_filter_data", Integer.valueOf(paramqau.blH));
      parampzn.n("edit_video_weather_desc", paramqau.awD);
      pth.a(this.a, System.currentTimeMillis() + 14400000L);
      parampzn.n("edit_video_weather_expiry_time", Long.valueOf(pth.a(this.a)));
      this.a.k(true, this.a.data);
    }
    for (;;)
    {
      this.a.gV = false;
      return;
      ram.w("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, parampzn });
      this.a.k(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptj
 * JD-Core Version:    0.7.0.1
 */