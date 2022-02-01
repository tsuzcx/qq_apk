package CommonClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stReqHeader
  extends JceStruct
{
  static stReqComm cache_reqComm;
  public stReqComm reqComm = null;
  public String sApply = "";
  public String sCmd = "";
  
  public stReqHeader() {}
  
  public stReqHeader(stReqComm paramstReqComm, String paramString1, String paramString2)
  {
    this.reqComm = paramstReqComm;
    this.sApply = paramString1;
    this.sCmd = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_reqComm == null) {
      cache_reqComm = new stReqComm();
    }
    this.reqComm = ((stReqComm)paramJceInputStream.read(cache_reqComm, 0, true));
    this.sApply = paramJceInputStream.readString(1, true);
    this.sCmd = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqComm, 0);
    paramJceOutputStream.write(this.sApply, 1);
    paramJceOutputStream.write(this.sCmd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     CommonClientInterface.stReqHeader
 * JD-Core Version:    0.7.0.1
 */