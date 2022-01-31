package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class az
  extends JceStruct
{
  public long db = 0L;
  
  public JceStruct newInit()
  {
    return new az();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.db = paramJceInputStream.read(this.db, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.db != 0L) {
      paramJceOutputStream.write(this.db, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.az
 * JD-Core Version:    0.7.0.1
 */