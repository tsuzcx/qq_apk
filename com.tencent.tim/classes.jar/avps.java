import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public class avps
  extends avpr
{
  newest_feeds_req a = new newest_feeds_req();
  
  public avps(long paramLong, Map<Long, Long> paramMap)
  {
    this.a.cmd = 4;
    this.a.login_uin = paramLong;
    this.a.strQua = avpq.getQUA3();
    this.a.mapUinTimes = new HashMap();
    this.a.mapUinTimes.putAll(paramMap);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getMsgNewestFeeds";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public int getType()
  {
    return 1000;
  }
  
  public String toString()
  {
    return String.format("reqetuest ,cmd:%d,loginUin;%d,qua;%s,mapUintimes:%s ", new Object[] { Integer.valueOf(this.a.cmd), Long.valueOf(this.a.login_uin), this.a.strQua, String.valueOf(this.a.mapUinTimes) });
  }
  
  public String uniKey()
  {
    return "getMsgNewestFeeds";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avps
 * JD-Core Version:    0.7.0.1
 */