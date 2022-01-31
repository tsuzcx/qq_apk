package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class g
  extends JceStruct
{
  public double aA = 0.833D;
  public boolean ap = true;
  public double aq = -2.55D;
  public double ar = 2.03D;
  public double as = 0.9300000000000001D;
  public double at = 13.4D;
  public double au = -7.37D;
  public double av = -3.99D;
  public double aw = 0.167D;
  public double ax = 0.333D;
  public double ay = 0.5D;
  public double az = 0.667D;
  
  public JceStruct newInit()
  {
    return new g();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ap = paramJceInputStream.read(this.ap, 0, false);
    this.aq = paramJceInputStream.read(this.aq, 1, false);
    this.ar = paramJceInputStream.read(this.ar, 2, false);
    this.as = paramJceInputStream.read(this.as, 3, false);
    this.at = paramJceInputStream.read(this.at, 4, false);
    this.au = paramJceInputStream.read(this.au, 5, false);
    this.av = paramJceInputStream.read(this.av, 6, false);
    this.aw = paramJceInputStream.read(this.aw, 7, false);
    this.ax = paramJceInputStream.read(this.ax, 8, false);
    this.ay = paramJceInputStream.read(this.ay, 9, false);
    this.az = paramJceInputStream.read(this.az, 10, false);
    this.aA = paramJceInputStream.read(this.aA, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ap, 0);
    if (this.aq != -2.55D) {
      paramJceOutputStream.write(this.aq, 1);
    }
    if (this.ar != 2.03D) {
      paramJceOutputStream.write(this.ar, 2);
    }
    if (this.as != 0.9300000000000001D) {
      paramJceOutputStream.write(this.as, 3);
    }
    if (this.at != 13.4D) {
      paramJceOutputStream.write(this.at, 4);
    }
    if (this.au != -7.37D) {
      paramJceOutputStream.write(this.au, 5);
    }
    if (this.av != -3.99D) {
      paramJceOutputStream.write(this.av, 6);
    }
    if (this.aw != 0.167D) {
      paramJceOutputStream.write(this.aw, 7);
    }
    if (this.ax != 0.333D) {
      paramJceOutputStream.write(this.ax, 8);
    }
    if (this.ay != 0.5D) {
      paramJceOutputStream.write(this.ay, 9);
    }
    if (this.az != 0.667D) {
      paramJceOutputStream.write(this.az, 10);
    }
    if (this.aA != 0.833D) {
      paramJceOutputStream.write(this.aA, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.g
 * JD-Core Version:    0.7.0.1
 */