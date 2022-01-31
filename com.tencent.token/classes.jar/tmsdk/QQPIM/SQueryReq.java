package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SQueryReq
  extends JceStruct
{
  public String phonenum = "";
  
  public SQueryReq() {}
  
  public SQueryReq(String paramString)
  {
    this.phonenum = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.phonenum = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phonenum, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SQueryReq
 * JD-Core Version:    0.7.0.1
 */