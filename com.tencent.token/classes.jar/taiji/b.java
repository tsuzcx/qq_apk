package taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList f = new ArrayList();
  public int a = 0;
  public int b = 0;
  public ArrayList c = null;
  public String d = "";
  public int e = 0;
  
  static
  {
    a locala = new a();
    f.add(locala);
  }
  
  public JceStruct newInit()
  {
    return new b();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = ((ArrayList)paramJceInputStream.read(f, 2, false));
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
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
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != 0) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.b
 * JD-Core Version:    0.7.0.1
 */