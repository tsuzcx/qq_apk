package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import arcd;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import khc;

public class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2
  implements Runnable
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$2(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void run()
  {
    if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.this$0.a.eQ != null)) {
      this.this$0.a.eQ.setBackgroundColor(-1);
    }
    if (this.this$0.hW != null)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.this$0.hW.animate().alpha(0.0F).setDuration(200L).setListener(new khc(this));
        this.this$0.hW.animate().start();
      }
    }
    else {
      return;
    }
    this.this$0.hW.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */