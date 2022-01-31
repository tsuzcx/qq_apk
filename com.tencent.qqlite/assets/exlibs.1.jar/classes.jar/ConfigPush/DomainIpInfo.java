package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DomainIpInfo
  extends JceStruct
{
  public int uIp = 0;
  public int uPort = 0;
  
  public DomainIpInfo() {}
  
  public DomainIpInfo(int paramInt1, int paramInt2)
  {
    this.uIp = paramInt1;
    this.uPort = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uIp = paramJceInputStream.read(this.uIp, 1, true);
    this.uPort = paramJceInputStream.read(this.uPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uIp, 1);
    paramJceOutputStream.write(this.uPort, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ConfigPush.DomainIpInfo
 * JD-Core Version:    0.7.0.1
 */