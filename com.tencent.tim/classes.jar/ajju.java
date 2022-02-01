import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.b;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;

public class ajju
  implements MultiAIOBaseViewPager.b
{
  public ajju(MultiCardFragment paramMultiCardFragment) {}
  
  public void QQ(int paramInt)
  {
    if (MultiCardFragment.a(this.this$0) != null)
    {
      MultiCardFragment.a(this.this$0).setViewPagerBusy(false);
      MultiCardFragment.a(this.this$0).setScrollState(2);
      MultiCardFragment.a(this.this$0).fling(-paramInt);
    }
  }
  
  public void abortAnimation()
  {
    if (MultiCardFragment.a(this.this$0) != null) {
      MultiCardFragment.a(this.this$0).abortAnimation();
    }
  }
  
  public boolean aqL()
  {
    if (MultiCardFragment.a(this.this$0) != null) {
      return MultiCardFragment.a(this.this$0).aqL();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajju
 * JD-Core Version:    0.7.0.1
 */