import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class arbm
  implements joy
{
  public arbm(SwiftBrowserOfflineHandler.1 param1, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    this.a.this$0.cj.set(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid has checked, bid " + this.a.this$0.businessId + ", loadMode: " + this.a.this$0.cj.get() + ", cost: " + (System.currentTimeMillis() - this.val$startTime));
    }
    if (paramInt != 0)
    {
      stw.tL(this.a.this$0.businessId);
      sud.tM(this.a.val$url);
    }
    this.a.this$0.egY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */