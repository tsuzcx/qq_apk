package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class daily_config_eventcard
  extends JceStruct
{
  static feeds_video_actalbum_config cache_vid_alb_config = new feeds_video_actalbum_config();
  static int cache_yy_type = 0;
  public long end_time;
  public long start_time;
  public long trigger_end_time;
  public long trigger_start_time;
  public feeds_video_actalbum_config vid_alb_config;
  public int yy_type;
  
  public daily_config_eventcard() {}
  
  public daily_config_eventcard(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, feeds_video_actalbum_config paramfeeds_video_actalbum_config)
  {
    this.start_time = paramLong1;
    this.end_time = paramLong2;
    this.trigger_start_time = paramLong3;
    this.trigger_end_time = paramLong4;
    this.yy_type = paramInt;
    this.vid_alb_config = paramfeeds_video_actalbum_config;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.start_time = paramJceInputStream.read(this.start_time, 0, true);
    this.end_time = paramJceInputStream.read(this.end_time, 1, true);
    this.trigger_start_time = paramJceInputStream.read(this.trigger_start_time, 2, true);
    this.trigger_end_time = paramJceInputStream.read(this.trigger_end_time, 3, true);
    this.yy_type = paramJceInputStream.read(this.yy_type, 4, false);
    this.vid_alb_config = ((feeds_video_actalbum_config)paramJceInputStream.read(cache_vid_alb_config, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.start_time, 0);
    paramJceOutputStream.write(this.end_time, 1);
    paramJceOutputStream.write(this.trigger_start_time, 2);
    paramJceOutputStream.write(this.trigger_end_time, 3);
    paramJceOutputStream.write(this.yy_type, 4);
    if (this.vid_alb_config != null) {
      paramJceOutputStream.write(this.vid_alb_config, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.daily_config_eventcard
 * JD-Core Version:    0.7.0.1
 */