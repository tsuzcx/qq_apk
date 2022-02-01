package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class bb
  extends JceStruct
{
  static ArrayList<ba> dv = new ArrayList();
  public int dc = 0;
  public int dd = 0;
  public ArrayList<ba> du = null;
  
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
    int i = this.dc;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.dd;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    ArrayList localArrayList = this.du;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bb
 * JD-Core Version:    0.7.0.1
 */