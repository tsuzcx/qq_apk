package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSReportChannel
  extends JceStruct
{
  static PhoneType dG = new PhoneType();
  static UserInfo dH = new UserInfo();
  static ChannelInfo dI = new ChannelInfo();
  public ChannelInfo channelInfo = null;
  public PhoneType phoneType = null;
  public UserInfo userInfo = null;
  
  public JceStruct newInit()
  {
    return new CSReportChannel();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.phoneType = ((PhoneType)paramJceInputStream.read(dG, 0, false));
    this.userInfo = ((UserInfo)paramJceInputStream.read(dH, 1, false));
    this.channelInfo = ((ChannelInfo)paramJceInputStream.read(dI, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.phoneType != null) {
      paramJceOutputStream.write(this.phoneType, 0);
    }
    if (this.userInfo != null) {
      paramJceOutputStream.write(this.userInfo, 1);
    }
    if (this.channelInfo != null) {
      paramJceOutputStream.write(this.channelInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CSReportChannel
 * JD-Core Version:    0.7.0.1
 */