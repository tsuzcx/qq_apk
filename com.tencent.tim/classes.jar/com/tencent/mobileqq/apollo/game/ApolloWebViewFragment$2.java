package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.view.View;
import arcd;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class ApolloWebViewFragment$2
  implements Runnable
{
  ApolloWebViewFragment$2(ApolloWebViewFragment paramApolloWebViewFragment) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.c != null))
    {
      this.this$0.a.c.egN();
      Object localObject = this.this$0.getHostActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).findViewById(16908290);
        if (localObject != null) {
          ((View)localObject).requestLayout();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment.2
 * JD-Core Version:    0.7.0.1
 */