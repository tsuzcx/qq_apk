import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class avqo
  extends QzoneExternalRequest
{
  public JceStruct req;
  
  public avqo(long paramLong1, long paramLong2, int paramInt)
  {
    mobile_sub_get_cover_req localmobile_sub_get_cover_req = new mobile_sub_get_cover_req();
    localmobile_sub_get_cover_req.uin = paramLong1;
    localmobile_sub_get_cover_req.flag = paramInt;
    this.req = localmobile_sub_get_cover_req;
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
  }
  
  public static JceStruct c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "getCover");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getCover";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "getCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqo
 * JD-Core Version:    0.7.0.1
 */