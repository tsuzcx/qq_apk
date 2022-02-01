import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.b;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;

public class ajhu
  implements MultiAIOBaseViewPager.b
{
  public ajhu(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void QQ(int paramInt)
  {
    MultiAIOFragment.a(this.this$0).setViewPagerBusy(false);
    MultiAIOFragment.a(this.this$0).setScrollState(2);
    MultiAIOFragment.a(this.this$0).fling(-paramInt);
  }
  
  public void abortAnimation()
  {
    MultiAIOFragment.a(this.this$0).abortAnimation();
  }
  
  public boolean aqL()
  {
    return MultiAIOFragment.a(this.this$0).aqL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhu
 * JD-Core Version:    0.7.0.1
 */