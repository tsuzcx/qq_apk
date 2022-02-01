import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class ofr
  implements opn.a
{
  ofr(ofq paramofq) {}
  
  public void aU(String paramString, int paramInt)
  {
    opb.a(ofq.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, ohy.a().rp(), 0);
    ofq.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void aV(String paramString, int paramInt)
  {
    ogj.aM(ofq.a(this.a), paramString);
    ofq.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void aW(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = ong.lD();
    localWSDownloadParams.mScheme = paramString;
    oir.a((Activity)ofq.a(this.a), localWSDownloadParams, false);
    ofq.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void aX(String paramString, int paramInt)
  {
    ogj.a(ofq.a(this.a), paramString, new ofs(this));
    ofq.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofr
 * JD-Core Version:    0.7.0.1
 */