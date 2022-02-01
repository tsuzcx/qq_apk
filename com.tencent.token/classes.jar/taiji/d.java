package taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class d
  extends JceStruct
{
  static ArrayList<String> l = new ArrayList();
  static ArrayList<c> m;
  public String a = "";
  public int b = 3;
  public ArrayList<String> c = null;
  public int d = 0;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public ArrayList<c> j = null;
  public int k = 0;
  
  static
  {
    l.add("");
    m = new ArrayList();
    c localc = new c();
    m.add(localc);
  }
  
  public JceStruct newInit()
  {
    return new d();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = ((ArrayList)paramJceInputStream.read(l, 2, false));
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.readString(7, false);
    this.i = paramJceInputStream.readString(8, false);
    this.j = ((ArrayList)paramJceInputStream.read(m, 9, false));
    this.k = paramJceInputStream.read(this.k, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (3 != this.b) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != 0) {
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
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != 0) {
      paramJceOutputStream.write(this.k, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.d
 * JD-Core Version:    0.7.0.1
 */