package b.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class h
  extends JceStruct
{
  static byte[] p;
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  public int d = 0;
  public long e = 0L;
  public int f = 0;
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public byte[] k = null;
  public String l = "";
  public long m = 0L;
  public long n = 0L;
  public String o = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, true);
    this.d = paramJceInputStream.read(this.d, 3, true);
    this.e = paramJceInputStream.read(this.e, 4, true);
    this.f = paramJceInputStream.read(this.f, 5, true);
    this.g = paramJceInputStream.readString(6, true);
    this.h = paramJceInputStream.readString(7, true);
    this.i = paramJceInputStream.readString(8, true);
    this.j = paramJceInputStream.readString(9, true);
    if (p == null)
    {
      p = (byte[])new byte[1];
      ((byte[])p)[0] = 0;
    }
    this.k = ((byte[])paramJceInputStream.read(p, 10, true));
    this.l = paramJceInputStream.readString(11, true);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    if (this.o != null) {
      paramJceOutputStream.write(this.o, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     b.a.h
 * JD-Core Version:    0.7.0.1
 */