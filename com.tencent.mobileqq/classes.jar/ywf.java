import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ywf
  extends binf
{
  public ywf(QRDisplayActivity paramQRDisplayActivity) {}
  
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
      this.a.i();
      return;
    }
    String str = (String)paramHashMap.get("uin");
    paramHashMap = (String)paramHashMap.get("url");
    this.a.a(str, 2, paramHashMap);
    paramHashMap = yyi.a(paramHashMap, -1);
    if (paramHashMap != null)
    {
      this.a.a = paramHashMap;
      this.a.h();
      return;
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywf
 * JD-Core Version:    0.7.0.1
 */