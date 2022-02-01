package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class au
  extends JceStruct
{
  public String cX = "";
  
  public final JceStruct newInit()
  {
    return new au();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.cX = paramJceInputStream.readString(0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cX, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.au
 * JD-Core Version:    0.7.0.1
 */