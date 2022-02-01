import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class ukb
  implements uyv
{
  ukb(uka paramuka) {}
  
  public void a(String paramString, int paramInt)
  {
    uyc.a(uka.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, umu.a().a(), 0);
    uka.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    ukw.a(uka.a(this.a), paramString);
    uka.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = uvr.b();
    localWSDownloadParams.mScheme = paramString;
    unq.a((Activity)uka.a(this.a), localWSDownloadParams, false);
    uka.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    ukw.a(uka.a(this.a), paramString, new ukc(this.a, this.a));
    uka.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukb
 * JD-Core Version:    0.7.0.1
 */