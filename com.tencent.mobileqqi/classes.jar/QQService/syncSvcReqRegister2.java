package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class syncSvcReqRegister2
  extends JceStruct
{
  static SvcReqRegister2 cache_reqRegister;
  static SSOInfo cache_ssoInfo;
  public SvcReqRegister2 reqRegister = null;
  public SSOInfo ssoInfo = null;
  
  public syncSvcReqRegister2() {}
  
  public syncSvcReqRegister2(SSOInfo paramSSOInfo, SvcReqRegister2 paramSvcReqRegister2)
  {
    this.ssoInfo = paramSSOInfo;
    this.reqRegister = paramSvcReqRegister2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_ssoInfo == null) {
      cache_ssoInfo = new SSOInfo();
    }
    this.ssoInfo = ((SSOInfo)paramJceInputStream.read(cache_ssoInfo, 0, true));
    if (cache_reqRegister == null) {
      cache_reqRegister = new SvcReqRegister2();
    }
    this.reqRegister = ((SvcReqRegister2)paramJceInputStream.read(cache_reqRegister, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ssoInfo, 0);
    paramJceOutputStream.write(this.reqRegister, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.syncSvcReqRegister2
 * JD-Core Version:    0.7.0.1
 */