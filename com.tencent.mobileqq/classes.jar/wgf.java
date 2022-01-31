import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wgf
  extends bdvm
{
  public wgf(QRDisplayActivity paramQRDisplayActivity) {}
  
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
    paramHashMap = wij.a(paramHashMap, -1);
    if (paramHashMap != null)
    {
      this.a.a = paramHashMap;
      this.a.f();
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wgf
 * JD-Core Version:    0.7.0.1
 */