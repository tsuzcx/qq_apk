package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public boolean s = false;
  public String t = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.o = paramJceInputStream.readString(0, false);
    this.p = paramJceInputStream.readString(1, false);
    this.q = paramJceInputStream.readString(2, false);
    this.r = paramJceInputStream.readString(3, false);
    this.s = paramJceInputStream.read(this.s, 5, false);
    this.t = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.o;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.p;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.q;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.r;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.s, 5);
    str = this.t;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.c
 * JD-Core Version:    0.7.0.1
 */