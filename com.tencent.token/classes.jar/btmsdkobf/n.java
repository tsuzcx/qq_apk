package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class n
  extends JceStruct
{
  static ArrayList<o> ap;
  static p aq;
  public ArrayList<o> an = null;
  public p ao = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (ap == null)
    {
      ap = new ArrayList();
      o localo = new o();
      ap.add(localo);
    }
    this.an = ((ArrayList)paramJceInputStream.read(ap, 0, true));
    if (aq == null) {
      aq = new p();
    }
    this.ao = ((p)paramJceInputStream.read(aq, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.an, 0);
    p localp = this.ao;
    if (localp != null) {
      paramJceOutputStream.write(localp, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.n
 * JD-Core Version:    0.7.0.1
 */