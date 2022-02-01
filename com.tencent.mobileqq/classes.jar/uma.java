import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class uma
  implements ura
{
  uma(ulx paramulx, Context paramContext, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    uqh.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramString, 1, ulx.a(this.jdField_a_of_type_Ulx), this.jdField_a_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ueg.a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = ulx.a(this.jdField_a_of_type_Ulx);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = unx.b();
    localWSDownloadParams.mScheme = paramString;
    ugz.a((Activity)this.jdField_a_of_type_AndroidContentContext, localWSDownloadParams, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ulx.a(this.jdField_a_of_type_Ulx, this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uma
 * JD-Core Version:    0.7.0.1
 */