import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

class vif
  implements vnn
{
  vif(vic paramvic, Context paramContext, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    vmr.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramString, 1, vic.a(this.jdField_a_of_type_Vic), this.jdField_a_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      uyt.a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = vic.a(this.jdField_a_of_type_Vic);
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = vkf.b();
    localWSDownloadParams.mScheme = paramString;
    vbq.a((Activity)this.jdField_a_of_type_AndroidContentContext, localWSDownloadParams, false);
  }
  
  public void d(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      vic.a(this.jdField_a_of_type_Vic, this.jdField_a_of_type_AndroidContentContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vif
 * JD-Core Version:    0.7.0.1
 */