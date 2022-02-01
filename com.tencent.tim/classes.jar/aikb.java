import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import QMF_PROTOCAL.RetryInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class aikb
  extends QzoneExternalRequest
{
  private JceStruct req;
  
  public aikb(String paramString)
  {
    mobile_get_urlinfo_req localmobile_get_urlinfo_req = new mobile_get_urlinfo_req();
    localmobile_get_urlinfo_req.url = paramString;
    this.req = localmobile_get_urlinfo_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getUrlInfo";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public Object getRetryInfo()
  {
    return new RetryInfo((short)0, 0, System.currentTimeMillis());
  }
  
  public String uniKey()
  {
    return "getUrlInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikb
 * JD-Core Version:    0.7.0.1
 */