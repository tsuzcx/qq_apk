package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqRegisterProxy
  extends JceStruct
{
  static SvcReqRegister cache_SReq;
  public SvcReqRegister SReq = null;
  public int clientid = 0;
  public int clientip = 0;
  public int clientport = 0;
  public int ssoip = 0;
  public int ssoport = 0;
  
  public SvcReqRegisterProxy() {}
  
  public SvcReqRegisterProxy(SvcReqRegister paramSvcReqRegister, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.SReq = paramSvcReqRegister;
    this.ssoip = paramInt1;
    this.ssoport = paramInt2;
    this.clientip = paramInt3;
    this.clientport = paramInt4;
    this.clientid = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_SReq == null) {
      cache_SReq = new SvcReqRegister();
    }
    this.SReq = ((SvcReqRegister)paramJceInputStream.read(cache_SReq, 1, true));
    this.ssoip = paramJceInputStream.read(this.ssoip, 2, false);
    this.ssoport = paramJceInputStream.read(this.ssoport, 3, false);
    this.clientip = paramJceInputStream.read(this.clientip, 4, false);
    this.clientport = paramJceInputStream.read(this.clientport, 5, false);
    this.clientid = paramJceInputStream.read(this.clientid, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.SReq, 1);
    paramJceOutputStream.write(this.ssoip, 2);
    paramJceOutputStream.write(this.ssoport, 3);
    paramJceOutputStream.write(this.clientip, 4);
    paramJceOutputStream.write(this.clientport, 5);
    paramJceOutputStream.write(this.clientid, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqRegisterProxy
 * JD-Core Version:    0.7.0.1
 */