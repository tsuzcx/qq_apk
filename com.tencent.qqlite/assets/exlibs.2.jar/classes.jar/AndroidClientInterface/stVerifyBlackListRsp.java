package AndroidClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVerifyBlackListRsp
  extends JceStruct
{
  public int iValue = 0;
  
  public stVerifyBlackListRsp() {}
  
  public stVerifyBlackListRsp(int paramInt)
  {
    this.iValue = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iValue = paramJceInputStream.read(this.iValue, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iValue, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     AndroidClientInterface.stVerifyBlackListRsp
 * JD-Core Version:    0.7.0.1
 */