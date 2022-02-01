import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class avpv
  extends QzoneExternalRequest
{
  public JceStruct req;
  
  public avpv(long paramLong1, long paramLong2, String paramString)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
    mobile_sub_get_photo_wall_req localmobile_sub_get_photo_wall_req = new mobile_sub_get_photo_wall_req();
    localmobile_sub_get_photo_wall_req.uin = paramLong1;
    localmobile_sub_get_photo_wall_req.attachInfo = paramString;
    this.req = localmobile_sub_get_photo_wall_req;
  }
  
  public static JceStruct b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "getPhotoWall");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getPhotoWall";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "getPhotoWall";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpv
 * JD-Core Version:    0.7.0.1
 */