package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import ndi;
import nec;

public class ReadInJoyBaseAdapter$35$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$35$1(nec paramnec) {}
  
  public void run()
  {
    this.a.this$0.j(this.a.d);
    if ((this.a.this$0.mContext instanceof BaseActivity)) {
      QQToast.a(this.a.this$0.mContext, -1, this.a.this$0.mContext.getString(2131701914), 0).show(((BaseActivity)this.a.this$0.mContext).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.this$0.a(this.a.val$position, this.a.d, this.a.kM);
      return;
      if ((this.a.this$0.mContext instanceof PluginBaseActivity)) {
        QQToast.a(this.a.this$0.mContext, -1, this.a.this$0.mContext.getString(2131701914), 0).show(((PluginBaseActivity)this.a.this$0.mContext).getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.35.1
 * JD-Core Version:    0.7.0.1
 */