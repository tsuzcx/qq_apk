package com.tencent.mobileqq.apollo.game;

import able;
import android.content.Intent;
import android.text.TextUtils;

class WebGameFakeView$2
  implements Runnable
{
  WebGameFakeView$2(WebGameFakeView paramWebGameFakeView, Intent paramIntent) {}
  
  public void run()
  {
    if (this.val$intent != null)
    {
      WebGameFakeView.Director localDirector = new WebGameFakeView.Director();
      String str = this.val$intent.getStringExtra(WebGameFakeView.Director.TITLE);
      if (!TextUtils.isEmpty(str)) {
        localDirector.title = str;
      }
      str = this.val$intent.getStringExtra(WebGameFakeView.Director.FOREGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.frontColor = str;
      }
      str = this.val$intent.getStringExtra(WebGameFakeView.Director.BACKGROUND_COLOR);
      if (!TextUtils.isEmpty(str)) {
        localDirector.bgColor = str;
      }
      this.this$0.a = localDirector;
      this.this$0.cCX();
      this.val$intent.putExtra("Director", localDirector);
    }
    able.a().a(this.val$intent, ApolloWebViewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.WebGameFakeView.2
 * JD-Core Version:    0.7.0.1
 */