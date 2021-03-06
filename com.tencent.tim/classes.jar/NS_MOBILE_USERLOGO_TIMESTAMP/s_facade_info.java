package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_facade_info
  extends JceStruct
{
  public String facade_id = "";
  public long timestamp;
  
  public s_facade_info() {}
  
  public s_facade_info(String paramString, long paramLong)
  {
    this.facade_id = paramString;
    this.timestamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.facade_id = paramJceInputStream.readString(0, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.facade_id != null) {
      paramJceOutputStream.write(this.facade_id, 0);
    }
    paramJceOutputStream.write(this.timestamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.s_facade_info
 * JD-Core Version:    0.7.0.1
 */