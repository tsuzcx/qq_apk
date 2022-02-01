package com.tencent.mobileqq.richmedia.capture.view;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;

class PtvTemplateProviderView$1
  implements Runnable
{
  PtvTemplateProviderView$1(PtvTemplateProviderView paramPtvTemplateProviderView) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.this$0.bZw)) && (this.this$0.Ft.size() > 1) && (!this.this$0.cBl))
    {
      this.this$0.cBl = true;
      this.this$0.setTab(this.this$0.bZw);
      this.this$0.bZw = "";
      this.this$0.dzO = -1;
    }
    do
    {
      return;
      if ((this.this$0.dzO > 0) && (this.this$0.Ft.size() > 1) && (!this.this$0.cBl))
      {
        this.this$0.cBl = true;
        this.this$0.setTab(this.this$0.dzO);
        this.this$0.bZw = "";
        this.this$0.dzO = -1;
        return;
      }
    } while ((this.this$0.cBl) || (this.this$0.Ft.size() <= this.this$0.dzN) || (this.this$0.b.getCurrentItem() != 0));
    this.this$0.b.setCurrentItem(this.this$0.dzN);
    this.this$0.c.TX(this.this$0.dzN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView.1
 * JD-Core Version:    0.7.0.1
 */