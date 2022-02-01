package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.u;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    int i = this.v;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    localObject = this.w;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    i = this.x;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    localObject = this.y;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    i = this.z;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.score;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    localObject = this.A;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 7);
    }
    localObject = this.B;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.ssid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    i = this.C;
    if (i != 0) {
      paramJceOutputStream.write(i, 10);
    }
    paramJceOutputStream.write(this.D, 11);
    localObject = this.E;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    i = this.F;
    if (i != 0) {
      paramJceOutputStream.write(i, 13);
    }
    i = this.G;
    if (i != 3) {
      paramJceOutputStream.write(i, 14);
    }
    i = this.H;
    if (i != -1) {
      paramJceOutputStream.write(i, 15);
    }
    i = this.I;
    if (i != -1) {
      paramJceOutputStream.write(i, 16);
    }
    paramJceOutputStream.write(this.J, 17);
    paramJceOutputStream.write(this.K, 18);
    paramJceOutputStream.write(this.L, 19);
    localObject = this.M;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    i = this.N;
    if (i != 0) {
      paramJceOutputStream.write(i, 21);
    }
    paramJceOutputStream.write(this.O, 22);
    localObject = this.P;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    float f = this.Q;
    if (f != 6.0F) {
      paramJceOutputStream.write(f, 24);
    }
    f = this.R;
    if (f != 4.0F) {
      paramJceOutputStream.write(f, 25);
    }
    i = this.S;
    if (i != 0) {
      paramJceOutputStream.write(i, 26);
    }
    f = this.T;
    if (f != 0.0F) {
      paramJceOutputStream.write(f, 27);
    }
    f = this.U;
    if (f != -1.0F) {
      paramJceOutputStream.write(f, 28);
    }
    localObject = this.V;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 29);
    }
    i = this.W;
    if (i != 0) {
      paramJceOutputStream.write(i, 30);
    }
    paramJceOutputStream.write(this.isBestWiFi, 31);
    localObject = this.X;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 32);
    }
    i = this.Y;
    if (i != 0) {
      paramJceOutputStream.write(i, 33);
    }
    i = this.Z;
    if (i != 0) {
      paramJceOutputStream.write(i, 34);
    }
    i = this.aa;
    if (1 != i) {
      paramJceOutputStream.write(i, 35);
    }
    localObject = this.ab;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 36);
    }
    localObject = this.ac;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 37);
    }
    i = this.ad;
    if (i != 0) {
      paramJceOutputStream.write(i, 38);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.d
 * JD-Core Version:    0.7.0.1
 */