package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SingerInfo
  extends JceStruct
{
  public String sSingerId = "";
  public String sSingerName = "";
  
  public SingerInfo() {}
  
  public SingerInfo(String paramString1, String paramString2)
  {
    this.sSingerId = paramString1;
    this.sSingerName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSingerId = paramJceInputStream.readString(0, false);
    this.sSingerName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSingerId != null) {
      paramJceOutputStream.write(this.sSingerId, 0);
    }
    if (this.sSingerName != null) {
      paramJceOutputStream.write(this.sSingerName, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.SingerInfo
 * JD-Core Version:    0.7.0.1
 */