package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SingleMsg
  extends JceStruct
{
  static Map cache_data;
  public long addTime = 0L;
  public Map data = null;
  public long opUin = 0L;
  
  public SingleMsg() {}
  
  public SingleMsg(long paramLong1, Map paramMap, long paramLong2)
  {
    this.addTime = paramLong1;
    this.data = paramMap;
    this.opUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.addTime = paramJceInputStream.read(this.addTime, 0, false);
    if (cache_data == null)
    {
      cache_data = new HashMap();
      cache_data.put("", "");
    }
    this.data = ((Map)paramJceInputStream.read(cache_data, 1, false));
    this.opUin = paramJceInputStream.read(this.opUin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.addTime, 0);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 1);
    }
    paramJceOutputStream.write(this.opUin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QzoneCombine.SingleMsg
 * JD-Core Version:    0.7.0.1
 */