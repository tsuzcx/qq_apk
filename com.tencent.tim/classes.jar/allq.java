import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class allq
  extends QzoneExternalRequest
{
  public JceStruct req;
  
  public allq(long paramLong, operation_red_touch_req paramoperation_red_touch_req)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.req = paramoperation_red_touch_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.asy_photo.OperationRedTouch";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "OperationRedTouch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allq
 * JD-Core Version:    0.7.0.1
 */