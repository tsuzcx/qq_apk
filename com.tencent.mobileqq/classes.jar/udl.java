import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class udl
  implements ura
{
  udl(udk paramudk) {}
  
  public void a(String paramString, int paramInt)
  {
    uqh.a(udk.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, ugd.a().a(), 0);
    udk.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    ueg.a(udk.a(this.a), paramString);
    udk.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = unx.b();
    localWSDownloadParams.mScheme = paramString;
    ugz.a((Activity)udk.a(this.a), localWSDownloadParams, false);
    udk.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    ueg.a(udk.a(this.a), paramString, new udm(this));
    udk.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udl
 * JD-Core Version:    0.7.0.1
 */