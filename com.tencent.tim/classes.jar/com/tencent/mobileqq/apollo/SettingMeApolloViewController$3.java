package com.tencent.mobileqq.apollo;

import acbk;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import java.lang.ref.WeakReference;

class SettingMeApolloViewController$3
  implements Runnable
{
  SettingMeApolloViewController$3(SettingMeApolloViewController paramSettingMeApolloViewController, String paramString) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.this$0).get();
    if (localViewGroup == null) {
      return;
    }
    if (this.this$0.e == null)
    {
      this.this$0.e = new FrameGifView(localViewGroup.getContext());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.b.getLayoutParams();
      localViewGroup.addView(this.this$0.e, localLayoutParams);
    }
    this.this$0.b.setVisibility(8);
    if (this.this$0.e.getVisibility() == 8) {
      this.this$0.e.setVisibility(0);
    }
    if (this.this$0.e.getState() == 3)
    {
      this.this$0.e.cGV();
      return;
    }
    this.this$0.e.setGifData(30, null, this.val$url, acbk.jb(this.val$url), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */