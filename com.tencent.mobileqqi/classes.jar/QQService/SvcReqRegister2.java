package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcReqRegister2
  extends JceStruct
{
  static Map cache_pushPro;
  public byte cConnType = 0;
  public long lBid = 0L;
  public long lUin = 0L;
  public Map pushPro = null;
  public String sOther = "";
  
  public SvcReqRegister2() {}
  
  public SvcReqRegister2(long paramLong1, long paramLong2, byte paramByte, Map paramMap, String paramString)
  {
    this.lUin = paramLong1;
    this.lBid = paramLong2;
    this.cConnType = paramByte;
    this.pushPro = paramMap;
    this.sOther = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lBid = paramJceInputStream.read(this.lBid, 1, true);
    this.cConnType = paramJceInputStream.read(this.cConnType, 2, true);
    if (cache_pushPro == null)
    {
      cache_pushPro = new HashMap();
      cache_pushPro.put(Long.valueOf(0L), "");
    }
    this.pushPro = ((Map)paramJceInputStream.read(cache_pushPro, 3, false));
    this.sOther = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lBid, 1);
    paramJceOutputStream.write(this.cConnType, 2);
    if (this.pushPro != null) {
      paramJceOutputStream.write(this.pushPro, 3);
    }
    if (this.sOther != null) {
      paramJceOutputStream.write(this.sOther, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqRegister2
 * JD-Core Version:    0.7.0.1
 */