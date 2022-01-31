package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<h> l = new ArrayList();
  static ArrayList<h> m;
  public ArrayList<h> a = null;
  public long b = 0L;
  public String c = "";
  public String d = "";
  public boolean e = false;
  public String f = "";
  public int g = 0;
  public String h = "";
  public long i = 0L;
  public int j = -1;
  public ArrayList<h> k = null;
  
  static
  {
    h localh = new h();
    l.add(localh);
    m = new ArrayList();
    localh = new h();
    m.add(localh);
  }
  
  public JceStruct newInit()
  {
    return new a();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(l, 0, false));
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.readString(7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = ((ArrayList)paramJceInputStream.read(m, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (this.b != 0L) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != 0) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != 0L) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (-1 != this.j) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.a
 * JD-Core Version:    0.7.0.1
 */