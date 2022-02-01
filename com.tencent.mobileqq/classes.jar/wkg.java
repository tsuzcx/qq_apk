import android.text.TextUtils;

public class wkg
  extends wir<wkj>
{
  private long jdField_a_of_type_Long;
  private wlo jdField_a_of_type_Wlo = new wkh(this);
  protected boolean a;
  
  public wkg()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (wjl)wjs.a(10);
    this.jdField_a_of_type_Long = ((Long)((wjl)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((wjl)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((wjl)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        ykq.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new wkj(i, (String)localObject);
        return;
      }
    }
    ykq.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public wkj a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (wkj)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    ykq.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    wub localwub = new wub(1, paramInt1, paramInt2);
    wfi.a().a(localwub, new wki(this));
  }
  
  protected void a(wlk paramwlk)
  {
    ykq.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      ykq.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    wll localwll = (wll)wjs.a(9);
    wlk localwlk = paramwlk;
    if (paramwlk == null) {
      localwlk = localwll.b();
    }
    if (localwlk != null)
    {
      a(localwlk.b, localwlk.a);
      return;
    }
    localwll.a(this.jdField_a_of_type_Wlo);
    localwll.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkg
 * JD-Core Version:    0.7.0.1
 */