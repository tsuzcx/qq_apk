import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.b;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class ajjy
  implements TabPageIndicator.b
{
  public ajjy(MultiCardFragment paramMultiCardFragment) {}
  
  public void QR(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onActionUpNotFling() called with: initialVelocity = [" + paramInt + "]");
    }
    if (MultiCardFragment.a(this.this$0) != null) {
      MultiCardFragment.a(this.this$0).setViewPagerBusy(true);
    }
    if (MultiCardFragment.a(this.this$0) != null)
    {
      MultiCardFragment.a(this.this$0).QW(paramInt);
      if ((MultiCardFragment.a(this.this$0).getScrollState() == 0) && (MultiCardFragment.a(this.this$0) != null)) {
        MultiCardFragment.a(this.this$0).setViewPagerBusy(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjy
 * JD-Core Version:    0.7.0.1
 */