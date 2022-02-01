import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.viola.core.ViolaInstance;

public class nvh
  implements nww.a
{
  private String aou;
  private boolean auV;
  
  public nvh(BridgeModule paramBridgeModule) {}
  
  public void aGM() {}
  
  public void ox(boolean paramBoolean)
  {
    ViolaFragment localViolaFragment;
    if ((this.this$0.getViolaInstance() != null) && ((this.this$0.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      localViolaFragment = (ViolaFragment)this.this$0.getViolaInstance().getFragment();
      if (!paramBoolean) {
        break label85;
      }
      this.aou = localViolaFragment.kQ();
      this.auV = localViolaFragment.h().booleanValue();
      localViolaFragment.oI("#FF000000");
      localViolaFragment.oJ("#FF000000");
      localViolaFragment.a(Boolean.valueOf(true), true);
    }
    label85:
    do
    {
      return;
      localViolaFragment.oI(this.aou);
      localViolaFragment.oJ(this.aou);
      localViolaFragment.a(Boolean.valueOf(this.auV), true);
    } while ((!localViolaFragment.Gh()) || (localViolaFragment.a() == null));
    localViolaFragment.a().bbn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvh
 * JD-Core Version:    0.7.0.1
 */