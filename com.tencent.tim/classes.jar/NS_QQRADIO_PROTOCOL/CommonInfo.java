package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommonInfo
  extends JceStruct
{
  public String cookie = "";
  public String debugModeInfo = "";
  public byte hasMore;
  public byte isRefresh;
  public byte noUpdate;
  
  public CommonInfo() {}
  
  public CommonInfo(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2)
  {
    this.cookie = paramString1;
    this.isRefresh = paramByte1;
    this.hasMore = paramByte2;
    this.noUpdate = paramByte3;
    this.debugModeInfo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cookie = paramJceInputStream.readString(0, false);
    this.isRefresh = paramJceInputStream.read(this.isRefresh, 1, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 2, false);
    this.noUpdate = paramJceInputStream.read(this.noUpdate, 3, false);
    this.debugModeInfo = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 0);
    }
    paramJceOutputStream.write(this.isRefresh, 1);
    paramJceOutputStream.write(this.hasMore, 2);
    paramJceOutputStream.write(this.noUpdate, 3);
    if (this.debugModeInfo != null) {
      paramJceOutputStream.write(this.debugModeInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.CommonInfo
 * JD-Core Version:    0.7.0.1
 */