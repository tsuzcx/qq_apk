import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.3.1;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel.3.2;
import mqq.os.MqqHandler;

public class axdb
  implements axbv.a
{
  axdb(axcz paramaxcz) {}
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.3.1(this, paramMetaMaterial));
  }
  
  public void b(MetaMaterial paramMetaMaterial, int paramInt)
  {
    axcz.a(this.this$0).postValue(new axcb(paramMetaMaterial, 1, paramInt));
  }
  
  public void c(MetaMaterial paramMetaMaterial)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryGIFTplViewModel.3.2(this, paramMetaMaterial));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdb
 * JD-Core Version:    0.7.0.1
 */