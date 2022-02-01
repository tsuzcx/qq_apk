package taiji;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  public String a = "";
  public int b = 0;
  public String c = "";
  
  public JceStruct newInit()
  {
    return new c();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.a;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.c
 * JD-Core Version:    0.7.0.1
 */