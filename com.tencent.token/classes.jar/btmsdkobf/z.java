package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class z
  extends JceStruct
{
  static byte[] bd = (byte[])new byte[1];
  static ai be = new ai();
  static aj bf = new aj();
  public byte[] aZ = null;
  public int ba = 0;
  public ai bb = null;
  public aj bc = null;
  public int cmdId = 0;
  
  static
  {
    ((byte[])bd)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new z();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmdId = paramJceInputStream.read(this.cmdId, 0, false);
    this.aZ = ((byte[])paramJceInputStream.read(bd, 1, false));
    this.ba = paramJceInputStream.read(this.ba, 2, false);
    this.bb = ((ai)paramJceInputStream.read(be, 3, false));
    this.bc = ((aj)paramJceInputStream.read(bf, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmdId, 0);
    if (this.aZ != null) {
      paramJceOutputStream.write(this.aZ, 1);
    }
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 2);
    }
    if (this.bb != null) {
      paramJceOutputStream.write(this.bb, 3);
    }
    if (this.bc != null) {
      paramJceOutputStream.write(this.bc, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.z
 * JD-Core Version:    0.7.0.1
 */