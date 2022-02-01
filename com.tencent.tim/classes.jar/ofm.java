import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.a;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout.b;

public class ofm
  implements WSTabLayout.a
{
  public ofm(WSHomeFragment paramWSHomeFragment) {}
  
  public void uC(int paramInt)
  {
    WSHomeFragment.b(this.this$0, false);
    if ((WSHomeFragment.a(this.this$0) == null) || (WSHomeFragment.b(this.this$0) == null)) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      WSHomeFragment.a(this.this$0).setCurrentItem(paramInt);
      return;
      WSHomeFragment.a(this.this$0).bgV();
      WSHomeFragment.b(this.this$0).bgW();
      continue;
      WSHomeFragment.a(this.this$0).bgW();
      WSHomeFragment.b(this.this$0).bgV();
      if ((oor.isDebug()) && (WSHomeFragment.mCurrentPageIndex == 1))
      {
        int i = oor.bfy + 1;
        oor.bfy = i;
        oor.bfy = i % 10;
        arxa.a().showToast("card type changed: " + oor.bfy);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofm
 * JD-Core Version:    0.7.0.1
 */