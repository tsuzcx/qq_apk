package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSConfInfo
  extends JceStruct
{
  static ArrayList<ClientConfInfo> bu = new ArrayList();
  public int updatetype = 0;
  public ArrayList<ClientConfInfo> vecInfo = null;
  
  static
  {
    ClientConfInfo localClientConfInfo = new ClientConfInfo();
    bu.add(localClientConfInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecInfo = ((ArrayList)paramJceInputStream.read(bu, 0, true));
    this.updatetype = paramJceInputStream.read(this.updatetype, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecInfo, 0);
    if (this.updatetype != 0) {
      paramJceOutputStream.write(this.updatetype, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.CSConfInfo
 * JD-Core Version:    0.7.0.1
 */