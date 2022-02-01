package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class x
  extends JceStruct
{
  static byte[] cg = (byte[])new byte[1];
  static w ch = new w();
  public int bH = 0;
  public int bZ = 0;
  public int ca = 0;
  public long cb = 0L;
  public int cc = 0;
  public int cd = 0;
  public w ce = null;
  public int cf = 0;
  public byte[] data = null;
  
  static
  {
    ((byte[])cg)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new x();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bH = paramJceInputStream.read(this.bH, 0, true);
    this.bZ = paramJceInputStream.read(this.bZ, 1, false);
    this.ca = paramJceInputStream.read(this.ca, 2, false);
    this.data = ((byte[])paramJceInputStream.read(cg, 3, false));
    this.cb = paramJceInputStream.read(this.cb, 4, false);
    this.cc = paramJceInputStream.read(this.cc, 5, false);
    this.cd = paramJceInputStream.read(this.cd, 6, false);
    this.ce = ((w)paramJceInputStream.read(ch, 7, false));
    this.cf = paramJceInputStream.read(this.cf, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bH, 0);
    if (this.bZ != 0) {
      paramJceOutputStream.write(this.bZ, 1);
    }
    if (this.ca != 0) {
      paramJceOutputStream.write(this.ca, 2);
    }
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 3);
    }
    if (this.cb != 0L) {
      paramJceOutputStream.write(this.cb, 4);
    }
    if (this.cc != 0) {
      paramJceOutputStream.write(this.cc, 5);
    }
    if (this.cd != 0) {
      paramJceOutputStream.write(this.cd, 6);
    }
    if (this.ce != null) {
      paramJceOutputStream.write(this.ce, 7);
    }
    if (this.cf != 0) {
      paramJceOutputStream.write(this.cf, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.x
 * JD-Core Version:    0.7.0.1
 */