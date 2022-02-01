package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class af
  extends JceStruct
{
  static ArrayList<ae> cs = new ArrayList();
  public int bZ = 0;
  public int ca = 0;
  public ArrayList<ae> cr = null;
  
  static
  {
    ae localae = new ae();
    cs.add(localae);
  }
  
  public JceStruct newInit()
  {
    return new af();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bZ = paramJceInputStream.read(this.bZ, 0, false);
    this.ca = paramJceInputStream.read(this.ca, 1, false);
    this.cr = ((ArrayList)paramJceInputStream.read(cs, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bZ != 0) {
      paramJceOutputStream.write(this.bZ, 0);
    }
    if (this.ca != 0) {
      paramJceOutputStream.write(this.ca, 1);
    }
    if (this.cr != null) {
      paramJceOutputStream.write(this.cr, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.af
 * JD-Core Version:    0.7.0.1
 */