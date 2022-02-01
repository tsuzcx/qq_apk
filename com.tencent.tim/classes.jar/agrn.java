import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.ReqBody;

public class agrn
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, agrn.a parama)
  {
    if (paramLong < 0L) {
      return;
    }
    oidb_0x6e7.ReqBody localReqBody = new oidb_0x6e7.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    localReqBody.str_app_src.set("android");
    localReqBody.str_version.set("3.4.4");
    jnm.b(paramQQAppInterface, new agro(parama), localReqBody.toByteArray(), "OidbSvc.oidb_0x6e7", 1767, 0, null);
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return "http://" + paramString1 + "/ftn_handler/" + paramString2 + "/?fname=" + aqhs.String2HexString(paramString3) + paramString5;
  }
  
  public static abstract interface a
  {
    public abstract void bD(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrn
 * JD-Core Version:    0.7.0.1
 */