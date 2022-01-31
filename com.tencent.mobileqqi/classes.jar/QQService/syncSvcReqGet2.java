package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class syncSvcReqGet2
  extends JceStruct
{
  static SvcReqGet cache_reqGet;
  static SSOInfo cache_ssoInfo;
  public SvcReqGet reqGet = null;
  public SSOInfo ssoInfo = null;
  
  public syncSvcReqGet2() {}
  
  public syncSvcReqGet2(SSOInfo paramSSOInfo, SvcReqGet paramSvcReqGet)
  {
    this.ssoInfo = paramSSOInfo;
    this.reqGet = paramSvcReqGet;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_ssoInfo == null) {
      cache_ssoInfo = new SSOInfo();
    }
    this.ssoInfo = ((SSOInfo)paramJceInputStream.read(cache_ssoInfo, 0, true));
    if (cache_reqGet == null) {
      cache_reqGet = new SvcReqGet();
    }
    this.reqGet = ((SvcReqGet)paramJceInputStream.read(cache_reqGet, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ssoInfo, 0);
    paramJceOutputStream.write(this.reqGet, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.syncSvcReqGet2
 * JD-Core Version:    0.7.0.1
 */