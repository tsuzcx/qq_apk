package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_shoot_info
  extends JceStruct
{
  static s_gps cache_shoot_gps;
  public s_gps shoot_gps = null;
  public String shoot_location = "";
  public long shoot_time = 0L;
  
  public s_shoot_info() {}
  
  public s_shoot_info(s_gps params_gps, String paramString, long paramLong)
  {
    this.shoot_gps = params_gps;
    this.shoot_location = paramString;
    this.shoot_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_shoot_gps == null) {
      cache_shoot_gps = new s_gps();
    }
    this.shoot_gps = ((s_gps)paramJceInputStream.read(cache_shoot_gps, 0, false));
    this.shoot_location = paramJceInputStream.readString(1, false);
    this.shoot_time = paramJceInputStream.read(this.shoot_time, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.shoot_gps != null) {
      paramJceOutputStream.write(this.shoot_gps, 0);
    }
    if (this.shoot_location != null) {
      paramJceOutputStream.write(this.shoot_location, 1);
    }
    paramJceOutputStream.write(this.shoot_time, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_shoot_info
 * JD-Core Version:    0.7.0.1
 */