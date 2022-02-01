import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class udj
  implements upz
{
  udj(udi paramudi) {}
  
  public void a(String paramString, int paramInt)
  {
    upg.a(udi.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, ugb.a().a(), 0);
    udi.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    uee.a(udi.a(this.a), paramString);
    udi.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = umw.b();
    localWSDownloadParams.mScheme = paramString;
    ugx.a((Activity)udi.a(this.a), localWSDownloadParams, false);
    udi.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    uee.a(udi.a(this.a), paramString, new udk(this));
    udi.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udj
 * JD-Core Version:    0.7.0.1
 */