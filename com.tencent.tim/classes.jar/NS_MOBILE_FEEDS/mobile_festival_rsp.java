package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_festival_rsp
  extends JceStruct
{
  static ArrayList<String> cache_play_url_list = new ArrayList();
  public String attach_info = "";
  public long end_time;
  public long interval;
  public int play_flag;
  public long play_time;
  public ArrayList<String> play_url_list;
  public long start_time;
  
  static
  {
    cache_play_url_list.add("");
  }
  
  public mobile_festival_rsp() {}
  
  public mobile_festival_rsp(int paramInt, ArrayList<String> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    this.play_flag = paramInt;
    this.play_url_list = paramArrayList;
    this.play_time = paramLong1;
    this.interval = paramLong2;
    this.start_time = paramLong3;
    this.end_time = paramLong4;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.play_flag = paramJceInputStream.read(this.play_flag, 0, false);
    this.play_url_list = ((ArrayList)paramJceInputStream.read(cache_play_url_list, 1, false));
    this.play_time = paramJceInputStream.read(this.play_time, 2, false);
    this.interval = paramJceInputStream.read(this.interval, 3, false);
    this.start_time = paramJceInputStream.read(this.start_time, 4, false);
    this.end_time = paramJceInputStream.read(this.end_time, 5, false);
    this.attach_info = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.play_flag, 0);
    if (this.play_url_list != null) {
      paramJceOutputStream.write(this.play_url_list, 1);
    }
    paramJceOutputStream.write(this.play_time, 2);
    paramJceOutputStream.write(this.interval, 3);
    paramJceOutputStream.write(this.start_time, 4);
    paramJceOutputStream.write(this.end_time, 5);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_festival_rsp
 * JD-Core Version:    0.7.0.1
 */