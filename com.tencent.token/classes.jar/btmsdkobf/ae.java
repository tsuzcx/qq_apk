package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ae
  extends JceStruct
{
  public int bi = 0;
  
  public final JceStruct newInit()
  {
    return new ae();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bi = paramJceInputStream.read(this.bi, 0, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bi;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ae
 * JD-Core Version:    0.7.0.1
 */