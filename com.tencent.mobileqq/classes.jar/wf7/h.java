package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class h
  extends JceStruct
{
  static byte[] ae = (byte[])new byte[1];
  public int C = 0;
  public boolean aB = false;
  public boolean aC = false;
  public String aD = "";
  public int frequency = -1;
  public String ssid = "";
  public byte[] u = null;
  
  static
  {
    ((byte[])ae)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new h();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ssid = paramJceInputStream.readString(0, false);
    this.u = ((byte[])paramJceInputStream.read(ae, 1, false));
    this.aB = paramJceInputStream.read(this.aB, 2, false);
    this.C = paramJceInputStream.read(this.C, 3, false);
    this.aC = paramJceInputStream.read(this.aC, 4, false);
    this.aD = paramJceInputStream.readString(5, false);
    this.frequency = paramJceInputStream.read(this.frequency, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ssid != null) {
      paramJceOutputStream.write(this.ssid, 0);
    }
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 1);
    }
    paramJceOutputStream.write(this.aB, 2);
    if (this.C != 0) {
      paramJceOutputStream.write(this.C, 3);
    }
    paramJceOutputStream.write(this.aC, 4);
    if (this.aD != null) {
      paramJceOutputStream.write(this.aD, 5);
    }
    if (this.frequency != -1) {
      paramJceOutputStream.write(this.frequency, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.h
 * JD-Core Version:    0.7.0.1
 */