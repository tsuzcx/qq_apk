package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSUpdateVirusInfos
  extends JceStruct
{
  static VirusClientInfo dK = new VirusClientInfo();
  public VirusClientInfo clientinfo = null;
  
  public JceStruct newInit()
  {
    return new CSUpdateVirusInfos();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.clientinfo = ((VirusClientInfo)paramJceInputStream.read(dK, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.clientinfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CSUpdateVirusInfos
 * JD-Core Version:    0.7.0.1
 */