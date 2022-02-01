import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.2;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class nxh
  implements ntp.a
{
  public nxh(ViolaBaseView.2 param2, long paramLong) {}
  
  public void bbr()
  {
    if (ViolaBaseView.a(this.a.this$0) != null) {
      ViolaBaseView.a(this.a.this$0).bcd();
    }
    ViolaBaseView.a(this.a.this$0, 1);
    QLog.e(ViolaBaseView.access$700(), 2, "ThreadManager 执行 onViolaSDKError");
  }
  
  public void eU(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ViolaBaseView.access$700(), 2, "ThreadManager 执行 onViolaSDKSucc");
    }
    if (ViolaBaseView.a(this.a.this$0) != null) {
      ViolaBaseView.a(this.a.this$0).bcc();
    }
    if (paramLong != 0L)
    {
      ViolaBaseView.a(this.a.this$0).addReportData(ViolaEnvironment.TIME_SDK_MAIN, Long.toString(paramLong));
      ViolaBaseView.a(this.a.this$0).addReportData(ViolaEnvironment.TIME_SDK_INIT, Long.toString(System.currentTimeMillis() - this.val$startTime));
    }
    ViolaBaseView.a(this.a.this$0, true);
    ViolaBaseView.d(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxh
 * JD-Core Version:    0.7.0.1
 */