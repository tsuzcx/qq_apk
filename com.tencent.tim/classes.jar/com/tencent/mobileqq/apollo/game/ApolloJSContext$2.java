package com.tencent.mobileqq.apollo.game;

import ablq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.ValueCallback;

public class ApolloJSContext$2
  implements Runnable
{
  public ApolloJSContext$2(ablq paramablq, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (ablq.a(this.this$0) != null) {
      ablq.a(this.this$0).evaluateJavascript(this.val$script, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext.2
 * JD-Core Version:    0.7.0.1
 */