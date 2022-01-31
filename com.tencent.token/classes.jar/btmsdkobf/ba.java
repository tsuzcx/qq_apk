package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ba
  extends JceStruct
{
  static byte[] dj = (byte[])new byte[1];
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
    ((byte[])dj)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new ba();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
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
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bM, 0);
    if (this.dc != 0) {
      paramJceOutputStream.write(this.dc, 1);
    }
    if (this.dd != 0) {
      paramJceOutputStream.write(this.dd, 2);
    }
    paramJceOutputStream.write(this.df, 3);
    if (this.dg != 0) {
      paramJceOutputStream.write(this.dg, 4);
    }
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 5);
    }
    if (this.ds != null) {
      paramJceOutputStream.write(this.ds, 6);
    }
    if (this.di != 0) {
      paramJceOutputStream.write(this.di, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ba
 * JD-Core Version:    0.7.0.1
 */