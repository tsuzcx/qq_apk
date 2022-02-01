package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;

final class ApolloGameUtil$9
  implements Runnable
{
  ApolloGameUtil$9(ApolloFragment paramApolloFragment, String paramString) {}
  
  public void run()
  {
    if ((this.c != null) && ((this.c instanceof ApolloWebViewFragment)) && (!TextUtils.isEmpty(this.bka))) {
      ((ApolloWebViewFragment)this.c).BW(this.bka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.9
 * JD-Core Version:    0.7.0.1
 */