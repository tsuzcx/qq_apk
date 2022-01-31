package a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  static a c;
  public a a = null;
  public String b = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (c == null) {
      c = new a();
    }
    this.a = ((a)paramJceInputStream.read(c, 0, true));
    this.b = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.b
 * JD-Core Version:    0.7.0.1
 */