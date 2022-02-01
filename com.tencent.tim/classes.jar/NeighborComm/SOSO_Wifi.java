package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SOSO_Wifi
  extends JceStruct
{
  public long lMac = -1L;
  public short shRssi;
  
  public SOSO_Wifi() {}
  
  public SOSO_Wifi(long paramLong, short paramShort)
  {
    this.lMac = paramLong;
    this.shRssi = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lMac = paramJceInputStream.read(this.lMac, 0, true);
    this.shRssi = paramJceInputStream.read(this.shRssi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lMac, 0);
    paramJceOutputStream.write(this.shRssi, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NeighborComm.SOSO_Wifi
 * JD-Core Version:    0.7.0.1
 */