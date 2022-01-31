package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class as
  extends JceStruct
{
  static byte[] dj = (byte[])new byte[1];
  static ar dk = new ar();
  public int bM = 0;
  public byte[] data = null;
  public int dc = 0;
  public int dd = 0;
  public long de = 0L;
  public int df = 0;
  public int dg = 0;
  public ar dh = null;
  public int di = 0;
  
  static
  {
    ((byte[])dj)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new as();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bM = paramJceInputStream.read(this.bM, 0, true);
    this.dc = paramJceInputStream.read(this.dc, 1, false);
    this.dd = paramJceInputStream.read(this.dd, 2, false);
    this.data = ((byte[])paramJceInputStream.read(dj, 3, false));
    this.de = paramJceInputStream.read(this.de, 4, false);
    this.df = paramJceInputStream.read(this.df, 5, false);
    this.dg = paramJceInputStream.read(this.dg, 6, false);
    this.dh = ((ar)paramJceInputStream.read(dk, 7, false));
    this.di = paramJceInputStream.read(this.di, 8, false);
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
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 3);
    }
    if (this.de != 0L) {
      paramJceOutputStream.write(this.de, 4);
    }
    if (this.df != 0) {
      paramJceOutputStream.write(this.df, 5);
    }
    if (this.dg != 0) {
      paramJceOutputStream.write(this.dg, 6);
    }
    if (this.dh != null) {
      paramJceOutputStream.write(this.dh, 7);
    }
    if (this.di != 0) {
      paramJceOutputStream.write(this.di, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.as
 * JD-Core Version:    0.7.0.1
 */