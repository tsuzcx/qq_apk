package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class fu
  extends JceStruct
{
  public int id = 0;
  public int networkId = 0;
  public int security = 0;
  public String ssid = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.ssid = paramJceInputStream.readString(1, false);
    this.security = paramJceInputStream.read(this.security, 2, false);
    this.networkId = paramJceInputStream.read(this.networkId, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.id;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    String str = this.ssid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    i = this.security;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.networkId;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fu
 * JD-Core Version:    0.7.0.1
 */