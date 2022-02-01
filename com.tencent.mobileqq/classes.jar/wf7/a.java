package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    long l1 = this.b;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.e, 4);
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    int n = this.g;
    if (n != 0) {
      paramJceOutputStream.write(n, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    l1 = this.i;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 8);
    }
    n = this.j;
    if (-1 != n) {
      paramJceOutputStream.write(n, 9);
    }
    localObject = this.k;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.a
 * JD-Core Version:    0.7.0.1
 */