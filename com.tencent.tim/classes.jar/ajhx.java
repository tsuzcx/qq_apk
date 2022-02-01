import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator.c;
import com.tencent.qphone.base.util.QLog;

public class ajhx
  implements TabPageIndicator.c
{
  public ajhx(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "Indicator onPageScrollStateChanged() called with: state = [" + paramInt + "]");
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      MultiAIOFragment.a(this.this$0, MultiAIOFragment.a(this.this$0).getCurrentItem());
      return;
    case 1: 
      MultiAIOFragment.c(this.this$0);
      return;
    }
    MultiAIOFragment.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhx
 * JD-Core Version:    0.7.0.1
 */