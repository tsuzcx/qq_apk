import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class tul
  implements TopGestureLayout.OnGestureListener
{
  private tul(ViolaFragment paramViolaFragment) {}
  
  private BridgeModule a()
  {
    ViolaBaseView localViolaBaseView = this.a.getViolaBaseView();
    if (localViolaBaseView == null) {
      return null;
    }
    return (BridgeModule)localViolaBaseView.a(BridgeModule.MODULE_NAME);
  }
  
  public void flingLToR()
  {
    BridgeModule localBridgeModule = a();
    if ((localBridgeModule != null) && (localBridgeModule.onFlingLToR())) {
      return;
    }
    this.a.judgeIfNeedInterruptLToR();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tul
 * JD-Core Version:    0.7.0.1
 */