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
    int i = this.bZ;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.ca;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    long l = this.cb;
    if (l != 0L) {
      paramJceOutputStream.write(l, 4);
    }
    i = this.cc;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.cd;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    localObject = this.ce;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    i = this.cf;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.x
 * JD-Core Version:    0.7.0.1
 */