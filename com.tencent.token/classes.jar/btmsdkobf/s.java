package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s
  extends JceStruct
{
  public long aB = 0L;
  public long aC = 0L;
  
  public final JceStruct newInit()
  {
    return new s();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.aB = paramJceInputStream.read(this.aB, 0, false);
    this.aC = paramJceInputStream.read(this.aC, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.aB;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
    l = this.aC;
    if (l != 0L) {
      paramJceOutputStream.write(l, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.s
 * JD-Core Version:    0.7.0.1
 */