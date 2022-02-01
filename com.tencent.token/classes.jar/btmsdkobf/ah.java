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
  
  public final JceStruct newInit()
  {
    return new ah();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bo = ((ArrayList)paramJceInputStream.read(bp, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.bo;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ah
 * JD-Core Version:    0.7.0.1
 */