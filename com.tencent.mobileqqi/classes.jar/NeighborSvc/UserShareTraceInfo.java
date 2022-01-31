package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserShareTraceInfo
  extends JceStruct
{
  public byte bIsOpen = 0;
  public long lUIN = 0L;
  
  public UserShareTraceInfo() {}
  
  public UserShareTraceInfo(long paramLong, byte paramByte)
  {
    this.lUIN = paramLong;
    this.bIsOpen = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.bIsOpen = paramJceInputStream.read(this.bIsOpen, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.bIsOpen, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.UserShareTraceInfo
 * JD-Core Version:    0.7.0.1
 */