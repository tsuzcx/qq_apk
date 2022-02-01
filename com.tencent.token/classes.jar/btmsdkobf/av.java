package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class av
  extends JceStruct
{
  public int dq = 0;
  
  public final JceStruct newInit()
  {
    return new av();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.dq = paramJceInputStream.read(this.dq, 0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.av
 * JD-Core Version:    0.7.0.1
 */