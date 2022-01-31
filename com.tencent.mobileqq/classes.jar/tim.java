import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class tim
  implements tmc
{
  tim(tij paramtij, Context paramContext, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    tlq.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramString, 1, tij.a(this.jdField_a_of_type_Tij), this.jdField_a_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      tch.a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = tij.a(this.jdField_a_of_type_Tij);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = tju.b();
    localWSDownloadParams.mScheme = paramString;
    tfa.a((Activity)this.jdField_a_of_type_AndroidContentContext, localWSDownloadParams, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      tij.a(this.jdField_a_of_type_Tij, this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tim
 * JD-Core Version:    0.7.0.1
 */