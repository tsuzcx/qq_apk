package com.tencent.mobileqq.listentogether.ui;

import aiqd;
import aiqh;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import aqnm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseListenTogetherPanel$6
  implements Runnable
{
  public BaseListenTogetherPanel$6(aiqd paramaiqd) {}
  
  public void run()
  {
    try
    {
      View localView = ((LayoutInflater)this.this$0.mActivity.getSystemService("layout_inflater")).inflate(2131561192, this.this$0.e, false);
      localView.measure(0, 0);
      this.this$0.h = new PopupWindow(localView);
      this.this$0.h.setHeight(-2);
      this.this$0.h.setWidth(-2);
      this.this$0.h.setOutsideTouchable(true);
      localView.setOnClickListener(new aiqh(this));
      if (this.this$0.e != null) {}
      for (int i = this.this$0.e.getWidth();; i = aqnm.getScreenWidth())
      {
        int j = localView.getMeasuredWidth();
        int k = aqnm.dip2px(52.0F);
        this.this$0.h.showAsDropDown(this.this$0.bL, i - j - k, 0);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BaseListenTogetherPanel", 1, "showGuide exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6
 * JD-Core Version:    0.7.0.1
 */