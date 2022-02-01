package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class rtmp_report_timed_info
  extends JceStruct
{
  static int cache_play_status = 0;
  public long anchor_svr_delay;
  public double app_memory_usage;
  public long audience_svr_delay;
  public String audio_play_err_code = "";
  public double cpu_usage;
  public double downstream_audio_bitrate;
  public double downstream_total_bitrate;
  public double downstream_video_bitrate;
  public long lTime;
  public String play_err_code = "";
  public int play_status;
  public String video_play_err_code = "";
  
  public rtmp_report_timed_info() {}
  
  public rtmp_report_timed_info(long paramLong1, long paramLong2, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt, double paramDouble4, double paramDouble5, String paramString1, String paramString2, String paramString3, long paramLong3)
  {
    this.anchor_svr_delay = paramLong1;
    this.audience_svr_delay = paramLong2;
    this.downstream_total_bitrate = paramDouble1;
    this.downstream_video_bitrate = paramDouble2;
    this.downstream_audio_bitrate = paramDouble3;
    this.play_status = paramInt;
    this.app_memory_usage = paramDouble4;
    this.cpu_usage = paramDouble5;
    this.audio_play_err_code = paramString1;
    this.video_play_err_code = paramString2;
    this.play_err_code = paramString3;
    this.lTime = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.anchor_svr_delay = paramJceInputStream.read(this.anchor_svr_delay, 0, false);
    this.audience_svr_delay = paramJceInputStream.read(this.audience_svr_delay, 1, false);
    this.downstream_total_bitrate = paramJceInputStream.read(this.downstream_total_bitrate, 2, false);
    this.downstream_video_bitrate = paramJceInputStream.read(this.downstream_video_bitrate, 3, false);
    this.downstream_audio_bitrate = paramJceInputStream.read(this.downstream_audio_bitrate, 4, false);
    this.play_status = paramJceInputStream.read(this.play_status, 5, false);
    this.app_memory_usage = paramJceInputStream.read(this.app_memory_usage, 6, false);
    this.cpu_usage = paramJceInputStream.read(this.cpu_usage, 7, false);
    this.audio_play_err_code = paramJceInputStream.readString(8, false);
    this.video_play_err_code = paramJceInputStream.readString(9, false);
    this.play_err_code = paramJceInputStream.readString(10, false);
    this.lTime = paramJceInputStream.read(this.lTime, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.anchor_svr_delay, 0);
    paramJceOutputStream.write(this.audience_svr_delay, 1);
    paramJceOutputStream.write(this.downstream_total_bitrate, 2);
    paramJceOutputStream.write(this.downstream_video_bitrate, 3);
    paramJceOutputStream.write(this.downstream_audio_bitrate, 4);
    paramJceOutputStream.write(this.play_status, 5);
    paramJceOutputStream.write(this.app_memory_usage, 6);
    paramJceOutputStream.write(this.cpu_usage, 7);
    if (this.audio_play_err_code != null) {
      paramJceOutputStream.write(this.audio_play_err_code, 8);
    }
    if (this.video_play_err_code != null) {
      paramJceOutputStream.write(this.video_play_err_code, 9);
    }
    if (this.play_err_code != null) {
      paramJceOutputStream.write(this.play_err_code, 10);
    }
    paramJceOutputStream.write(this.lTime, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.rtmp_report_timed_info
 * JD-Core Version:    0.7.0.1
 */