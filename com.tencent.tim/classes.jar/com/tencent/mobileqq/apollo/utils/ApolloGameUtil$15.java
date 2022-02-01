package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.utils.VipUtils;

final class ApolloGameUtil$15
  implements Runnable
{
  ApolloGameUtil$15(Context paramContext, int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, ApolloGameUtil.c paramc) {}
  
  public void run()
  {
    if ((this.val$context != null) && ((this.val$context instanceof ApolloGameActivity)))
    {
      VipUtils.a(null, "cmshow", "Apollo", "pressSendToDesktopButton", 0, 0, new String[] { String.valueOf(this.val$gameId) });
      ((ApolloGameActivity)this.val$context).a(this.val$gameId, this.T, this.val$name, this.bZ, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.15
 * JD-Core Version:    0.7.0.1
 */