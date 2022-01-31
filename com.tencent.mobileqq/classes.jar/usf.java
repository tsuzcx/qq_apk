import android.text.TextUtils;

public class usf
  extends uqq<usi>
{
  private long jdField_a_of_type_Long;
  private utn jdField_a_of_type_Utn = new usg(this);
  protected boolean a;
  
  public usf()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (urk)urr.a(10);
    this.jdField_a_of_type_Long = ((Long)((urk)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((urk)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((urk)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        wsv.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new usi(i, (String)localObject);
        return;
      }
    }
    wsv.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public usi a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (usi)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    wsv.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    vca localvca = new vca(1, paramInt1, paramInt2);
    ung.a().a(localvca, new ush(this));
  }
  
  protected void a(utj paramutj)
  {
    wsv.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    utk localutk = (utk)urr.a(9);
    utj localutj = paramutj;
    if (paramutj == null) {
      localutj = localutk.b();
    }
    if (localutj != null)
    {
      a(localutj.b, localutj.a);
      return;
    }
    localutk.a(this.jdField_a_of_type_Utn);
    localutk.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     usf
 * JD-Core Version:    0.7.0.1
 */