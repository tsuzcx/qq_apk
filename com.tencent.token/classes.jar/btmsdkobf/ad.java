package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ad
  extends JceStruct
{
  static ArrayList bn = new ArrayList();
  public ArrayList bm = null;
  
  static
  {
    bn.add("");
  }
  
  public JceStruct newInit()
  {
    return new ad();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bm = ((ArrayList)paramJceInputStream.read(bn, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bm != null) {
      paramJceOutputStream.write(this.bm, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ad
 * JD-Core Version:    0.7.0.1
 */