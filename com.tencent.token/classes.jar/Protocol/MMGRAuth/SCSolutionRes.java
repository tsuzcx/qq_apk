package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCSolutionRes
  extends JceStruct
{
  static ArrayList<SolutionItem> a = new ArrayList();
  static ArrayList<SolutionItem> b;
  public ArrayList<SolutionItem> canceledSolutionList = null;
  public int ret = 0;
  public ArrayList<SolutionItem> solutionList = null;
  
  static
  {
    SolutionItem localSolutionItem = new SolutionItem();
    a.add(localSolutionItem);
    b = new ArrayList();
    localSolutionItem = new SolutionItem();
    b.add(localSolutionItem);
  }
  
  public JceStruct newInit()
  {
    return new SCSolutionRes();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.solutionList = ((ArrayList)paramJceInputStream.read(a, 1, false));
    this.canceledSolutionList = ((ArrayList)paramJceInputStream.read(b, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    ArrayList localArrayList = this.solutionList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.canceledSolutionList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.SCSolutionRes
 * JD-Core Version:    0.7.0.1
 */