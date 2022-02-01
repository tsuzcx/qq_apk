import NS_MOBILE_OPERATION.operation_like_req;
import com.qq.taf.jce.JceStruct;

public class avtt
  extends avpr
{
  public JceStruct req;
  private int type;
  
  public avtt(Long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    operation_like_req localoperation_like_req = new operation_like_req();
    localoperation_like_req.uin = paramLong.longValue();
    localoperation_like_req.action = paramInt1;
    localoperation_like_req.appid = paramInt2;
    localoperation_like_req.curkey = paramString1;
    localoperation_like_req.unikey = paramString2;
    this.req = localoperation_like_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.like";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String uniKey()
  {
    return "like";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtt
 * JD-Core Version:    0.7.0.1
 */