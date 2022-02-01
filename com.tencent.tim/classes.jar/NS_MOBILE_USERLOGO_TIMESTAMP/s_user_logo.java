package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_user_logo
  extends JceStruct
{
  public String ip = "";
  public long timestamp;
  public long uin;
  
  public s_user_logo() {}
  
  public s_user_logo(long paramLong1, long paramLong2, String paramString)
  {
    this.uin = paramLong1;
    this.timestamp = paramLong2;
    this.ip = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.timestamp = paramJceInputStream.read(this.timestamp, 1, false);
    this.ip = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.timestamp, 1);
    if (this.ip != null) {
      paramJceOutputStream.write(this.ip, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_USERLOGO_TIMESTAMP.s_user_logo
 * JD-Core Version:    0.7.0.1
 */