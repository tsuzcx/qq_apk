package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PageInfo
  extends JceStruct
{
  public long iPos;
  
  public PageInfo() {}
  
  public PageInfo(long paramLong)
  {
    this.iPos = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPos = paramJceInputStream.read(this.iPos, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPos, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.PageInfo
 * JD-Core Version:    0.7.0.1
 */