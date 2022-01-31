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
  
  public JceStruct newInit()
  {
    return new an();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
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
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imei, 0);
    if (this.imsi != null) {
      paramJceOutputStream.write(this.imsi, 1);
    }
    if (this.mac != null) {
      paramJceOutputStream.write(this.mac, 2);
    }
    if (this.qq != null) {
      paramJceOutputStream.write(this.qq, 3);
    }
    if (this.phone != null) {
      paramJceOutputStream.write(this.phone, 4);
    }
    if (1 != this.product) {
      paramJceOutputStream.write(this.product, 5);
    }
    if (this.lc != null) {
      paramJceOutputStream.write(this.lc, 6);
    }
    if (this.buildno != 0) {
      paramJceOutputStream.write(this.buildno, 7);
    }
    if (this.channelid != null) {
      paramJceOutputStream.write(this.channelid, 8);
    }
    if (this.bR != 0) {
      paramJceOutputStream.write(this.bR, 9);
    }
    if (this.subplatform != 0) {
      paramJceOutputStream.write(this.subplatform, 10);
    }
    paramJceOutputStream.write(this.bS, 11);
    if (this.pkgname != null) {
      paramJceOutputStream.write(this.pkgname, 12);
    }
    if (this.ua != null) {
      paramJceOutputStream.write(this.ua, 13);
    }
    if (this.bT != 0) {
      paramJceOutputStream.write(this.bT, 14);
    }
    if (this.androidid != null) {
      paramJceOutputStream.write(this.androidid, 15);
    }
    if (this.lang != 0) {
      paramJceOutputStream.write(this.lang, 16);
    }
    if (this.bU != 0) {
      paramJceOutputStream.write(this.bU, 17);
    }
    if (this.bV != null) {
      paramJceOutputStream.write(this.bV, 18);
    }
    if (this.bW != null) {
      paramJceOutputStream.write(this.bW, 19);
    }
    if (this.bX != 0) {
      paramJceOutputStream.write(this.bX, 20);
    }
    if (this.bY != null) {
      paramJceOutputStream.write(this.bY, 21);
    }
    if (this.bZ != 0L) {
      paramJceOutputStream.write(this.bZ, 22);
    }
    if (this.ca != 0L) {
      paramJceOutputStream.write(this.ca, 23);
    }
    if (this.cb != 0L) {
      paramJceOutputStream.write(this.cb, 24);
    }
    if (this.cc != null) {
      paramJceOutputStream.write(this.cc, 25);
    }
    if (this.cd != null) {
      paramJceOutputStream.write(this.cd, 26);
    }
    if (this.ce != null) {
      paramJceOutputStream.write(this.ce, 27);
    }
    if (this.cf != null) {
      paramJceOutputStream.write(this.cf, 28);
    }
    if (this.cg != null) {
      paramJceOutputStream.write(this.cg, 29);
    }
    if (this.ch != null) {
      paramJceOutputStream.write(this.ch, 30);
    }
    if (this.ci != null) {
      paramJceOutputStream.write(this.ci, 31);
    }
    if (this.cj != null) {
      paramJceOutputStream.write(this.cj, 32);
    }
    if (this.ck != 0) {
      paramJceOutputStream.write(this.ck, 33);
    }
    if (this.cl != 0) {
      paramJceOutputStream.write(this.cl, 34);
    }
    paramJceOutputStream.write(this.cm, 35);
    if (this.cn != null) {
      paramJceOutputStream.write(this.cn, 36);
    }
    if (this.co != null) {
      paramJceOutputStream.write(this.co, 37);
    }
    if (this.cp != null) {
      paramJceOutputStream.write(this.cp, 38);
    }
    paramJceOutputStream.write(this.cq, 39);
    paramJceOutputStream.write(this.cr, 40);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 41);
    }
    if (this.cs != 1) {
      paramJceOutputStream.write(this.cs, 42);
    }
    if (this.cu != null) {
      paramJceOutputStream.write(this.cu, 43);
    }
    if (this.cv != null) {
      paramJceOutputStream.write(this.cv, 44);
    }
    if (this.cw != null) {
      paramJceOutputStream.write(this.cw, 45);
    }
    if (this.cx != null) {
      paramJceOutputStream.write(this.cx, 46);
    }
    if (this.cy != null) {
      paramJceOutputStream.write(this.cy, 47);
    }
    if (this.cz != null) {
      paramJceOutputStream.write(this.cz, 48);
    }
    if (this.cA != null) {
      paramJceOutputStream.write(this.cA, 49);
    }
    if (this.cB != null) {
      paramJceOutputStream.write(this.cB, 50);
    }
    if (this.cC != null) {
      paramJceOutputStream.write(this.cC, 51);
    }
    if (this.cD != 0L) {
      paramJceOutputStream.write(this.cD, 52);
    }
    if (this.cE != null) {
      paramJceOutputStream.write(this.cE, 53);
    }
    if (this.cF != null) {
      paramJceOutputStream.write(this.cF, 54);
    }
    if (this.cG != 0) {
      paramJceOutputStream.write(this.cG, 55);
    }
    if (this.cH != null) {
      paramJceOutputStream.write(this.cH, 56);
    }
    if (this.cI != null) {
      paramJceOutputStream.write(this.cI, 57);
    }
    if (this.cJ != null) {
      paramJceOutputStream.write(this.cJ, 58);
    }
    if (this.cK != 1) {
      paramJceOutputStream.write(this.cK, 59);
    }
    if (this.cL != null) {
      paramJceOutputStream.write(this.cL, 60);
    }
    if (this.cM != null) {
      paramJceOutputStream.write(this.cM, 61);
    }
    if (this.cN != null) {
      paramJceOutputStream.write(this.cN, 62);
    }
    if (this.cO != null) {
      paramJceOutputStream.write(this.cO, 63);
    }
    if (this.cP != null) {
      paramJceOutputStream.write(this.cP, 64);
    }
    if (this.cQ != null) {
      paramJceOutputStream.write(this.cQ, 65);
    }
    if (this.cR != null) {
      paramJceOutputStream.write(this.cR, 66);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.an
 * JD-Core Version:    0.7.0.1
 */