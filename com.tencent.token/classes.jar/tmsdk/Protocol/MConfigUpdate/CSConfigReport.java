package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSConfigReport
  extends JceStruct
{
  static ArrayList<ConfigReport> bv = new ArrayList();
  public ArrayList<ConfigReport> vecConfigReport = null;
  
  static
  {
    ConfigReport localConfigReport = new ConfigReport();
    bv.add(localConfigReport);
  }
  
  public JceStruct newInit()
  {
    return new CSConfigReport();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecConfigReport = ((ArrayList)paramJceInputStream.read(bv, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecConfigReport != null) {
      paramJceOutputStream.write(this.vecConfigReport, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.CSConfigReport
 * JD-Core Version:    0.7.0.1
 */