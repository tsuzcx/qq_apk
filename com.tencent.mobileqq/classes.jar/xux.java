import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class xux
  extends bfvh
{
  public xux(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "mBusinessObserver onQidianGroupInfo qrcode url: " + paramBoolean);
    }
    if ((this.a.b) || (this.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.g();
      return;
    }
    String str = (String)paramHashMap.get("uin");
    paramHashMap = (String)paramHashMap.get("url");
    this.a.a(str, 2, paramHashMap);
    paramHashMap = xxb.a(paramHashMap, -1);
    if (paramHashMap != null)
    {
      this.a.a = paramHashMap;
      this.a.f();
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xux
 * JD-Core Version:    0.7.0.1
 */