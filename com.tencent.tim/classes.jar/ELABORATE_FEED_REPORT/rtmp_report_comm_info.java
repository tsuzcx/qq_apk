package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class rtmp_report_comm_info
  extends JceStruct
{
  static int cache_play_type = 0;
  public String appid = "";
  public long flow;
  public String network = "";
  public String play_id = "";
  public int play_type;
  public String qua = "";
  public String room_id = "";
  public long uin;
  
  public rtmp_report_comm_info() {}
  
  public rtmp_report_comm_info(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, long paramLong1, long paramLong2)
  {
    this.play_id = paramString1;
    this.qua = paramString2;
    this.network = paramString3;
    this.appid = paramString4;
    this.play_type = paramInt;
    this.room_id = paramString5;
    this.uin = paramLong1;
    this.flow = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.play_id = paramJceInputStream.readString(0, false);
    this.qua = paramJceInputStream.readString(1, false);
    this.network = paramJceInputStream.readString(2, false);
    this.appid = paramJceInputStream.readString(3, false);
    this.play_type = paramJceInputStream.read(this.play_type, 4, false);
    this.room_id = paramJceInputStream.readString(5, false);
    this.uin = paramJceInputStream.read(this.uin, 6, false);
    this.flow = paramJceInputStream.read(this.flow, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.play_id != null) {
      paramJceOutputStream.write(this.play_id, 0);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 1);
    }
    if (this.network != null) {
      paramJceOutputStream.write(this.network, 2);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 3);
    }
    paramJceOutputStream.write(this.play_type, 4);
    if (this.room_id != null) {
      paramJceOutputStream.write(this.room_id, 5);
    }
    paramJceOutputStream.write(this.uin, 6);
    paramJceOutputStream.write(this.flow, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.rtmp_report_comm_info
 * JD-Core Version:    0.7.0.1
 */