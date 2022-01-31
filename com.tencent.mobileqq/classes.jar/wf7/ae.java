package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ae
  extends JceStruct
{
  static byte[] cg = (byte[])new byte[1];
  static ad cq = new ad();
  public int bH = 0;
  public int bZ = 0;
  public int ca = 0;
  public int cc = 0;
  public int cd = 0;
  public int cf = 0;
  public ad cp = null;
  public byte[] data = null;
  
  static
  {
    ((byte[])cg)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new ae();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bH = paramJceInputStream.read(this.bH, 0, true);
    this.bZ = paramJceInputStream.read(this.bZ, 1, false);
    this.ca = paramJceInputStream.read(this.ca, 2, false);
    this.cc = paramJceInputStream.read(this.cc, 3, false);
    this.cd = paramJceInputStream.read(this.cd, 4, false);
    this.data = ((byte[])paramJceInputStream.read(cg, 5, false));
    this.cp = ((ad)paramJceInputStream.read(cq, 6, false));
    this.cf = paramJceInputStream.read(this.cf, 7, false);
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
    paramJceOutputStream.write(this.cc, 3);
    if (this.cd != 0) {
      paramJceOutputStream.write(this.cd, 4);
    }
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 5);
    }
    if (this.cp != null) {
      paramJceOutputStream.write(this.cp, 6);
    }
    if (this.cf != 0) {
      paramJceOutputStream.write(this.cf, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ae
 * JD-Core Version:    0.7.0.1
 */