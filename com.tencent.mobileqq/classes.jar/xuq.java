import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader;
import com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader.P2VEffectDownloadListener;
import cooperation.qzone.util.QZLog;

public class xuq
  implements P2VEffectLoader.P2VEffectDownloadListener
{
  public xuq(P2VEffectLoader paramP2VEffectLoader, P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader$P2VEffectDownloadListener);
      return;
    }
    QZLog.e("P2VEffectLoader", 1, new Object[] { "downLoadP2VJarAndMaterialModule - downLoadP2VJarModule failed" });
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader$P2VEffectDownloadListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuq
 * JD-Core Version:    0.7.0.1
 */