import android.text.TextUtils;

public class wtv
  extends wsg<wty>
{
  private long jdField_a_of_type_Long;
  private wvd jdField_a_of_type_Wvd = new wtw(this);
  protected boolean a;
  
  public wtv()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (wta)wth.a(10);
    this.jdField_a_of_type_Long = ((Long)((wta)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((wta)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((wta)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        yuk.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new wty(i, (String)localObject);
        return;
      }
    }
    yuk.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public wty a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (wty)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    yuk.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    xdq localxdq = new xdq(1, paramInt1, paramInt2);
    wow.a().a(localxdq, new wtx(this));
  }
  
  protected void a(wuz paramwuz)
  {
    yuk.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      yuk.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    wva localwva = (wva)wth.a(9);
    wuz localwuz = paramwuz;
    if (paramwuz == null) {
      localwuz = localwva.b();
    }
    if (localwuz != null)
    {
      a(localwuz.b, localwuz.a);
      return;
    }
    localwva.a(this.jdField_a_of_type_Wvd);
    localwva.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtv
 * JD-Core Version:    0.7.0.1
 */