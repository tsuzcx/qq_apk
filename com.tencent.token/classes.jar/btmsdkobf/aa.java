package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aa
  extends JceStruct
{
  public int ba = 0;
  public long bg = 0L;
  public long bh = 0L;
  public int bi = 0;
  public int cmdId = 0;
  
  public final JceStruct newInit()
  {
    return new aa();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bg = paramJceInputStream.read(this.bg, 0, false);
    this.bh = paramJceInputStream.read(this.bh, 1, false);
    this.ba = paramJceInputStream.read(this.ba, 2, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 3, false);
    this.bi = paramJceInputStream.read(this.bi, 4, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.bg;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
    l = this.bh;
    if (l != 0L) {
      paramJceOutputStream.write(l, 1);
    }
    int i = this.ba;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    paramJceOutputStream.write(this.cmdId, 3);
    i = this.bi;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aa
 * JD-Core Version:    0.7.0.1
 */