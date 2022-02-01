package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class fv
  extends JceStruct
{
  static ArrayList<fu> rG = new ArrayList();
  public ArrayList<fu> rF = null;
  
  static
  {
    fu localfu = new fu();
    rG.add(localfu);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rF = ((ArrayList)paramJceInputStream.read(rG, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rF != null) {
      paramJceOutputStream.write(this.rF, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fv
 * JD-Core Version:    0.7.0.1
 */