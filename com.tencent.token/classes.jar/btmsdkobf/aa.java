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
  
  public JceStruct newInit()
  {
    return new aa();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bg = paramJceInputStream.read(this.bg, 0, false);
    this.bh = paramJceInputStream.read(this.bh, 1, false);
    this.ba = paramJceInputStream.read(this.ba, 2, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 3, false);
    this.bi = paramJceInputStream.read(this.bi, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bg != 0L) {
      paramJceOutputStream.write(this.bg, 0);
    }
    if (this.bh != 0L) {
      paramJceOutputStream.write(this.bh, 1);
    }
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 2);
    }
    paramJceOutputStream.write(this.cmdId, 3);
    if (this.bi != 0) {
      paramJceOutputStream.write(this.bi, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aa
 * JD-Core Version:    0.7.0.1
 */