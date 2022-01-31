package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ServerListInfo
  extends JceStruct
{
  public byte bLinkType = 0;
  public byte bProxy = 0;
  public int iPort = 0;
  public String sIP = "";
  
  public ServerListInfo() {}
  
  public ServerListInfo(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    this.sIP = paramString;
    this.iPort = paramInt;
    this.bLinkType = paramByte1;
    this.bProxy = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, true);
    this.bProxy = paramJceInputStream.read(this.bProxy, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    paramJceOutputStream.write(this.bProxy, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ServerListInfo
 * JD-Core Version:    0.7.0.1
 */