package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcRespGet
  extends JceStruct
{
  static Map cache_mpMsgPush;
  public byte bNeedKik = 0;
  public byte cReplyCode = 0;
  public int iInterval = 300;
  public long lUin = 0L;
  public Map mpMsgPush = null;
  public String strClientIP = "";
  public String strResult = "";
  
  public SvcRespGet() {}
  
  public SvcRespGet(long paramLong, byte paramByte1, String paramString1, Map paramMap, int paramInt, byte paramByte2, String paramString2)
  {
    this.lUin = paramLong;
    this.cReplyCode = paramByte1;
    this.strResult = paramString1;
    this.mpMsgPush = paramMap;
    this.iInterval = paramInt;
    this.bNeedKik = paramByte2;
    this.strClientIP = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
    if (cache_mpMsgPush == null)
    {
      cache_mpMsgPush = new HashMap();
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      cache_mpMsgPush.put(Long.valueOf(0L), localSvcMsgPush);
    }
    this.mpMsgPush = ((Map)paramJceInputStream.read(cache_mpMsgPush, 3, true));
    this.iInterval = paramJceInputStream.read(this.iInterval, 4, false);
    this.bNeedKik = paramJceInputStream.read(this.bNeedKik, 5, false);
    this.strClientIP = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
    paramJceOutputStream.write(this.mpMsgPush, 3);
    paramJceOutputStream.write(this.iInterval, 4);
    paramJceOutputStream.write(this.bNeedKik, 5);
    if (this.strClientIP != null) {
      paramJceOutputStream.write(this.strClientIP, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespGet
 * JD-Core Version:    0.7.0.1
 */