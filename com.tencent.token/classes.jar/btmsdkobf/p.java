package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class p
  extends JceStruct
{
  public int ax = 0;
  public int buildno = 0;
  public String channelid = "";
  public String lc = "";
  public String version = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ax = paramJceInputStream.read(this.ax, 0, true);
    this.lc = paramJceInputStream.readString(1, false);
    this.buildno = paramJceInputStream.read(this.buildno, 2, false);
    this.channelid = paramJceInputStream.readString(3, false);
    this.version = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ax, 0);
    String str = this.lc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.buildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    str = this.channelid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.p
 * JD-Core Version:    0.7.0.1
 */