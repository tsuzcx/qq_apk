package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class y
  extends JceStruct
{
  public int aY = 0;
  public int cmdId = 0;
  
  public JceStruct newInit()
  {
    return new y();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aY = paramJceInputStream.read(this.aY, 0, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.aY != 0) {
      paramJceOutputStream.write(this.aY, 0);
    }
    if (this.cmdId != 0) {
      paramJceOutputStream.write(this.cmdId, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.y
 * JD-Core Version:    0.7.0.1
 */