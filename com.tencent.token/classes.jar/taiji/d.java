package taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    int n = this.b;
    if (3 != n) {
      paramJceOutputStream.write(n, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    n = this.d;
    if (n != 0) {
      paramJceOutputStream.write(n, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    n = this.k;
    if (n != 0) {
      paramJceOutputStream.write(n, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.d
 * JD-Core Version:    0.7.0.1
 */