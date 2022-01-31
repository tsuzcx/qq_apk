package com.tencent.token.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;

final class zy
  implements ViewPager.OnPageChangeListener
{
  zy(SettingPageActivity paramSettingPageActivity) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    SettingPageActivity.access$800(this.a)[SettingPageActivity.access$900(this.a)].setBackgroundResource(2130837541);
    SettingPageActivity.access$902(this.a, paramInt);
    SettingPageActivity.access$800(this.a)[paramInt].setBackgroundResource(2130837542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zy
 * JD-Core Version:    0.7.0.1
 */