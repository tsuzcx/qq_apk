package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class al
  extends JceStruct
{
  static aj jdField_do = new aj();
  public String aX = "";
  public int ba = 0;
  public int cA = 0;
  public int cB = 0;
  public String cY = "";
  public String cZ = "";
  public String d = "";
  public String da = "";
  public String db = "";
  public String dc = "";
  public int dd = 0;
  public aj de = null;
  public String df = "";
  public int dg = 0;
  public int dh = 0;
  public String di = "";
  public short dj = 0;
  public double dk = 0.0D;
  public double dl = 0.0D;
  public String dm = "";
  public int dn = 0;
  public String h = "";
  
  public JceStruct newInit()
  {
    return new al();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.d = paramJceInputStream.readString(0, true);
    this.cY = paramJceInputStream.readString(1, false);
    this.cZ = paramJceInputStream.readString(2, false);
    this.da = paramJceInputStream.readString(3, false);
    this.db = paramJceInputStream.readString(4, false);
    this.h = paramJceInputStream.readString(5, false);
    this.dc = paramJceInputStream.readString(6, false);
    this.dd = paramJceInputStream.read(this.dd, 7, false);
    this.cA = paramJceInputStream.read(this.cA, 8, false);
    this.de = ((aj)paramJceInputStream.read(jdField_do, 9, false));
    this.aX = paramJceInputStream.readString(10, false);
    this.df = paramJceInputStream.readString(11, false);
    this.cB = paramJceInputStream.read(this.cB, 12, false);
    this.dg = paramJceInputStream.read(this.dg, 13, false);
    this.dh = paramJceInputStream.read(this.dh, 14, false);
    this.ba = paramJceInputStream.read(this.ba, 15, false);
    this.di = paramJceInputStream.readString(16, false);
    this.dj = paramJceInputStream.read(this.dj, 17, false);
    this.dk = paramJceInputStream.read(this.dk, 18, false);
    this.dl = paramJceInputStream.read(this.dl, 19, false);
    this.dm = paramJceInputStream.readString(20, false);
    this.dn = paramJceInputStream.read(this.dn, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.d, 0);
    if (this.cY != null) {
      paramJceOutputStream.write(this.cY, 1);
    }
    if (this.cZ != null) {
      paramJceOutputStream.write(this.cZ, 2);
    }
    if (this.da != null) {
      paramJceOutputStream.write(this.da, 3);
    }
    if (this.db != null) {
      paramJceOutputStream.write(this.db, 4);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 5);
    }
    if (this.dc != null) {
      paramJceOutputStream.write(this.dc, 6);
    }
    if (this.dd != 0) {
      paramJceOutputStream.write(this.dd, 7);
    }
    if (this.cA != 0) {
      paramJceOutputStream.write(this.cA, 8);
    }
    if (this.de != null) {
      paramJceOutputStream.write(this.de, 9);
    }
    if (this.aX != null) {
      paramJceOutputStream.write(this.aX, 10);
    }
    if (this.df != null) {
      paramJceOutputStream.write(this.df, 11);
    }
    if (this.cB != 0) {
      paramJceOutputStream.write(this.cB, 12);
    }
    if (this.dg != 0) {
      paramJceOutputStream.write(this.dg, 13);
    }
    if (this.dh != 0) {
      paramJceOutputStream.write(this.dh, 14);
    }
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 15);
    }
    if (this.di != null) {
      paramJceOutputStream.write(this.di, 16);
    }
    if (this.dj != 0) {
      paramJceOutputStream.write(this.dj, 17);
    }
    if (this.dk != 0.0D) {
      paramJceOutputStream.write(this.dk, 18);
    }
    if (this.dl != 0.0D) {
      paramJceOutputStream.write(this.dl, 19);
    }
    if (this.dm != null) {
      paramJceOutputStream.write(this.dm, 20);
    }
    if (this.dn != 0) {
      paramJceOutputStream.write(this.dn, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.al
 * JD-Core Version:    0.7.0.1
 */