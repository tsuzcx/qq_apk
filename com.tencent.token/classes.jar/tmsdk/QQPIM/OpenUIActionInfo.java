package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OpenUIActionInfo
  extends JceStruct
{
  public int action = 0;
  public String msg = "";
  public String title = "";
  public int uiid = 0;
  
  public OpenUIActionInfo() {}
  
  public OpenUIActionInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.uiid = paramInt1;
    this.action = paramInt2;
    this.title = paramString1;
    this.msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiid = paramJceInputStream.read(this.uiid, 0, true);
    this.action = paramJceInputStream.read(this.action, 1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiid, 0);
    paramJceOutputStream.write(this.action, 1);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.OpenUIActionInfo
 * JD-Core Version:    0.7.0.1
 */