package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_daily_config_req
  extends JceStruct
{
  static int cache_confid = 0;
  static daily_recommend_status cache_recommend_status = new daily_recommend_status();
  public int confid;
  public daily_recommend_status recommend_status;
  public boolean remind_upload_on;
  public long uin;
  
  public get_daily_config_req() {}
  
  public get_daily_config_req(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.confid = paramInt;
  }
  
  public get_daily_config_req(long paramLong, int paramInt, daily_recommend_status paramdaily_recommend_status, boolean paramBoolean)
  {
    this.uin = paramLong;
    this.confid = paramInt;
    this.recommend_status = paramdaily_recommend_status;
    this.remind_upload_on = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.confid = paramJceInputStream.read(this.confid, 1, true);
    this.recommend_status = ((daily_recommend_status)paramJceInputStream.read(cache_recommend_status, 2, false));
    this.remind_upload_on = paramJceInputStream.read(this.remind_upload_on, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.confid, 1);
    if (this.recommend_status != null) {
      paramJceOutputStream.write(this.recommend_status, 2);
    }
    paramJceOutputStream.write(this.remind_upload_on, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_daily_config_req
 * JD-Core Version:    0.7.0.1
 */