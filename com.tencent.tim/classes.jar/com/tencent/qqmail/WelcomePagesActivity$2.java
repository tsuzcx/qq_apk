package com.tencent.qqmail;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

class WelcomePagesActivity$2
  extends PagerAdapter
{
  WelcomePagesActivity$2(WelcomePagesActivity paramWelcomePagesActivity) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)WelcomePagesActivity.access$100(this.this$0).get(paramInt));
  }
  
  public int getCount()
  {
    return WelcomePagesActivity.access$100(this.this$0).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)WelcomePagesActivity.access$100(this.this$0).get(paramInt));
    return WelcomePagesActivity.access$100(this.this$0).get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomePagesActivity.2
 * JD-Core Version:    0.7.0.1
 */