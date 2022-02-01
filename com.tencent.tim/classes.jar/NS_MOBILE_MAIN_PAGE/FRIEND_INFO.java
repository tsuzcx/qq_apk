package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FRIEND_INFO
  extends JceStruct
{
  public byte groupId;
  public byte isVip;
  public String nick = "";
  public String remark = "";
  public byte vipLevel;
  
  public FRIEND_INFO() {}
  
  public FRIEND_INFO(byte paramByte1, String paramString1, byte paramByte2, byte paramByte3, String paramString2)
  {
    this.groupId = paramByte1;
    this.remark = paramString1;
    this.isVip = paramByte2;
    this.vipLevel = paramByte3;
    this.nick = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupId = paramJceInputStream.read(this.groupId, 0, true);
    this.remark = paramJceInputStream.readString(1, true);
    this.isVip = paramJceInputStream.read(this.isVip, 2, false);
    this.vipLevel = paramJceInputStream.read(this.vipLevel, 3, false);
    this.nick = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupId, 0);
    paramJceOutputStream.write(this.remark, 1);
    paramJceOutputStream.write(this.isVip, 2);
    paramJceOutputStream.write(this.vipLevel, 3);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.FRIEND_INFO
 * JD-Core Version:    0.7.0.1
 */