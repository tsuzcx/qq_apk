import android.text.TextUtils;

public class pth
  extends psc<pth.a>
{
  private long As;
  private pub.a b = new pti(this);
  protected boolean gV;
  
  public pth()
  {
    bmK();
  }
  
  private void bmK()
  {
    Object localObject = (psr)psx.a(10);
    this.As = ((Long)((psr)localObject).c("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.As >= System.currentTimeMillis())
    {
      int i = ((Integer)((psr)localObject).c("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((psr)localObject).c("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        ram.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.As), Long.valueOf(System.currentTimeMillis()));
        this.data = new pth.a(i, (String)localObject);
        return;
      }
    }
    ram.w("WeatherDataProvider", "no valid local weather data.");
  }
  
  public pth.a a()
  {
    if ((this.As == 0L) || (this.As >= System.currentTimeMillis())) {
      return null;
    }
    return (pth.a)this.data;
  }
  
  protected void a(pua parampua)
  {
    ram.d("WeatherDataProvider", "requestWeather.");
    if (this.gV)
    {
      ram.d("WeatherDataProvider", "is request ing....");
      return;
    }
    this.gV = true;
    pub localpub = (pub)psx.a(9);
    pua localpua = parampua;
    if (parampua == null) {
      localpua = localpub.b();
    }
    if (localpua != null)
    {
      dQ(localpua.mLongitude, localpua.mLatitude);
      return;
    }
    localpub.a(this.b);
    localpub.aJK();
  }
  
  protected void dQ(int paramInt1, int paramInt2)
  {
    ram.b("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    pzn localpzn = new pzn(1, paramInt1, paramInt2);
    ppv.a().a(localpzn, new ptj(this));
  }
  
  public static class a
  {
    public final String auX;
    public final int temperature;
    
    public a(int paramInt, String paramString)
    {
      this.temperature = paramInt;
      this.auX = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pth
 * JD-Core Version:    0.7.0.1
 */