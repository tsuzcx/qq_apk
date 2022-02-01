package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class dl
  extends JceStruct
{
  public int ba = 0;
  public int cA = 1;
  public int cH = 0;
  public String cY = "";
  public String cZ = "";
  public String d = "";
  public String db = "";
  public String dc = "";
  public String df = "";
  public short dj = 0;
  public String h = "";
  public String kA = "";
  public String kB = "";
  public String kC = "";
  public String kD = "";
  public String kE = "";
  public String kF = "";
  public String kG = "";
  public int kH = 0;
  public int kI = 0;
  public boolean kJ = false;
  public String kK = "";
  public String kL = "";
  public String kM = "";
  public boolean kN = false;
  public boolean kO = false;
  public int kP = 1;
  public String kQ = "";
  public String kR = "";
  public String kS = "";
  public String kT = "";
  public String kU = "";
  public String kV = "";
  public String kW = "";
  public String kX = "";
  public String kY = "";
  public long kZ = 0L;
  public String kl = "";
  public int km = 0;
  public boolean kn = false;
  public String ko = "";
  public int kp = 0;
  public String kq = "";
  public int kr = 0;
  public String ks = "";
  public String kt = "";
  public int ku = 0;
  public String kv = "";
  public long kw = 0L;
  public long kx = 0L;
  public long ky = 0L;
  public String kz = "";
  public String la = "";
  public String lb = "";
  public int lc = 0;
  public String ld = "";
  public String le = "";
  public String lf = "";
  public String version = "";
  
  public JceStruct newInit()
  {
    return new dl();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.d = paramJceInputStream.readString(0, true);
    this.df = paramJceInputStream.readString(1, false);
    this.kl = paramJceInputStream.readString(2, false);
    this.cY = paramJceInputStream.readString(3, false);
    this.cZ = paramJceInputStream.readString(4, false);
    this.cA = paramJceInputStream.read(this.cA, 5, false);
    this.db = paramJceInputStream.readString(6, false);
    this.ba = paramJceInputStream.read(this.ba, 7, false);
    this.h = paramJceInputStream.readString(8, false);
    this.km = paramJceInputStream.read(this.km, 9, false);
    this.cH = paramJceInputStream.read(this.cH, 10, false);
    this.kn = paramJceInputStream.read(this.kn, 11, false);
    this.ko = paramJceInputStream.readString(12, false);
    this.dc = paramJceInputStream.readString(13, false);
    this.kp = paramJceInputStream.read(this.kp, 14, false);
    this.kq = paramJceInputStream.readString(15, false);
    this.dj = paramJceInputStream.read(this.dj, 16, false);
    this.kr = paramJceInputStream.read(this.kr, 17, false);
    this.ks = paramJceInputStream.readString(18, false);
    this.kt = paramJceInputStream.readString(19, false);
    this.ku = paramJceInputStream.read(this.ku, 20, false);
    this.kv = paramJceInputStream.readString(21, false);
    this.kw = paramJceInputStream.read(this.kw, 22, false);
    this.kx = paramJceInputStream.read(this.kx, 23, false);
    this.ky = paramJceInputStream.read(this.ky, 24, false);
    this.kz = paramJceInputStream.readString(25, false);
    this.kA = paramJceInputStream.readString(26, false);
    this.kB = paramJceInputStream.readString(27, false);
    this.kC = paramJceInputStream.readString(28, false);
    this.kD = paramJceInputStream.readString(29, false);
    this.kE = paramJceInputStream.readString(30, false);
    this.kF = paramJceInputStream.readString(31, false);
    this.kG = paramJceInputStream.readString(32, false);
    this.kH = paramJceInputStream.read(this.kH, 33, false);
    this.kI = paramJceInputStream.read(this.kI, 34, false);
    this.kJ = paramJceInputStream.read(this.kJ, 35, false);
    this.kK = paramJceInputStream.readString(36, false);
    this.kL = paramJceInputStream.readString(37, false);
    this.kM = paramJceInputStream.readString(38, false);
    this.kN = paramJceInputStream.read(this.kN, 39, false);
    this.kO = paramJceInputStream.read(this.kO, 40, false);
    this.version = paramJceInputStream.readString(41, false);
    this.kP = paramJceInputStream.read(this.kP, 42, false);
    this.kQ = paramJceInputStream.readString(43, false);
    this.kR = paramJceInputStream.readString(44, false);
    this.kS = paramJceInputStream.readString(45, false);
    this.kT = paramJceInputStream.readString(46, false);
    this.kU = paramJceInputStream.readString(47, false);
    this.kV = paramJceInputStream.readString(48, false);
    this.kW = paramJceInputStream.readString(49, false);
    this.kX = paramJceInputStream.readString(50, false);
    this.kY = paramJceInputStream.readString(51, false);
    this.kZ = paramJceInputStream.read(this.kZ, 52, false);
    this.la = paramJceInputStream.readString(53, false);
    this.lb = paramJceInputStream.readString(54, false);
    this.lc = paramJceInputStream.read(this.lc, 55, false);
    this.ld = paramJceInputStream.readString(56, false);
    this.le = paramJceInputStream.readString(57, false);
    this.lf = paramJceInputStream.readString(58, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.d, 0);
    String str = this.df;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.kl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.cY;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.cZ;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int i = this.cA;
    if (1 != i) {
      paramJceOutputStream.write(i, 5);
    }
    str = this.db;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    i = this.ba;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    str = this.h;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    i = this.km;
    if (i != 0) {
      paramJceOutputStream.write(i, 9);
    }
    i = this.cH;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    paramJceOutputStream.write(this.kn, 11);
    str = this.ko;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.dc;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    i = this.kp;
    if (i != 0) {
      paramJceOutputStream.write(i, 14);
    }
    str = this.kq;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    short s = this.dj;
    if (s != 0) {
      paramJceOutputStream.write(s, 16);
    }
    i = this.kr;
    if (i != 0) {
      paramJceOutputStream.write(i, 17);
    }
    str = this.ks;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    str = this.kt;
    if (str != null) {
      paramJceOutputStream.write(str, 19);
    }
    i = this.ku;
    if (i != 0) {
      paramJceOutputStream.write(i, 20);
    }
    str = this.kv;
    if (str != null) {
      paramJceOutputStream.write(str, 21);
    }
    long l = this.kw;
    if (l != 0L) {
      paramJceOutputStream.write(l, 22);
    }
    l = this.kx;
    if (l != 0L) {
      paramJceOutputStream.write(l, 23);
    }
    l = this.ky;
    if (l != 0L) {
      paramJceOutputStream.write(l, 24);
    }
    str = this.kz;
    if (str != null) {
      paramJceOutputStream.write(str, 25);
    }
    str = this.kA;
    if (str != null) {
      paramJceOutputStream.write(str, 26);
    }
    str = this.kB;
    if (str != null) {
      paramJceOutputStream.write(str, 27);
    }
    str = this.kC;
    if (str != null) {
      paramJceOutputStream.write(str, 28);
    }
    str = this.kD;
    if (str != null) {
      paramJceOutputStream.write(str, 29);
    }
    str = this.kE;
    if (str != null) {
      paramJceOutputStream.write(str, 30);
    }
    str = this.kF;
    if (str != null) {
      paramJceOutputStream.write(str, 31);
    }
    str = this.kG;
    if (str != null) {
      paramJceOutputStream.write(str, 32);
    }
    i = this.kH;
    if (i != 0) {
      paramJceOutputStream.write(i, 33);
    }
    i = this.kI;
    if (i != 0) {
      paramJceOutputStream.write(i, 34);
    }
    paramJceOutputStream.write(this.kJ, 35);
    str = this.kK;
    if (str != null) {
      paramJceOutputStream.write(str, 36);
    }
    str = this.kL;
    if (str != null) {
      paramJceOutputStream.write(str, 37);
    }
    str = this.kM;
    if (str != null) {
      paramJceOutputStream.write(str, 38);
    }
    paramJceOutputStream.write(this.kN, 39);
    paramJceOutputStream.write(this.kO, 40);
    str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 41);
    }
    i = this.kP;
    if (i != 1) {
      paramJceOutputStream.write(i, 42);
    }
    str = this.kQ;
    if (str != null) {
      paramJceOutputStream.write(str, 43);
    }
    str = this.kR;
    if (str != null) {
      paramJceOutputStream.write(str, 44);
    }
    str = this.kS;
    if (str != null) {
      paramJceOutputStream.write(str, 45);
    }
    str = this.kT;
    if (str != null) {
      paramJceOutputStream.write(str, 46);
    }
    str = this.kU;
    if (str != null) {
      paramJceOutputStream.write(str, 47);
    }
    str = this.kV;
    if (str != null) {
      paramJceOutputStream.write(str, 48);
    }
    str = this.kW;
    if (str != null) {
      paramJceOutputStream.write(str, 49);
    }
    str = this.kX;
    if (str != null) {
      paramJceOutputStream.write(str, 50);
    }
    str = this.kY;
    if (str != null) {
      paramJceOutputStream.write(str, 51);
    }
    l = this.kZ;
    if (l != 0L) {
      paramJceOutputStream.write(l, 52);
    }
    str = this.la;
    if (str != null) {
      paramJceOutputStream.write(str, 53);
    }
    str = this.lb;
    if (str != null) {
      paramJceOutputStream.write(str, 54);
    }
    i = this.lc;
    if (i != 0) {
      paramJceOutputStream.write(i, 55);
    }
    str = this.ld;
    if (str != null) {
      paramJceOutputStream.write(str, 56);
    }
    str = this.le;
    if (str != null) {
      paramJceOutputStream.write(str, 57);
    }
    str = this.lf;
    if (str != null) {
      paramJceOutputStream.write(str, 58);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.dl
 * JD-Core Version:    0.7.0.1
 */