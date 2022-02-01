package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class p
  extends JceStruct
  implements Cloneable
{
  static ArrayList<q> bM = new ArrayList();
  public int bK = 0;
  public ArrayList<q> bL = null;
  
  static
  {
    q localq = new q();
    bM.add(localq);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bK = paramJceInputStream.read(this.bK, 0, true);
    this.bL = ((ArrayList)paramJceInputStream.read(bM, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bK, 0);
    paramJceOutputStream.write(this.bL, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.p
 * JD-Core Version:    0.7.0.1
 */