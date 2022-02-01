package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class r
  extends JceStruct
{
  static s aA = new s();
  public int ay = 0;
  public s az = null;
  
  public JceStruct newInit()
  {
    return new r();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ay = paramJceInputStream.read(this.ay, 0, true);
    this.az = ((s)paramJceInputStream.read(aA, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ay, 0);
    s locals = this.az;
    if (locals != null) {
      paramJceOutputStream.write(locals, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.r
 * JD-Core Version:    0.7.0.1
 */