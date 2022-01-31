package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class bb
  extends JceStruct
{
  static ArrayList dv = new ArrayList();
  public int dc = 0;
  public int dd = 0;
  public ArrayList du = null;
  
  static
  {
    ba localba = new ba();
    dv.add(localba);
  }
  
  public JceStruct newInit()
  {
    return new bb();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dc = paramJceInputStream.read(this.dc, 0, false);
    this.dd = paramJceInputStream.read(this.dd, 1, false);
    this.du = ((ArrayList)paramJceInputStream.read(dv, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.dc != 0) {
      paramJceOutputStream.write(this.dc, 0);
    }
    if (this.dd != 0) {
      paramJceOutputStream.write(this.dd, 1);
    }
    if (this.du != null) {
      paramJceOutputStream.write(this.du, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bb
 * JD-Core Version:    0.7.0.1
 */