package dov.com.qq.im.ae.camera.ui.panel;

import awzj;
import axbu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AEMaterialProviderView$3
  implements Runnable
{
  AEMaterialProviderView$3(AEMaterialProviderView paramAEMaterialProviderView, int paramInt, axbu paramaxbu) {}
  
  public void run()
  {
    AEGridView localAEGridView = (AEGridView)AEMaterialProviderView.a(this.this$0).mF.get(Integer.valueOf(this.eEq));
    if (localAEGridView != null)
    {
      localawzj = (awzj)localAEGridView.getAdapter();
      localAEGridView.adF(this.b.position);
      localawzj.i(this.b);
    }
    while (!QLog.isColorLevel())
    {
      awzj localawzj;
      return;
    }
    QLog.d("AEMaterialProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView.3
 * JD-Core Version:    0.7.0.1
 */