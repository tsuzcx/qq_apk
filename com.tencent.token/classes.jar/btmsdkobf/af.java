package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class af
  extends JceStruct
{
  public int bi = 0;
  
  public JceStruct newInit()
  {
    return new af();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bi = paramJceInputStream.read(this.bi, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bi;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.af
 * JD-Core Version:    0.7.0.1
 */