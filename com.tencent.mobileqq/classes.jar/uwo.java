import android.text.TextUtils;

public class uwo
  extends uuz<uwr>
{
  private long jdField_a_of_type_Long;
  private uxw jdField_a_of_type_Uxw = new uwp(this);
  protected boolean a;
  
  public uwo()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (uvt)uwa.a(10);
    this.jdField_a_of_type_Long = ((Long)((uvt)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((uvt)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((uvt)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        wxe.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new uwr(i, (String)localObject);
        return;
      }
    }
    wxe.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public uwr a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (uwr)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    wxe.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    vgj localvgj = new vgj(1, paramInt1, paramInt2);
    urp.a().a(localvgj, new uwq(this));
  }
  
  protected void a(uxs paramuxs)
  {
    wxe.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      wxe.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    uxt localuxt = (uxt)uwa.a(9);
    uxs localuxs = paramuxs;
    if (paramuxs == null) {
      localuxs = localuxt.b();
    }
    if (localuxs != null)
    {
      a(localuxs.b, localuxs.a);
      return;
    }
    localuxt.a(this.jdField_a_of_type_Uxw);
    localuxt.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */