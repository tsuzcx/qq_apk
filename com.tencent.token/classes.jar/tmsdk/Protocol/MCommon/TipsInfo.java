package tmsdk.Protocol.MCommon;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TipsInfo
  extends JceStruct
{
  public int atype = 0;
  public String msg = "";
  public String title = "";
  public int type = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.type = paramJceInputStream.read(this.type, 2, true);
    this.atype = paramJceInputStream.read(this.atype, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.title, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.atype, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MCommon.TipsInfo
 * JD-Core Version:    0.7.0.1
 */