package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ActivityReqInfo
  extends JceStruct
{
  static TipsReqInfo dy;
  public int notifyID = 0;
  public TipsReqInfo reqinfo = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dy == null) {
      dy = new TipsReqInfo();
    }
    this.reqinfo = ((TipsReqInfo)paramJceInputStream.read(dy, 0, false));
    this.notifyID = paramJceInputStream.read(this.notifyID, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reqinfo != null) {
      paramJceOutputStream.write(this.reqinfo, 0);
    }
    paramJceOutputStream.write(this.notifyID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ActivityReqInfo
 * JD-Core Version:    0.7.0.1
 */