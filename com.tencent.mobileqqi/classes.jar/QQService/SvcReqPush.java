package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcReqPush
  extends JceStruct
{
  static Map cache_mpMsgPush;
  public long lUin = 0L;
  public Map mpMsgPush = null;
  public String sOther = "";
  
  public SvcReqPush() {}
  
  public SvcReqPush(long paramLong, Map paramMap, String paramString)
  {
    this.lUin = paramLong;
    this.mpMsgPush = paramMap;
    this.sOther = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_mpMsgPush == null)
    {
      cache_mpMsgPush = new HashMap();
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      cache_mpMsgPush.put(Long.valueOf(0L), localSvcMsgPush);
    }
    this.mpMsgPush = ((Map)paramJceInputStream.read(cache_mpMsgPush, 1, true));
    this.sOther = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.mpMsgPush, 1);
    paramJceOutputStream.write(this.sOther, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqPush
 * JD-Core Version:    0.7.0.1
 */