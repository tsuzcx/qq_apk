package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetChangeFlagRsp
  extends JceStruct
{
  public int changeFlag = 0;
  public int curChangeVersion = 0;
  
  public stGetChangeFlagRsp() {}
  
  public stGetChangeFlagRsp(int paramInt1, int paramInt2)
  {
    this.changeFlag = paramInt1;
    this.curChangeVersion = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.changeFlag = paramJceInputStream.read(this.changeFlag, 0, true);
    this.curChangeVersion = paramJceInputStream.read(this.curChangeVersion, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.changeFlag, 0);
    paramJceOutputStream.write(this.curChangeVersion, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     WMDBClientInterface.stGetChangeFlagRsp
 * JD-Core Version:    0.7.0.1
 */