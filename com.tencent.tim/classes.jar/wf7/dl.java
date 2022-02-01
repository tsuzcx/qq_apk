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
    if (this.df != null) {
      paramJceOutputStream.write(this.df, 1);
    }
    if (this.kl != null) {
      paramJceOutputStream.write(this.kl, 2);
    }
    if (this.cY != null) {
      paramJceOutputStream.write(this.cY, 3);
    }
    if (this.cZ != null) {
      paramJceOutputStream.write(this.cZ, 4);
    }
    if (1 != this.cA) {
      paramJceOutputStream.write(this.cA, 5);
    }
    if (this.db != null) {
      paramJceOutputStream.write(this.db, 6);
    }
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 7);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 8);
    }
    if (this.km != 0) {
      paramJceOutputStream.write(this.km, 9);
    }
    if (this.cH != 0) {
      paramJceOutputStream.write(this.cH, 10);
    }
    paramJceOutputStream.write(this.kn, 11);
    if (this.ko != null) {
      paramJceOutputStream.write(this.ko, 12);
    }
    if (this.dc != null) {
      paramJceOutputStream.write(this.dc, 13);
    }
    if (this.kp != 0) {
      paramJceOutputStream.write(this.kp, 14);
    }
    if (this.kq != null) {
      paramJceOutputStream.write(this.kq, 15);
    }
    if (this.dj != 0) {
      paramJceOutputStream.write(this.dj, 16);
    }
    if (this.kr != 0) {
      paramJceOutputStream.write(this.kr, 17);
    }
    if (this.ks != null) {
      paramJceOutputStream.write(this.ks, 18);
    }
    if (this.kt != null) {
      paramJceOutputStream.write(this.kt, 19);
    }
    if (this.ku != 0) {
      paramJceOutputStream.write(this.ku, 20);
    }
    if (this.kv != null) {
      paramJceOutputStream.write(this.kv, 21);
    }
    if (this.kw != 0L) {
      paramJceOutputStream.write(this.kw, 22);
    }
    if (this.kx != 0L) {
      paramJceOutputStream.write(this.kx, 23);
    }
    if (this.ky != 0L) {
      paramJceOutputStream.write(this.ky, 24);
    }
    if (this.kz != null) {
      paramJceOutputStream.write(this.kz, 25);
    }
    if (this.kA != null) {
      paramJceOutputStream.write(this.kA, 26);
    }
    if (this.kB != null) {
      paramJceOutputStream.write(this.kB, 27);
    }
    if (this.kC != null) {
      paramJceOutputStream.write(this.kC, 28);
    }
    if (this.kD != null) {
      paramJceOutputStream.write(this.kD, 29);
    }
    if (this.kE != null) {
      paramJceOutputStream.write(this.kE, 30);
    }
    if (this.kF != null) {
      paramJceOutputStream.write(this.kF, 31);
    }
    if (this.kG != null) {
      paramJceOutputStream.write(this.kG, 32);
    }
    if (this.kH != 0) {
      paramJceOutputStream.write(this.kH, 33);
    }
    if (this.kI != 0) {
      paramJceOutputStream.write(this.kI, 34);
    }
    paramJceOutputStream.write(this.kJ, 35);
    if (this.kK != null) {
      paramJceOutputStream.write(this.kK, 36);
    }
    if (this.kL != null) {
      paramJceOutputStream.write(this.kL, 37);
    }
    if (this.kM != null) {
      paramJceOutputStream.write(this.kM, 38);
    }
    paramJceOutputStream.write(this.kN, 39);
    paramJceOutputStream.write(this.kO, 40);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 41);
    }
    if (this.kP != 1) {
      paramJceOutputStream.write(this.kP, 42);
    }
    if (this.kQ != null) {
      paramJceOutputStream.write(this.kQ, 43);
    }
    if (this.kR != null) {
      paramJceOutputStream.write(this.kR, 44);
    }
    if (this.kS != null) {
      paramJceOutputStream.write(this.kS, 45);
    }
    if (this.kT != null) {
      paramJceOutputStream.write(this.kT, 46);
    }
    if (this.kU != null) {
      paramJceOutputStream.write(this.kU, 47);
    }
    if (this.kV != null) {
      paramJceOutputStream.write(this.kV, 48);
    }
    if (this.kW != null) {
      paramJceOutputStream.write(this.kW, 49);
    }
    if (this.kX != null) {
      paramJceOutputStream.write(this.kX, 50);
    }
    if (this.kY != null) {
      paramJceOutputStream.write(this.kY, 51);
    }
    if (this.kZ != 0L) {
      paramJceOutputStream.write(this.kZ, 52);
    }
    if (this.la != null) {
      paramJceOutputStream.write(this.la, 53);
    }
    if (this.lb != null) {
      paramJceOutputStream.write(this.lb, 54);
    }
    if (this.lc != 0) {
      paramJceOutputStream.write(this.lc, 55);
    }
    if (this.ld != null) {
      paramJceOutputStream.write(this.ld, 56);
    }
    if (this.le != null) {
      paramJceOutputStream.write(this.le, 57);
    }
    if (this.lf != null) {
      paramJceOutputStream.write(this.lf, 58);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.dl
 * JD-Core Version:    0.7.0.1
 */