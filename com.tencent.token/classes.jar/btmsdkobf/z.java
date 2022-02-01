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
    Object localObject = this.aZ;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
    int i = this.ba;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    localObject = this.bb;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.bc;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.z
 * JD-Core Version:    0.7.0.1
 */