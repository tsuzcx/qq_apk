import android.text.TextUtils;

public class vvl
  extends vtw<vvo>
{
  private long jdField_a_of_type_Long;
  private vwt jdField_a_of_type_Vwt = new vvm(this);
  protected boolean a;
  
  public vvl()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (vuq)vux.a(10);
    this.jdField_a_of_type_Long = ((Long)((vuq)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((vuq)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((vuq)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        xvv.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new vvo(i, (String)localObject);
        return;
      }
    }
    xvv.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public vvo a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (vvo)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    xvv.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    wfg localwfg = new wfg(1, paramInt1, paramInt2);
    vqn.a().a(localwfg, new vvn(this));
  }
  
  protected void a(vwp paramvwp)
  {
    xvv.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      xvv.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    vwq localvwq = (vwq)vux.a(9);
    vwp localvwp = paramvwp;
    if (paramvwp == null) {
      localvwp = localvwq.b();
    }
    if (localvwp != null)
    {
      a(localvwp.b, localvwp.a);
      return;
    }
    localvwq.a(this.jdField_a_of_type_Vwt);
    localvwq.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvl
 * JD-Core Version:    0.7.0.1
 */