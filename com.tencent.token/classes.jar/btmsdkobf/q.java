package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class q
  extends JceStruct
{
  public int ay = 0;
  
  public JceStruct newInit()
  {
    return new q();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ay = paramJceInputStream.read(this.ay, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ay, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.q
 * JD-Core Version:    0.7.0.1
 */