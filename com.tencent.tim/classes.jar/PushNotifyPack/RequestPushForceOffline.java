package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestPushForceOffline
  extends JceStruct
{
  public byte bSameDevice;
  public long lUin;
  public String strTips = "";
  public String strTitle = "";
  
  public RequestPushForceOffline() {}
  
  public RequestPushForceOffline(long paramLong, String paramString1, String paramString2, byte paramByte)
  {
    this.lUin = paramLong;
    this.strTitle = paramString1;
    this.strTips = paramString2;
    this.bSameDevice = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strTitle = paramJceInputStream.readString(1, false);
    this.strTips = paramJceInputStream.readString(2, false);
    this.bSameDevice = paramJceInputStream.read(this.bSameDevice, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 1);
    }
    if (this.strTips != null) {
      paramJceOutputStream.write(this.strTips, 2);
    }
    paramJceOutputStream.write(this.bSameDevice, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     PushNotifyPack.RequestPushForceOffline
 * JD-Core Version:    0.7.0.1
 */