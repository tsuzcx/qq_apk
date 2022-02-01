package dov.com.qq.im.ae.camera.ui.panel;

import awzj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class AEMaterialAdapter$1
  implements Runnable
{
  public AEMaterialAdapter$1(awzj paramawzj) {}
  
  public void run()
  {
    FeatureManager.loadBasicFeatures();
    QLog.d("Q.videostory.capture", 1, "use material failed because of so load failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.1
 * JD-Core Version:    0.7.0.1
 */