import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneExternalRequest;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class ardb
  extends QzoneExternalRequest
{
  private String cmd;
  private JceStruct req;
  private String uniKey;
  
  public ardb() {}
  
  public ardb(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2)
  {
    super.setRefer(paramString2);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.req = paramHttpReq;
    this.cmd = paramString1;
    this.needCompress = false;
    this.uniKey = qe(paramString1);
  }
  
  public static HttpRsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (HttpRsp)decode(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("WebSoRequest", 1, "onResponse error:", paramArrayOfByte);
    }
    return null;
  }
  
  public static String qe(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.w("WebSoRequest", 1, "cmd is EMPTY OR NULL !!!");
    }
    do
    {
      return null;
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[(paramString.length - 1)];
  }
  
  public String getCmdString()
  {
    return this.cmd;
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return this.uniKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardb
 * JD-Core Version:    0.7.0.1
 */