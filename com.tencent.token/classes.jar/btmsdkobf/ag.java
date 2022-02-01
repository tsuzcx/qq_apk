package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ag
  extends JceStruct
{
  static ArrayList<ac> bp = new ArrayList();
  public int bi = 0;
  public ArrayList<ac> bo = null;
  
  static
  {
    ac localac = new ac();
    bp.add(localac);
  }
  
  public JceStruct newInit()
  {
    return new ag();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bi = paramJceInputStream.read(this.bi, 0, false);
    this.bo = ((ArrayList)paramJceInputStream.read(bp, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bi != 0) {
      paramJceOutputStream.write(this.bi, 0);
    }
    if (this.bo != null) {
      paramJceOutputStream.write(this.bo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ag
 * JD-Core Version:    0.7.0.1
 */