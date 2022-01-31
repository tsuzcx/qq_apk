import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader.P2VEffectDownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

public class xur
  implements ModuleDownloadListener
{
  public xur(P2VEffectLoader paramP2VEffectLoader, P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("P2VEffectLoader", 4, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("P2VEffectLoader", 4, new Object[] { "onDownloadFailed ", paramString });
    P2VEffectLoader.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader$P2VEffectDownloadListener.a(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    QZLog.i("P2VEffectLoader", 4, new Object[] { "moduleId = ", paramString, " progress = ", Float.valueOf(paramFloat) });
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("p2v_effect.jar")) {
      return;
    }
    QZLog.i("P2VEffectLoader", 4, new Object[] { "onDownloadSucceed url = ", P2VEffectLoader.a(), P2VEffectLoader.b() });
    LocalMultiProcConfig.putString("p2v_effect_jar_md5", P2VEffectLoader.b());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader$P2VEffectDownloadListener.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xur
 * JD-Core Version:    0.7.0.1
 */