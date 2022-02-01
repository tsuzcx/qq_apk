package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommentMsg
  extends JceStruct
{
  public String dressIcon = "";
  public String msg = "";
  public String nick = "";
  public String userId = "";
  
  public CommentMsg() {}
  
  public CommentMsg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.userId = paramString1;
    this.nick = paramString2;
    this.msg = paramString3;
    this.dressIcon = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userId = paramJceInputStream.readString(0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.msg = paramJceInputStream.readString(2, false);
    this.dressIcon = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 0);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
    if (this.dressIcon != null) {
      paramJceOutputStream.write(this.dressIcon, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.CommentMsg
 * JD-Core Version:    0.7.0.1
 */