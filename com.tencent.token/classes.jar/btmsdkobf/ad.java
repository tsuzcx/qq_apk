package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ad
  extends JceStruct
{
  static ArrayList<String> bn = new ArrayList();
  public ArrayList<String> bm = null;
  
  static
  {
    bn.add("");
  }
  
  public final JceStruct newInit()
  {
    return new ad();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.bm = ((ArrayList)paramJceInputStream.read(bn, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.bm;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ad
 * JD-Core Version:    0.7.0.1
 */