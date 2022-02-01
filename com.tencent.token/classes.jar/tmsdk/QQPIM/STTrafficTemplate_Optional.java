package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class STTrafficTemplate_Optional
  extends JceStruct
{
  static ArrayList<STMatchRule_Optional> eQ;
  public ArrayList<STMatchRule_Optional> matchRules_optional = null;
  
  public STTrafficTemplate_Optional() {}
  
  public STTrafficTemplate_Optional(ArrayList<STMatchRule_Optional> paramArrayList)
  {
    this.matchRules_optional = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (eQ == null)
    {
      eQ = new ArrayList();
      STMatchRule_Optional localSTMatchRule_Optional = new STMatchRule_Optional();
      eQ.add(localSTMatchRule_Optional);
    }
    this.matchRules_optional = ((ArrayList)paramJceInputStream.read(eQ, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.matchRules_optional != null) {
      paramJceOutputStream.write(this.matchRules_optional, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STTrafficTemplate_Optional
 * JD-Core Version:    0.7.0.1
 */