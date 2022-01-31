package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetWeatherRsp
  extends JceStruct
{
  static stWeatherInfo cache_stWeather;
  public stWeatherInfo stWeather = null;
  
  public stGetWeatherRsp() {}
  
  public stGetWeatherRsp(stWeatherInfo paramstWeatherInfo)
  {
    this.stWeather = paramstWeatherInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stWeather == null) {
      cache_stWeather = new stWeatherInfo();
    }
    this.stWeather = ((stWeatherInfo)paramJceInputStream.read(cache_stWeather, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stWeather, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetWeatherRsp
 * JD-Core Version:    0.7.0.1
 */