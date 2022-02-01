package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ActivityCmdInfo
  extends JceStruct
{
  static ArrayList<CloudInfo> dx;
  public ArrayList<CloudInfo> cloudinfos = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dx == null)
    {
      dx = new ArrayList();
      CloudInfo localCloudInfo = new CloudInfo();
      dx.add(localCloudInfo);
    }
    this.cloudinfos = ((ArrayList)paramJceInputStream.read(dx, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cloudinfos, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ActivityCmdInfo
 * JD-Core Version:    0.7.0.1
 */