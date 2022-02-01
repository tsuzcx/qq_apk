import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.17.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class nxg
  implements ViolaBaseView.a
{
  public nxg(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void bbs() {}
  
  public void oD(String paramString)
  {
    if (this.avs) {
      ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.TIME_BIZ_JS_OFFLINE, Long.toString(System.currentTimeMillis() - this.yn));
    }
    if (QLog.isColorLevel()) {
      ThreadManager.post(new ViolaBaseView.17.1(this, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxg
 * JD-Core Version:    0.7.0.1
 */