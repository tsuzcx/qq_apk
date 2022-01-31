package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SoftReportInfo
  extends JceStruct
{
  static SoftKey dw;
  public SoftKey softkey = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dw == null) {
      dw = new SoftKey();
    }
    this.softkey = ((SoftKey)paramJceInputStream.read(dw, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftReportInfo
 * JD-Core Version:    0.7.0.1
 */