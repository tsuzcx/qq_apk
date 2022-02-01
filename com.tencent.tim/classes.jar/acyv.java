import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_ICON.lighting_sweet_key_req;
import SWEET_NEW_ICON.lighting_sweet_key_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class acyv
  extends QzoneExternalRequest
{
  private lighting_sweet_key_req a;
  private String uniKey;
  
  public acyv() {}
  
  public acyv(long paramLong)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.a = new lighting_sweet_key_req();
    this.a.req_comm = new sweet_req_comm();
    this.a.req_comm.opuin = paramLong;
    this.a.req_comm.uin = paramLong;
    this.a.req_comm.loveuin = 0L;
    this.a.req_comm.qua = avpq.getQUA3();
    this.a.req_comm.pf = 1;
    this.a.req_comm.src = 3;
    this.uniKey = getUniKey();
  }
  
  public static lighting_sweet_key_rsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (lighting_sweet_key_rsp)decode(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String getUniKey()
  {
    if (TextUtils.isEmpty("SweetQzoneService.lightingSweetKey")) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = "SweetQzoneService.lightingSweetKey".split("\\.");
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    return arrayOfString[(arrayOfString.length - 1)];
  }
  
  public String getCmdString()
  {
    return "SweetQzoneService.lightingSweetKey";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return this.uniKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyv
 * JD-Core Version:    0.7.0.1
 */