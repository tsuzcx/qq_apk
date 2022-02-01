import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class utu
  implements uyv
{
  utu(utr paramutr, Context paramContext, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    uyc.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramString, 1, utr.a(this.jdField_a_of_type_Utr), this.jdField_a_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ukw.a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = utr.a(this.jdField_a_of_type_Utr);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = uvr.b();
    localWSDownloadParams.mScheme = paramString;
    unq.a((Activity)this.jdField_a_of_type_AndroidContentContext, localWSDownloadParams, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      utr.a(this.jdField_a_of_type_Utr, this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utu
 * JD-Core Version:    0.7.0.1
 */