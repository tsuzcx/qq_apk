import android.text.TextUtils;

public class wqa
  extends wol<wqd>
{
  private long jdField_a_of_type_Long;
  private wri jdField_a_of_type_Wri = new wqb(this);
  protected boolean a;
  
  public wqa()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (wpf)wpm.a(10);
    this.jdField_a_of_type_Long = ((Long)((wpf)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((wpf)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((wpf)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        yqp.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new wqd(i, (String)localObject);
        return;
      }
    }
    yqp.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public wqd a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (wqd)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    yqp.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    wzv localwzv = new wzv(1, paramInt1, paramInt2);
    wlb.a().a(localwzv, new wqc(this));
  }
  
  protected void a(wre paramwre)
  {
    yqp.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      yqp.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    wrf localwrf = (wrf)wpm.a(9);
    wre localwre = paramwre;
    if (paramwre == null) {
      localwre = localwrf.b();
    }
    if (localwre != null)
    {
      a(localwre.b, localwre.a);
      return;
    }
    localwrf.a(this.jdField_a_of_type_Wri);
    localwrf.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqa
 * JD-Core Version:    0.7.0.1
 */