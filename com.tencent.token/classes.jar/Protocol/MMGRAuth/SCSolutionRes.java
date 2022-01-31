package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCSolutionRes
  extends JceStruct
{
  static ArrayList a = new ArrayList();
  static ArrayList b;
  public ArrayList canceledSolutionList = null;
  public int ret = 0;
  public ArrayList solutionList = null;
  
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
    if (this.solutionList != null) {
      paramJceOutputStream.write(this.solutionList, 1);
    }
    if (this.canceledSolutionList != null) {
      paramJceOutputStream.write(this.canceledSolutionList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.SCSolutionRes
 * JD-Core Version:    0.7.0.1
 */