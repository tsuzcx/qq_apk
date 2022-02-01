package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InRoomMsg
  extends JceStruct
{
  public String msg = "";
  public String nick = "";
  public String userId = "";
  
  public InRoomMsg() {}
  
  public InRoomMsg(String paramString1, String paramString2, String paramString3)
  {
    this.userId = paramString1;
    this.msg = paramString2;
    this.nick = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userId = paramJceInputStream.readString(0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.nick = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 0);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.InRoomMsg
 * JD-Core Version:    0.7.0.1
 */