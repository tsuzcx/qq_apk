package a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class g
  extends JceStruct
{
  static ArrayList d;
  public int a = 0;
  public int b = 0;
  public ArrayList c = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    if (d == null)
    {
      d = new ArrayList();
      f localf = new f();
      d.add(localf);
    }
    this.c = ((ArrayList)paramJceInputStream.read(d, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != 0) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (this.b != 0) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.g
 * JD-Core Version:    0.7.0.1
 */