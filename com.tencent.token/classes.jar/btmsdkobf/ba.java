package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ba
  extends JceStruct
{
  static byte[] dj;
  static az dt = new az();
  public int bM = 0;
  public byte[] data = null;
  public int dc = 0;
  public int dd = 0;
  public int df = 0;
  public int dg = 0;
  public int di = 0;
  public az ds = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    dj = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new ba();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bM = paramJceInputStream.read(this.bM, 0, true);
    this.dc = paramJceInputStream.read(this.dc, 1, false);
    this.dd = paramJceInputStream.read(this.dd, 2, false);
    this.df = paramJceInputStream.read(this.df, 3, false);
    this.dg = paramJceInputStream.read(this.dg, 4, false);
    this.data = ((byte[])paramJceInputStream.read(dj, 5, false));
    this.ds = ((az)paramJceInputStream.read(dt, 6, false));
    this.di = paramJceInputStream.read(this.di, 7, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bM, 0);
    int i = this.dc;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.dd;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    paramJceOutputStream.write(this.df, 3);
    i = this.dg;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
    localObject = this.ds;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    i = this.di;
    if (i != 0) {
      paramJceOutputStream.write(i, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ba
 * JD-Core Version:    0.7.0.1
 */