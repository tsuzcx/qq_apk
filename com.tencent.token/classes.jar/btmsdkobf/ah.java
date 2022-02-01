package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ah
  extends JceStruct
{
  static ArrayList<ac> bp = new ArrayList();
  public ArrayList<ac> bo = null;
  
  static
  {
    ac localac = new ac();
    bp.add(localac);
  }
  
  public JceStruct newInit()
  {
    return new ah();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bo = ((ArrayList)paramJceInputStream.read(bp, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bo != null) {
      paramJceOutputStream.write(this.bo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ah
 * JD-Core Version:    0.7.0.1
 */