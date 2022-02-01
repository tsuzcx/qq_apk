import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

final class oov
  implements ool.a
{
  oov(Activity paramActivity, String paramString1, WSDownloadParams paramWSDownloadParams, String paramString2, int paramInt) {}
  
  public void bfA()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.aqV + this.bfz, 1000001);
    opb.a(this.val$activity, "biz_src_jc_gzh_weishi", this.val$scheme, this.b.mScene, this.b.mLinkStrategyType, this.b.mEventId);
  }
  
  public void bfB()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.aqV + this.bfz, 1000005);
  }
  
  public void bfy()
  {
    opb.a(this.val$activity, "biz_src_jc_gzh_weishi", this.val$scheme, this.b.mScene, this.b.mLinkStrategyType, this.b.mEventId);
  }
  
  public void bfz()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", "dynamics_" + this.aqV + this.bfz, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oov
 * JD-Core Version:    0.7.0.1
 */