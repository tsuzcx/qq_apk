package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class y
  extends JceStruct
{
  public int aY = 0;
  public int cmdId = 0;
  
  public final JceStruct newInit()
  {
    return new y();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.aY = paramJceInputStream.read(this.aY, 0, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.aY;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.cmdId;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.y
 * JD-Core Version:    0.7.0.1
 */