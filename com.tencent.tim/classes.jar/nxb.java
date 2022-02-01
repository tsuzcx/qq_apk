import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class nxb
  implements lci.a
{
  public nxb(ViolaBaseView paramViolaBaseView, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if (this.aJf == ViolaBaseView.access$100())
    {
      ViolaBaseView.a(this.this$0, System.currentTimeMillis());
      ViolaBaseView.c(this.this$0);
    }
    for (;;)
    {
      QLog.e(ViolaBaseView.access$700(), 2, "loadSoIfNeed error,code=" + paramInt + ",isActivityDestroy:" + ViolaBaseView.a(this.this$0));
      return;
      ViolaBaseView.a(this.this$0, 100);
    }
  }
  
  public void onFinish(int paramInt)
  {
    if (paramInt == lci.aNl) {
      ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_EXIT);
    }
    for (;;)
    {
      ViolaBaseView.a(this.this$0);
      ViolaBaseView.b(this.this$0);
      return;
      if (this.aJf == ViolaBaseView.access$100())
      {
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_NET);
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.this$0)));
      }
      else
      {
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_OFFLINE);
        ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxb
 * JD-Core Version:    0.7.0.1
 */