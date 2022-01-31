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
    if (this.o != null) {
      paramJceOutputStream.write(this.o, 0);
    }
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 1);
    }
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 2);
    }
    if (this.r != null) {
      paramJceOutputStream.write(this.r, 3);
    }
    paramJceOutputStream.write(this.s, 5);
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.c
 * JD-Core Version:    0.7.0.1
 */