package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import aqml;

final class ApolloGameUtil$17
  implements Runnable
{
  ApolloGameUtil$17(Context paramContext, String paramString, ApolloGameUtil.d paramd, Intent paramIntent, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (aqml.hasShortCut(this.val$context, new String[] { this.val$name }))
    {
      ApolloGameUtil.Ip(2);
      if (this.a != null) {
        this.a.bX(2);
      }
    }
    label130:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            ApolloGameUtil.b(this.T, this.val$name, this.eG);
            Thread.sleep(1000L);
            if (!aqml.hasShortCut(this.val$context, new String[] { this.val$name })) {
              break label130;
            }
            ApolloGameUtil.Ip(0);
            if (this.a != null)
            {
              this.a.bX(0);
              return;
            }
          }
          catch (Exception localException)
          {
            ApolloGameUtil.Ip(4);
          }
        }
      } while (this.a == null);
      this.a.bX(4);
      return;
      ApolloGameUtil.Ip(3);
    } while (this.a == null);
    this.a.bX(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.17
 * JD-Core Version:    0.7.0.1
 */