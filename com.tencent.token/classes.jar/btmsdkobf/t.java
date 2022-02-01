package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class t
  extends JceStruct
{
  public int aD = 0;
  public int aE = 0;
  public int aF = 0;
  
  public final JceStruct newInit()
  {
    return new t();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.aD = paramJceInputStream.read(this.aD, 0, false);
    this.aE = paramJceInputStream.read(this.aE, 1, false);
    this.aF = paramJceInputStream.read(this.aF, 2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.aD;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.aE;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.aF;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.t
 * JD-Core Version:    0.7.0.1
 */