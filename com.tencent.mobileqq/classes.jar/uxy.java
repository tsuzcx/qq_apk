import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class uxy
  implements vnn
{
  uxy(uxx paramuxx) {}
  
  public void a(String paramString, int paramInt)
  {
    vmr.a(uxx.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, vau.a().a(), 0);
    uxx.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    uyt.a(uxx.a(this.a), paramString);
    uxx.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = vkf.b();
    localWSDownloadParams.mScheme = paramString;
    vbq.a((Activity)uxx.a(this.a), localWSDownloadParams, false);
    uxx.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    uyt.a(uxx.a(this.a), paramString, new uxz(this.a, this.a));
    uxx.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxy
 * JD-Core Version:    0.7.0.1
 */