package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$1
  implements View.OnClickListener
{
  PagerTabStrip$1(PagerTabStrip paramPagerTabStrip) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mPager.setCurrentItem(this.this$0.mPager.getCurrentItem() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip.1
 * JD-Core Version:    0.7.0.1
 */