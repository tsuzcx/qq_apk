package taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList A;
  static d B;
  static ArrayList C;
  static ArrayList x = new ArrayList();
  static ArrayList y;
  static ArrayList z;
  public int a = 0;
  public String b = "";
  public boolean c = false;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public ArrayList h = null;
  public int i = 0;
  public int j = 0;
  public ArrayList k = null;
  public int l = 0;
  public String m = "";
  public String n = "";
  public int o = 0;
  public String p = "";
  public int q = 0;
  public ArrayList r = null;
  public int s = 0;
  public ArrayList t = null;
  public int u = 0;
  public d v = null;
  public ArrayList w = null;
  
  static
  {
    Object localObject = new c();
    x.add(localObject);
    y = new ArrayList();
    y.add("");
    z = new ArrayList();
    z.add("");
    A = new ArrayList();
    A.add("");
    B = new d();
    C = new ArrayList();
    localObject = new d();
    C.add(localObject);
  }
  
  public JceStruct newInit()
  {
    return new a();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = ((ArrayList)paramJceInputStream.read(x, 7, false));
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = ((ArrayList)paramJceInputStream.read(y, 10, false));
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = paramJceInputStream.readString(13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.readString(15, false);
    this.q = paramJceInputStream.read(this.q, 16, false);
    this.r = ((ArrayList)paramJceInputStream.read(z, 17, false));
    this.s = paramJceInputStream.read(this.s, 18, false);
    this.t = ((ArrayList)paramJceInputStream.read(A, 19, false));
    this.u = paramJceInputStream.read(this.u, 20, false);
    this.v = ((d)paramJceInputStream.read(B, 21, false));
    this.w = ((ArrayList)paramJceInputStream.read(C, 22, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != 0) {
      paramJceOutputStream.write(this.i, 8);
    }
    paramJceOutputStream.write(this.j, 9);
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 10);
    }
    if (this.l != 0) {
      paramJceOutputStream.write(this.l, 11);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 12);
    }
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
    paramJceOutputStream.write(this.o, 14);
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
    if (this.q != 0) {
      paramJceOutputStream.write(this.q, 16);
    }
    if (this.r != null) {
      paramJceOutputStream.write(this.r, 17);
    }
    if (this.s != 0) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != 0) {
      paramJceOutputStream.write(this.u, 20);
    }
    if (this.v != null) {
      paramJceOutputStream.write(this.v, 21);
    }
    if (this.w != null) {
      paramJceOutputStream.write(this.w, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.a
 * JD-Core Version:    0.7.0.1
 */