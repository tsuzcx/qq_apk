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
  
  public JceStruct newInit()
  {
    return new t();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aD = paramJceInputStream.read(this.aD, 0, false);
    this.aE = paramJceInputStream.read(this.aE, 1, false);
    this.aF = paramJceInputStream.read(this.aF, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.aD != 0) {
      paramJceOutputStream.write(this.aD, 0);
    }
    if (this.aE != 0) {
      paramJceOutputStream.write(this.aE, 1);
    }
    if (this.aF != 0) {
      paramJceOutputStream.write(this.aF, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.t
 * JD-Core Version:    0.7.0.1
 */