package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class an
  extends JceStruct
{
  public String androidid = "";
  public int bR = 0;
  public boolean bS = false;
  public int bT = 0;
  public int bU = 0;
  public String bV = "";
  public String bW = "";
  public int bX = 0;
  public String bY = "";
  public long bZ = 0L;
  public int buildno = 0;
  public String cA = "";
  public String cB = "";
  public String cC = "";
  public long cD = 0L;
  public String cE = "";
  public String cF = "";
  public int cG = 0;
  public String cH = "";
  public String cI = "";
  public String cJ = "";
  public int cK = 1;
  public String cL = "";
  public String cM = "";
  public String cN = "";
  public String cO = "";
  public String cP = "";
  public String cQ = "";
  public String cR = "";
  public long ca = 0L;
  public long cb = 0L;
  public String cc = "";
  public String cd = "";
  public String ce = "";
  public String cf = "";
  public String cg = "";
  public String ch = "";
  public String channelid = "";
  public String ci = "";
  public String cj = "";
  public int ck = 0;
  public int cl = 0;
  public boolean cm = false;
  public String cn = "";
  public String co = "";
  public String cp = "";
  public boolean cq = false;
  public boolean cr = false;
  public int cs = 1;
  public String cu = "";
  public String cv = "";
  public String cw = "";
  public String cx = "";
  public String cy = "";
  public String cz = "";
  public String imei = "";
  public String imsi = "";
  public short lang = 0;
  public String lc = "";
  public String mac = "";
  public String phone = "";
  public String pkgname = "";
  public int product = 1;
  public String qq = "";
  public int subplatform = 0;
  public String ua = "";
  public String version = "";
  
  public final JceStruct newInit()
  {
    return new an();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, true);
    this.imsi = paramJceInputStream.readString(1, false);
    this.mac = paramJceInputStream.readString(2, false);
    this.qq = paramJceInputStream.readString(3, false);
    this.phone = paramJceInputStream.readString(4, false);
    this.product = paramJceInputStream.read(this.product, 5, false);
    this.lc = paramJceInputStream.readString(6, false);
    this.buildno = paramJceInputStream.read(this.buildno, 7, false);
    this.channelid = paramJceInputStream.readString(8, false);
    this.bR = paramJceInputStream.read(this.bR, 9, false);
    this.subplatform = paramJceInputStream.read(this.subplatform, 10, false);
    this.bS = paramJceInputStream.read(this.bS, 11, false);
    this.pkgname = paramJceInputStream.readString(12, false);
    this.ua = paramJceInputStream.readString(13, false);
    this.bT = paramJceInputStream.read(this.bT, 14, false);
    this.androidid = paramJceInputStream.readString(15, false);
    this.lang = paramJceInputStream.read(this.lang, 16, false);
    this.bU = paramJceInputStream.read(this.bU, 17, false);
    this.bV = paramJceInputStream.readString(18, false);
    this.bW = paramJceInputStream.readString(19, false);
    this.bX = paramJceInputStream.read(this.bX, 20, false);
    this.bY = paramJceInputStream.readString(21, false);
    this.bZ = paramJceInputStream.read(this.bZ, 22, false);
    this.ca = paramJceInputStream.read(this.ca, 23, false);
    this.cb = paramJceInputStream.read(this.cb, 24, false);
    this.cc = paramJceInputStream.readString(25, false);
    this.cd = paramJceInputStream.readString(26, false);
    this.ce = paramJceInputStream.readString(27, false);
    this.cf = paramJceInputStream.readString(28, false);
    this.cg = paramJceInputStream.readString(29, false);
    this.ch = paramJceInputStream.readString(30, false);
    this.ci = paramJceInputStream.readString(31, false);
    this.cj = paramJceInputStream.readString(32, false);
    this.ck = paramJceInputStream.read(this.ck, 33, false);
    this.cl = paramJceInputStream.read(this.cl, 34, false);
    this.cm = paramJceInputStream.read(this.cm, 35, false);
    this.cn = paramJceInputStream.readString(36, false);
    this.co = paramJceInputStream.readString(37, false);
    this.cp = paramJceInputStream.readString(38, false);
    this.cq = paramJceInputStream.read(this.cq, 39, false);
    this.cr = paramJceInputStream.read(this.cr, 40, false);
    this.version = paramJceInputStream.readString(41, false);
    this.cs = paramJceInputStream.read(this.cs, 42, false);
    this.cu = paramJceInputStream.readString(43, false);
    this.cv = paramJceInputStream.readString(44, false);
    this.cw = paramJceInputStream.readString(45, false);
    this.cx = paramJceInputStream.readString(46, false);
    this.cy = paramJceInputStream.readString(47, false);
    this.cz = paramJceInputStream.readString(48, false);
    this.cA = paramJceInputStream.readString(49, false);
    this.cB = paramJceInputStream.readString(50, false);
    this.cC = paramJceInputStream.readString(51, false);
    this.cD = paramJceInputStream.read(this.cD, 52, false);
    this.cE = paramJceInputStream.readString(53, false);
    this.cF = paramJceInputStream.readString(54, false);
    this.cG = paramJceInputStream.read(this.cG, 55, false);
    this.cH = paramJceInputStream.readString(56, false);
    this.cI = paramJceInputStream.readString(57, false);
    this.cJ = paramJceInputStream.readString(58, false);
    this.cK = paramJceInputStream.read(this.cK, 59, false);
    this.cL = paramJceInputStream.readString(60, false);
    this.cM = paramJceInputStream.readString(61, false);
    this.cN = paramJceInputStream.readString(62, false);
    this.cO = paramJceInputStream.readString(63, false);
    this.cP = paramJceInputStream.readString(64, false);
    this.cQ = paramJceInputStream.readString(65, false);
    this.cR = paramJceInputStream.readString(66, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    String str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.mac;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.qq;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.phone;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int i = this.product;
    if (1 != i) {
      paramJceOutputStream.write(i, 5);
    }
    str = this.lc;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    i = this.buildno;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
    str = this.channelid;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    i = this.bR;
    if (i != 0) {
      paramJceOutputStream.write(i, 9);
    }
    i = this.subplatform;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    paramJceOutputStream.write(this.bS, 11);
    str = this.pkgname;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.ua;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    i = this.bT;
    if (i != 0) {
      paramJceOutputStream.write(i, 14);
    }
    str = this.androidid;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    short s = this.lang;
    if (s != 0) {
      paramJceOutputStream.write(s, 16);
    }
    i = this.bU;
    if (i != 0) {
      paramJceOutputStream.write(i, 17);
    }
    str = this.bV;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    str = this.bW;
    if (str != null) {
      paramJceOutputStream.write(str, 19);
    }
    i = this.bX;
    if (i != 0) {
      paramJceOutputStream.write(i, 20);
    }
    str = this.bY;
    if (str != null) {
      paramJceOutputStream.write(str, 21);
    }
    long l = this.bZ;
    if (l != 0L) {
      paramJceOutputStream.write(l, 22);
    }
    l = this.ca;
    if (l != 0L) {
      paramJceOutputStream.write(l, 23);
    }
    l = this.cb;
    if (l != 0L) {
      paramJceOutputStream.write(l, 24);
    }
    str = this.cc;
    if (str != null) {
      paramJceOutputStream.write(str, 25);
    }
    str = this.cd;
    if (str != null) {
      paramJceOutputStream.write(str, 26);
    }
    str = this.ce;
    if (str != null) {
      paramJceOutputStream.write(str, 27);
    }
    str = this.cf;
    if (str != null) {
      paramJceOutputStream.write(str, 28);
    }
    str = this.cg;
    if (str != null) {
      paramJceOutputStream.write(str, 29);
    }
    str = this.ch;
    if (str != null) {
      paramJceOutputStream.write(str, 30);
    }
    str = this.ci;
    if (str != null) {
      paramJceOutputStream.write(str, 31);
    }
    str = this.cj;
    if (str != null) {
      paramJceOutputStream.write(str, 32);
    }
    i = this.ck;
    if (i != 0) {
      paramJceOutputStream.write(i, 33);
    }
    i = this.cl;
    if (i != 0) {
      paramJceOutputStream.write(i, 34);
    }
    paramJceOutputStream.write(this.cm, 35);
    str = this.cn;
    if (str != null) {
      paramJceOutputStream.write(str, 36);
    }
    str = this.co;
    if (str != null) {
      paramJceOutputStream.write(str, 37);
    }
    str = this.cp;
    if (str != null) {
      paramJceOutputStream.write(str, 38);
    }
    paramJceOutputStream.write(this.cq, 39);
    paramJceOutputStream.write(this.cr, 40);
    str = this.version;
    if (str != null) {
      paramJceOutputStream.write(str, 41);
    }
    i = this.cs;
    if (i != 1) {
      paramJceOutputStream.write(i, 42);
    }
    str = this.cu;
    if (str != null) {
      paramJceOutputStream.write(str, 43);
    }
    str = this.cv;
    if (str != null) {
      paramJceOutputStream.write(str, 44);
    }
    str = this.cw;
    if (str != null) {
      paramJceOutputStream.write(str, 45);
    }
    str = this.cx;
    if (str != null) {
      paramJceOutputStream.write(str, 46);
    }
    str = this.cy;
    if (str != null) {
      paramJceOutputStream.write(str, 47);
    }
    str = this.cz;
    if (str != null) {
      paramJceOutputStream.write(str, 48);
    }
    str = this.cA;
    if (str != null) {
      paramJceOutputStream.write(str, 49);
    }
    str = this.cB;
    if (str != null) {
      paramJceOutputStream.write(str, 50);
    }
    str = this.cC;
    if (str != null) {
      paramJceOutputStream.write(str, 51);
    }
    l = this.cD;
    if (l != 0L) {
      paramJceOutputStream.write(l, 52);
    }
    str = this.cE;
    if (str != null) {
      paramJceOutputStream.write(str, 53);
    }
    str = this.cF;
    if (str != null) {
      paramJceOutputStream.write(str, 54);
    }
    i = this.cG;
    if (i != 0) {
      paramJceOutputStream.write(i, 55);
    }
    str = this.cH;
    if (str != null) {
      paramJceOutputStream.write(str, 56);
    }
    str = this.cI;
    if (str != null) {
      paramJceOutputStream.write(str, 57);
    }
    str = this.cJ;
    if (str != null) {
      paramJceOutputStream.write(str, 58);
    }
    i = this.cK;
    if (i != 1) {
      paramJceOutputStream.write(i, 59);
    }
    str = this.cL;
    if (str != null) {
      paramJceOutputStream.write(str, 60);
    }
    str = this.cM;
    if (str != null) {
      paramJceOutputStream.write(str, 61);
    }
    str = this.cN;
    if (str != null) {
      paramJceOutputStream.write(str, 62);
    }
    str = this.cO;
    if (str != null) {
      paramJceOutputStream.write(str, 63);
    }
    str = this.cP;
    if (str != null) {
      paramJceOutputStream.write(str, 64);
    }
    str = this.cQ;
    if (str != null) {
      paramJceOutputStream.write(str, 65);
    }
    str = this.cR;
    if (str != null) {
      paramJceOutputStream.write(str, 66);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.an
 * JD-Core Version:    0.7.0.1
 */