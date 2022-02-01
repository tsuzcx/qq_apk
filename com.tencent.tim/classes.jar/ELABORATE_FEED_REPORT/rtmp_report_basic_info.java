package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class rtmp_report_basic_info
  extends JceStruct
{
  public long dns_parse_delay;
  public long lTime;
  public long play_succ_delay;
  public long rtmp_addr_delay;
  
  public rtmp_report_basic_info() {}
  
  public rtmp_report_basic_info(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.dns_parse_delay = paramLong1;
    this.rtmp_addr_delay = paramLong2;
    this.play_succ_delay = paramLong3;
    this.lTime = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dns_parse_delay = paramJceInputStream.read(this.dns_parse_delay, 0, false);
    this.rtmp_addr_delay = paramJceInputStream.read(this.rtmp_addr_delay, 1, false);
    this.play_succ_delay = paramJceInputStream.read(this.play_succ_delay, 2, false);
    this.lTime = paramJceInputStream.read(this.lTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dns_parse_delay, 0);
    paramJceOutputStream.write(this.rtmp_addr_delay, 1);
    paramJceOutputStream.write(this.play_succ_delay, 2);
    paramJceOutputStream.write(this.lTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.rtmp_report_basic_info
 * JD-Core Version:    0.7.0.1
 */