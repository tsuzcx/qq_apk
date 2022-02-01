package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public int bh = 0;
  public int bi = 0;
  
  public JceStruct newInit()
  {
    return new b();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bh = paramJceInputStream.read(this.bh, 0, false);
    this.bi = paramJceInputStream.read(this.bi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bh != 0) {
      paramJceOutputStream.write(this.bh, 0);
    }
    if (this.bi != 0) {
      paramJceOutputStream.write(this.bi, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Protocol.MConch.b
 * JD-Core Version:    0.7.0.1
 */