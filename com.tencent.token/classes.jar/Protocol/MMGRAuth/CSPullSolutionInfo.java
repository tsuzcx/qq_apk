package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSPullSolutionInfo
  extends JceStruct
{
  static ArrayList<Integer> a = new ArrayList();
  public ArrayList<Integer> adapterIdList = null;
  public int pullType = 0;
  
  static
  {
    a.add(Integer.valueOf(0));
  }
  
  public JceStruct newInit()
  {
    return new CSPullSolutionInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pullType = paramJceInputStream.read(this.pullType, 0, false);
    this.adapterIdList = ((ArrayList)paramJceInputStream.read(a, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.pullType;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    ArrayList localArrayList = this.adapterIdList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.CSPullSolutionInfo
 * JD-Core Version:    0.7.0.1
 */