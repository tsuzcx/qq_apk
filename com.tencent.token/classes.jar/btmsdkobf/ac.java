package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ac
  extends JceStruct
{
  static ArrayList<z> bl = new ArrayList();
  public long bg = 0L;
  public long bh = 0L;
  public ArrayList<z> bk = null;
  
  static
  {
    z localz = new z();
    bl.add(localz);
  }
  
  public final JceStruct newInit()
  {
    return new ac();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bg = paramJceInputStream.read(this.bg, 0, false);
    this.bh = paramJceInputStream.read(this.bh, 1, false);
    this.bk = ((ArrayList)paramJceInputStream.read(bl, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.bg;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
    l = this.bh;
    if (l != 0L) {
      paramJceOutputStream.write(l, 1);
    }
    ArrayList localArrayList = this.bk;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ac
 * JD-Core Version:    0.7.0.1
 */