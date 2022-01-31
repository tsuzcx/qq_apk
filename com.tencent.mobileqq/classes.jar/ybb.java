import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader.P2VEffectDownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

public class ybb
  implements ModuleDownloadListener
{
  public ybb(P2VEffectLoader paramP2VEffectLoader, P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener) {}
  
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
    if (!paramString.equals("p2v_material.zip")) {
      return;
    }
    QZLog.i("P2VEffectLoader", 4, new Object[] { "onDownloadSucceed url = ", P2VEffectLoader.c(), P2VEffectLoader.d() });
    LocalMultiProcConfig.putString("p2v_effect_material_md5", P2VEffectLoader.d());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader$P2VEffectDownloadListener.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ybb
 * JD-Core Version:    0.7.0.1
 */