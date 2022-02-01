package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class n
  extends JceStruct
{
  public int aS = 2;
  public int aW = 0;
  public String aX = "";
  public String aY = "";
  public String aZ = "";
  public int ba = 0;
  public int bb = 0;
  public long bc = 0L;
  public int bd = 0;
  public String be = "";
  
  public JceStruct newInit()
  {
    return new n();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aS = paramJceInputStream.read(this.aS, 0, true);
    this.aW = paramJceInputStream.read(this.aW, 1, true);
    this.aX = paramJceInputStream.readString(2, false);
    this.aY = paramJceInputStream.readString(3, false);
    this.aZ = paramJceInputStream.readString(4, false);
    this.ba = paramJceInputStream.read(this.ba, 5, false);
    this.bb = paramJceInputStream.read(this.bb, 6, false);
    this.bc = paramJceInputStream.read(this.bc, 7, false);
    this.bd = paramJceInputStream.read(this.bd, 8, false);
    this.be = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aS, 0);
    paramJceOutputStream.write(this.aW, 1);
    String str = this.aX;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.aY;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.aZ;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int i = this.ba;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.bb;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    long l = this.bc;
    if (l != 0L) {
      paramJceOutputStream.write(l, 7);
    }
    i = this.bd;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
    str = this.be;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.n
 * JD-Core Version:    0.7.0.1
 */