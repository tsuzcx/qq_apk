import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ruy
  extends ashx
{
  public ruy(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "mBusinessObserver onQidianGroupInfo qrcode url: " + paramBoolean);
    }
    if ((this.this$0.isTimeout) || (this.this$0.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.this$0.bwE();
      return;
    }
    String str = (String)paramHashMap.get("uin");
    paramHashMap = (String)paramHashMap.get("url");
    this.this$0.u(str, 2, paramHashMap);
    paramHashMap = rwt.a(paramHashMap, -1);
    if (paramHashMap != null)
    {
      this.this$0.a = paramHashMap;
      this.this$0.bwD();
      return;
    }
    this.this$0.bwE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruy
 * JD-Core Version:    0.7.0.1
 */