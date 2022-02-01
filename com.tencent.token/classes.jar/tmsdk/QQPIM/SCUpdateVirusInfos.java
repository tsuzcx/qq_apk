package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCUpdateVirusInfos
  extends JceStruct
{
  static VirusServerInfo eI = new VirusServerInfo();
  static ArrayList<VirusInfo> eJ = new ArrayList();
  public VirusServerInfo serverinfo = null;
  public ArrayList<VirusInfo> virusinfos = null;
  
  static
  {
    VirusInfo localVirusInfo = new VirusInfo();
    eJ.add(localVirusInfo);
  }
  
  public JceStruct newInit()
  {
    return new SCUpdateVirusInfos();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.serverinfo = ((VirusServerInfo)paramJceInputStream.read(eI, 0, true));
    this.virusinfos = ((ArrayList)paramJceInputStream.read(eJ, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.serverinfo, 0);
    paramJceOutputStream.write(this.virusinfos, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SCUpdateVirusInfos
 * JD-Core Version:    0.7.0.1
 */