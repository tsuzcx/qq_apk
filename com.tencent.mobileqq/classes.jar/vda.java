import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class vda
  implements vnn
{
  vda(vcu paramvcu) {}
  
  public void a(String paramString, int paramInt)
  {
    vmr.a(vcu.a(this.a), "biz_src_jc_gzh_weishi", paramString);
    vcu.a(this.a, "content", vkh.c);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 700;
    localWSDownloadParams.mTestId = vnd.a(9);
    localWSDownloadParams.mScheme = paramString;
    vbq.a((Activity)vcu.b(this.a), localWSDownloadParams, false);
    vcu.a(this.a, "content", vkh.b);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vda
 * JD-Core Version:    0.7.0.1
 */