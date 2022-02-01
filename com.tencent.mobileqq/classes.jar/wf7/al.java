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
    Object localObject = this.cY;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.cZ;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.da;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.db;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.dc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    int i = this.dd;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    i = this.cA;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    localObject = this.de;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.aX;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.df;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    i = this.cB;
    if (i != 0) {
      paramJceOutputStream.write(i, 12);
    }
    i = this.dg;
    if (i != 0) {
      paramJceOutputStream.write(i, 13);
    }
    i = this.dh;
    if (i != 0) {
      paramJceOutputStream.write(i, 14);
    }
    i = this.ba;
    if (i != 0) {
      paramJceOutputStream.write(i, 15);
    }
    localObject = this.di;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    short s = this.dj;
    if (s != 0) {
      paramJceOutputStream.write(s, 17);
    }
    double d1 = this.dk;
    if (d1 != 0.0D) {
      paramJceOutputStream.write(d1, 18);
    }
    d1 = this.dl;
    if (d1 != 0.0D) {
      paramJceOutputStream.write(d1, 19);
    }
    localObject = this.dm;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    i = this.dn;
    if (i != 0) {
      paramJceOutputStream.write(i, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.al
 * JD-Core Version:    0.7.0.1
 */