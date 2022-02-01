import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class kgb
  implements ViewPager.OnPageChangeListener
{
  kgb(kfv paramkfv) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    kfv.b(this.this$0, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      kfv.b(this.this$0);
      kfv.a(this.this$0).notifyDataSetChanged();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!kfv.a(this.this$0)) {
      kfv.a(this.this$0, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.this$0.a();
    if ((paramInt1 >= kfv.aIs) && (localTabChannelCoverInfo != null)) {
      kfv.b(this.this$0, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.this$0.a();
    kfv.a = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      kfv.b(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (kfv.a(this.this$0) == 0) {
      kfv.a(this.this$0, paramInt);
    }
    kfv.b(this.this$0, paramInt);
    kfv.a(this.this$0, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (kfv.a(this.this$0) == 0) {
      kfv.b(this.this$0);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      kfv.access$2302(bool);
      kfv.c(this.this$0);
      kfv.a(this.this$0, kfv.zk());
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", kfv.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgb
 * JD-Core Version:    0.7.0.1
 */