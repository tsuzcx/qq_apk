package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class w
  extends JceStruct
{
  static ArrayList<aa> aX = new ArrayList();
  public ArrayList<aa> aW = null;
  
  static
  {
    aa localaa = new aa();
    aX.add(localaa);
  }
  
  public final JceStruct newInit()
  {
    return new w();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.aW = ((ArrayList)paramJceInputStream.read(aX, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.aW;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.w
 * JD-Core Version:    0.7.0.1
 */