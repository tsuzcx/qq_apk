package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class x
  extends JceStruct
{
  static ArrayList<ab> aX = new ArrayList();
  public ArrayList<ab> aW = null;
  
  static
  {
    ab localab = new ab();
    aX.add(localab);
  }
  
  public JceStruct newInit()
  {
    return new x();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aW = ((ArrayList)paramJceInputStream.read(aX, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.aW;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.x
 * JD-Core Version:    0.7.0.1
 */