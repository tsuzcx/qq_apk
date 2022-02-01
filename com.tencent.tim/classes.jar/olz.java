import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class olz
  implements opn.a
{
  olz(olw paramolw, Context paramContext, int paramInt) {}
  
  public void aU(String paramString, int paramInt)
  {
    opb.a(this.val$mContext, "biz_src_jc_gzh_weishi", paramString, 1, olw.a(this.a), this.Tt);
  }
  
  public void aV(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ogj.aM(this.val$mContext, paramString);
    }
  }
  
  public void aW(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = olw.a(this.a);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = ong.lD();
    localWSDownloadParams.mScheme = paramString;
    oir.a((Activity)this.val$mContext, localWSDownloadParams, false);
  }
  
  public void aX(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      olw.a(this.a, this.val$mContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olz
 * JD-Core Version:    0.7.0.1
 */