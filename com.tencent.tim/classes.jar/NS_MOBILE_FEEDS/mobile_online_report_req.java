package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_online_report_req
  extends JceStruct
{
  static ArrayList<mobile_online_report_item> cache_vecOnlineItem = new ArrayList();
  public int appid;
  public int type_id;
  public long uin;
  public ArrayList<mobile_online_report_item> vecOnlineItem;
  
  static
  {
    mobile_online_report_item localmobile_online_report_item = new mobile_online_report_item();
    cache_vecOnlineItem.add(localmobile_online_report_item);
  }
  
  public mobile_online_report_req() {}
  
  public mobile_online_report_req(long paramLong, int paramInt1, int paramInt2, ArrayList<mobile_online_report_item> paramArrayList)
  {
    this.uin = paramLong;
    this.appid = paramInt1;
    this.type_id = paramInt2;
    this.vecOnlineItem = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.type_id = paramJceInputStream.read(this.type_id, 2, true);
    this.vecOnlineItem = ((ArrayList)paramJceInputStream.read(cache_vecOnlineItem, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.type_id, 2);
    if (this.vecOnlineItem != null) {
      paramJceOutputStream.write(this.vecOnlineItem, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_online_report_req
 * JD-Core Version:    0.7.0.1
 */