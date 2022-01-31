package LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Wifi
  extends JceStruct
{
  public long lMac = -1L;
  public short shRssi = 0;
  
  public Wifi() {}
  
  public Wifi(long paramLong, short paramShort)
  {
    this.lMac = paramLong;
    this.shRssi = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lMac = paramJceInputStream.read(this.lMac, 0, true);
    this.shRssi = paramJceInputStream.read(this.shRssi, 1, false);
  }
  
  public String toString()
  {
    return "Wifi[mac=" + this.lMac + ",rssi=" + this.shRssi + "]\n";
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lMac, 0);
    paramJceOutputStream.write(this.shRssi, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     LBS.Wifi
 * JD-Core Version:    0.7.0.1
 */