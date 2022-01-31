package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s
  extends JceStruct
{
  public long aB = 0L;
  public long aC = 0L;
  
  public JceStruct newInit()
  {
    return new s();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aB = paramJceInputStream.read(this.aB, 0, false);
    this.aC = paramJceInputStream.read(this.aC, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.aB != 0L) {
      paramJceOutputStream.write(this.aB, 0);
    }
    if (this.aC != 0L) {
      paramJceOutputStream.write(this.aC, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.s
 * JD-Core Version:    0.7.0.1
 */