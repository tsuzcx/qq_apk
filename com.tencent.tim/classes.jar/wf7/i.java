package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class i
  extends JceStruct
{
  static ArrayList<k> aF = new ArrayList();
  public ArrayList<k> aE = null;
  
  static
  {
    k localk = new k();
    aF.add(localk);
  }
  
  public JceStruct newInit()
  {
    return new i();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aE = ((ArrayList)paramJceInputStream.read(aF, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aE, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.i
 * JD-Core Version:    0.7.0.1
 */