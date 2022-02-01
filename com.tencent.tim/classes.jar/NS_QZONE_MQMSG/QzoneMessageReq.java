package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QzoneMessageReq
  extends JceStruct
{
  static Map<String, String> cache_ext = new HashMap();
  public Map<String, String> ext;
  public long num;
  public int scence;
  public String trace_info = "";
  public long uin;
  
  static
  {
    cache_ext.put("", "");
  }
  
  public QzoneMessageReq() {}
  
  public QzoneMessageReq(long paramLong1, String paramString, long paramLong2, Map<String, String> paramMap, int paramInt)
  {
    this.uin = paramLong1;
    this.trace_info = paramString;
    this.num = paramLong2;
    this.ext = paramMap;
    this.scence = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.trace_info = paramJceInputStream.readString(1, true);
    this.num = paramJceInputStream.read(this.num, 2, true);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
    this.scence = paramJceInputStream.read(this.scence, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.trace_info, 1);
    paramJceOutputStream.write(this.num, 2);
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 3);
    }
    paramJceOutputStream.write(this.scence, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.QzoneMessageReq
 * JD-Core Version:    0.7.0.1
 */