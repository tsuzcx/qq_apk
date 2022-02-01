import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class uif
  implements ura
{
  uif(uhz paramuhz) {}
  
  public void a(String paramString, int paramInt)
  {
    uqh.a(uhz.a(this.a), "biz_src_jc_gzh_weishi", paramString);
    uhz.a(this.a, "content", unz.c);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 700;
    localWSDownloadParams.mTestId = uqt.a(9);
    localWSDownloadParams.mScheme = paramString;
    ugz.a((Activity)uhz.b(this.a), localWSDownloadParams, false);
    uhz.a(this.a, "content", unz.b);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */