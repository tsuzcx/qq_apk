package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcRespRegister2
  extends JceStruct
{
  static Map cache_pushPro;
  public byte cReplyCode = 0;
  public long lBid = 0L;
  public long lUin = 0L;
  public Map pushPro = null;
  public String sOther = "";
  public String strResult = "";
  
  public SvcRespRegister2() {}
  
  public SvcRespRegister2(long paramLong1, long paramLong2, byte paramByte, String paramString1, Map paramMap, String paramString2)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.cReplyCode = paramByte;
    this.strResult = paramString1;
    this.pushPro = paramMap;
    this.sOther = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, true);
    if (cache_pushPro == null)
    {
      cache_pushPro = new HashMap();
      cache_pushPro.put(Long.valueOf(0L), "");
    }
    this.pushPro = ((Map)paramJceInputStream.read(cache_pushPro, 4, false));
    this.sOther = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
    if (this.pushPro != null) {
      paramJceOutputStream.write(this.pushPro, 4);
    }
    if (this.sOther != null) {
      paramJceOutputStream.write(this.sOther, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespRegister2
 * JD-Core Version:    0.7.0.1
 */