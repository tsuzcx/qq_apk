package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ab
  extends JceStruct
{
  public int action = 0;
  public int ba = 0;
  public long bg = 0L;
  public long bh = 0L;
  public int bi = 0;
  public int bj = 0;
  public int cmdId = 0;
  public int phase = 0;
  public int time = 0;
  
  public JceStruct newInit()
  {
    return new ab();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bg = paramJceInputStream.read(this.bg, 0, false);
    this.bh = paramJceInputStream.read(this.bh, 1, false);
    this.action = paramJceInputStream.read(this.action, 2, false);
    this.ba = paramJceInputStream.read(this.ba, 3, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 4, false);
    this.phase = paramJceInputStream.read(this.phase, 5, false);
    this.bi = paramJceInputStream.read(this.bi, 6, false);
    this.bj = paramJceInputStream.read(this.bj, 7, false);
    this.time = paramJceInputStream.read(this.time, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bg != 0L) {
      paramJceOutputStream.write(this.bg, 0);
    }
    if (this.bh != 0L) {
      paramJceOutputStream.write(this.bh, 1);
    }
    paramJceOutputStream.write(this.action, 2);
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 3);
    }
    paramJceOutputStream.write(this.cmdId, 4);
    paramJceOutputStream.write(this.phase, 5);
    paramJceOutputStream.write(this.bi, 6);
    paramJceOutputStream.write(this.bj, 7);
    if (this.time != 0) {
      paramJceOutputStream.write(this.time, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ab
 * JD-Core Version:    0.7.0.1
 */