package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ae
  extends JceStruct
{
  public int bi = 0;
  
  public JceStruct newInit()
  {
    return new ae();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bi = paramJceInputStream.read(this.bi, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bi != 0) {
      paramJceOutputStream.write(this.bi, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ae
 * JD-Core Version:    0.7.0.1
 */