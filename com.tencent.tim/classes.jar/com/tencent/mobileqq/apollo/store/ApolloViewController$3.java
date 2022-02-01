package com.tencent.mobileqq.apollo.store;

import abtv;
import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;

public class ApolloViewController$3
  implements Runnable
{
  public ApolloViewController$3(abtv paramabtv, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((abtv.a(this.this$0) == null) || (abtv.a(this.this$0) == null)) {
      return;
    }
    if (abtv.a(this.this$0) == null)
    {
      abtv.a(this.this$0, new ApolloImageShareLayout(this.val$activity));
      abtv.a(this.this$0).a(abtv.a(this.this$0).getWidth(), abtv.a(this.this$0).getHeight(), this.b, abtv.a(this.this$0).roleId, abtv.a(this.this$0).dressIds, this.this$0.sF);
      abtv.a(this.this$0).addView(abtv.a(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    abtv.a(this.this$0).bringToFront();
    abtv.a(this.this$0).a(abtv.a(this.this$0).roleId, abtv.a(this.this$0).dressIds, this.this$0.sF, this.bhI, this.val$nickName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */