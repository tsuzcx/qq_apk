package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QQRobertInfo
  extends JceStruct
{
  public String actionUrl = "";
  public String nickname = "";
  
  public QQRobertInfo() {}
  
  public QQRobertInfo(String paramString1, String paramString2)
  {
    this.nickname = paramString1;
    this.actionUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, true);
    this.actionUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nickname, 0);
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     AccostSvc.QQRobertInfo
 * JD-Core Version:    0.7.0.1
 */