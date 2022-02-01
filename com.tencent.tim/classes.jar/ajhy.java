import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.b;
import com.tencent.qphone.base.util.QLog;

public class ajhy
  implements TabPageIndicator.b
{
  public ajhy(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void QR(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onActionUpNotFling() called with: initialVelocity = [" + paramInt + "]");
    }
    MultiAIOFragment.a(this.this$0).setViewPagerBusy(true);
    MultiAIOFragment.a(this.this$0).QW(paramInt);
    if (MultiAIOFragment.a(this.this$0).getScrollState() == 0) {
      MultiAIOFragment.a(this.this$0).setViewPagerBusy(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhy
 * JD-Core Version:    0.7.0.1
 */