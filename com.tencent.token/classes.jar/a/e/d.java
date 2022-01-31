package a.e;

import a.b.a;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class d
  extends JceStruct
{
  static a f;
  static ArrayList g;
  public int a = 0;
  public int b = 0;
  public int c = 1;
  public a d = null;
  public ArrayList e = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    if (f == null) {
      f = new a();
    }
    this.d = ((a)paramJceInputStream.read(f, 3, false));
    if (g == null)
    {
      g = new ArrayList();
      c localc = new c();
      g.add(localc);
    }
    this.e = ((ArrayList)paramJceInputStream.read(g, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != 0) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (this.b != 0) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != 1) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.d
 * JD-Core Version:    0.7.0.1
 */