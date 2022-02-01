import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.3.1;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.3.2;
import mqq.os.MqqHandler;

public class axfi
  implements axbv.a
{
  axfi(axfg paramaxfg) {}
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEGIFMaterialViewModel.3.1(this, paramMetaMaterial));
  }
  
  public void b(MetaMaterial paramMetaMaterial, int paramInt) {}
  
  public void c(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEGIFMaterialViewModel.3.2(this, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfi
 * JD-Core Version:    0.7.0.1
 */