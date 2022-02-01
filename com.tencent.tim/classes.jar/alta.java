import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;

public class alta
  implements ViewPager.OnPageChangeListener
{
  public alta(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReceiptMessageReadMemberListContainerFragment.a(this.this$0).setSelectedTab(paramInt, true);
    if (paramInt == 0)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).TN(false);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.this$0).TN(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alta
 * JD-Core Version:    0.7.0.1
 */