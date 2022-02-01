package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class feed_host_info
  extends JceStruct
{
  static yellow_info cache_OpuinYellowInfo = new yellow_info();
  static ArrayList<feed_info> cache_vec_feedInfos = new ArrayList();
  public yellow_info OpuinYellowInfo;
  public String actiondesc = "";
  public String nickname = "";
  public String strWords = "";
  public long uUin;
  public ArrayList<feed_info> vec_feedInfos;
  
  static
  {
    feed_info localfeed_info = new feed_info();
    cache_vec_feedInfos.add(localfeed_info);
  }
  
  public feed_host_info() {}
  
  public feed_host_info(long paramLong, String paramString1, String paramString2, ArrayList<feed_info> paramArrayList, yellow_info paramyellow_info, String paramString3)
  {
    this.uUin = paramLong;
    this.nickname = paramString1;
    this.actiondesc = paramString2;
    this.vec_feedInfos = paramArrayList;
    this.OpuinYellowInfo = paramyellow_info;
    this.strWords = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.actiondesc = paramJceInputStream.readString(2, false);
    this.vec_feedInfos = ((ArrayList)paramJceInputStream.read(cache_vec_feedInfos, 3, false));
    this.OpuinYellowInfo = ((yellow_info)paramJceInputStream.read(cache_OpuinYellowInfo, 4, false));
    this.strWords = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.actiondesc != null) {
      paramJceOutputStream.write(this.actiondesc, 2);
    }
    if (this.vec_feedInfos != null) {
      paramJceOutputStream.write(this.vec_feedInfos, 3);
    }
    if (this.OpuinYellowInfo != null) {
      paramJceOutputStream.write(this.OpuinYellowInfo, 4);
    }
    if (this.strWords != null) {
      paramJceOutputStream.write(this.strWords, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.feed_host_info
 * JD-Core Version:    0.7.0.1
 */