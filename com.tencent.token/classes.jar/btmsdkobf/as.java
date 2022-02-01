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
    int i = this.dc;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.dd;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 3);
    }
    long l = this.de;
    if (l != 0L) {
      paramJceOutputStream.write(l, 4);
    }
    i = this.df;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.dg;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
    localObject = this.dh;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    i = this.di;
    if (i != 0) {
      paramJceOutputStream.write(i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.as
 * JD-Core Version:    0.7.0.1
 */