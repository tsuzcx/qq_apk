package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class d
  extends JceStruct
{
  static byte[] ae = (byte[])new byte[1];
  static ArrayList<e> af;
  static byte[] ag;
  public byte[] A = null;
  public String B = "";
  public int C = 0;
  public boolean D = false;
  public String E = "";
  public int F = 0;
  public int G = 3;
  public int H = -1;
  public int I = -1;
  public boolean J = true;
  public boolean K = true;
  public boolean L = false;
  public String M = "";
  public int N = 0;
  public boolean O = true;
  public String P = "";
  public float Q = 6.0F;
  public float R = 4.0F;
  public int S = 0;
  public float T = 0.0F;
  public float U = -1.0F;
  public String V = "";
  public int W = 0;
  public String X = "";
  public int Y = 0;
  public int Z = 0;
  public int aa = 1;
  public String ab = "";
  public String ac = "";
  public int ad = 0;
  public boolean isBestWiFi = false;
  public int score = 0;
  public String ssid = "";
  public byte[] u = null;
  public int v = 0;
  public ArrayList<e> w = null;
  public int x = 0;
  public String y = "";
  public int z = 0;
  
  static
  {
    ((byte[])ae)[0] = 0;
    af = new ArrayList();
    e locale = new e();
    af.add(locale);
    ag = (byte[])new byte[1];
    ((byte[])ag)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new d();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.u = ((byte[])paramJceInputStream.read(ae, 0, false));
    this.v = paramJceInputStream.read(this.v, 1, false);
    this.w = ((ArrayList)paramJceInputStream.read(af, 2, false));
    this.x = paramJceInputStream.read(this.x, 3, false);
    this.y = paramJceInputStream.readString(4, false);
    this.z = paramJceInputStream.read(this.z, 5, false);
    this.score = paramJceInputStream.read(this.score, 6, false);
    this.A = ((byte[])paramJceInputStream.read(ag, 7, false));
    this.B = paramJceInputStream.readString(8, false);
    this.ssid = paramJceInputStream.readString(9, false);
    this.C = paramJceInputStream.read(this.C, 10, false);
    this.D = paramJceInputStream.read(this.D, 11, false);
    this.E = paramJceInputStream.readString(12, false);
    this.F = paramJceInputStream.read(this.F, 13, false);
    this.G = paramJceInputStream.read(this.G, 14, false);
    this.H = paramJceInputStream.read(this.H, 15, false);
    this.I = paramJceInputStream.read(this.I, 16, false);
    this.J = paramJceInputStream.read(this.J, 17, false);
    this.K = paramJceInputStream.read(this.K, 18, false);
    this.L = paramJceInputStream.read(this.L, 19, false);
    this.M = paramJceInputStream.readString(20, false);
    this.N = paramJceInputStream.read(this.N, 21, false);
    this.O = paramJceInputStream.read(this.O, 22, false);
    this.P = paramJceInputStream.readString(23, false);
    this.Q = paramJceInputStream.read(this.Q, 24, false);
    this.R = paramJceInputStream.read(this.R, 25, false);
    this.S = paramJceInputStream.read(this.S, 26, false);
    this.T = paramJceInputStream.read(this.T, 27, false);
    this.U = paramJceInputStream.read(this.U, 28, false);
    this.V = paramJceInputStream.readString(29, false);
    this.W = paramJceInputStream.read(this.W, 30, false);
    this.isBestWiFi = paramJceInputStream.read(this.isBestWiFi, 31, false);
    this.X = paramJceInputStream.readString(32, false);
    this.Y = paramJceInputStream.read(this.Y, 33, false);
    this.Z = paramJceInputStream.read(this.Z, 34, false);
    this.aa = paramJceInputStream.read(this.aa, 35, false);
    this.ab = paramJceInputStream.readString(36, false);
    this.ac = paramJceInputStream.readString(37, false);
    this.ad = paramJceInputStream.read(this.ad, 38, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 0);
    }
    if (this.v != 0) {
      paramJceOutputStream.write(this.v, 1);
    }
    if (this.w != null) {
      paramJceOutputStream.write(this.w, 2);
    }
    if (this.x != 0) {
      paramJceOutputStream.write(this.x, 3);
    }
    if (this.y != null) {
      paramJceOutputStream.write(this.y, 4);
    }
    if (this.z != 0) {
      paramJceOutputStream.write(this.z, 5);
    }
    if (this.score != 0) {
      paramJceOutputStream.write(this.score, 6);
    }
    if (this.A != null) {
      paramJceOutputStream.write(this.A, 7);
    }
    if (this.B != null) {
      paramJceOutputStream.write(this.B, 8);
    }
    if (this.ssid != null) {
      paramJceOutputStream.write(this.ssid, 9);
    }
    if (this.C != 0) {
      paramJceOutputStream.write(this.C, 10);
    }
    paramJceOutputStream.write(this.D, 11);
    if (this.E != null) {
      paramJceOutputStream.write(this.E, 12);
    }
    if (this.F != 0) {
      paramJceOutputStream.write(this.F, 13);
    }
    if (this.G != 3) {
      paramJceOutputStream.write(this.G, 14);
    }
    if (this.H != -1) {
      paramJceOutputStream.write(this.H, 15);
    }
    if (this.I != -1) {
      paramJceOutputStream.write(this.I, 16);
    }
    paramJceOutputStream.write(this.J, 17);
    paramJceOutputStream.write(this.K, 18);
    paramJceOutputStream.write(this.L, 19);
    if (this.M != null) {
      paramJceOutputStream.write(this.M, 20);
    }
    if (this.N != 0) {
      paramJceOutputStream.write(this.N, 21);
    }
    paramJceOutputStream.write(this.O, 22);
    if (this.P != null) {
      paramJceOutputStream.write(this.P, 23);
    }
    if (this.Q != 6.0F) {
      paramJceOutputStream.write(this.Q, 24);
    }
    if (this.R != 4.0F) {
      paramJceOutputStream.write(this.R, 25);
    }
    if (this.S != 0) {
      paramJceOutputStream.write(this.S, 26);
    }
    if (this.T != 0.0F) {
      paramJceOutputStream.write(this.T, 27);
    }
    if (this.U != -1.0F) {
      paramJceOutputStream.write(this.U, 28);
    }
    if (this.V != null) {
      paramJceOutputStream.write(this.V, 29);
    }
    if (this.W != 0) {
      paramJceOutputStream.write(this.W, 30);
    }
    paramJceOutputStream.write(this.isBestWiFi, 31);
    if (this.X != null) {
      paramJceOutputStream.write(this.X, 32);
    }
    if (this.Y != 0) {
      paramJceOutputStream.write(this.Y, 33);
    }
    if (this.Z != 0) {
      paramJceOutputStream.write(this.Z, 34);
    }
    if (1 != this.aa) {
      paramJceOutputStream.write(this.aa, 35);
    }
    if (this.ab != null) {
      paramJceOutputStream.write(this.ab, 36);
    }
    if (this.ac != null) {
      paramJceOutputStream.write(this.ac, 37);
    }
    if (this.ad != 0) {
      paramJceOutputStream.write(this.ad, 38);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.d
 * JD-Core Version:    0.7.0.1
 */