package com.tencent.mobileqq.apollo.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class ApolloGameUtil$16
  implements Runnable
{
  ApolloGameUtil$16(String paramString, int paramInt) {}
  
  public void run()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
    localIntent.putExtra("key_shortcut_name", this.val$name);
    if (this.coF == 1) {
      localIntent.putExtra("jump_game_city", true);
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130838579);
        localIntent.setFlags(337641472);
        ApolloGameUtil.a(localIntent, this.val$name, localBitmap, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloGameUtil", 1, localException, new Object[0]);
        Object localObject1 = null;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ApolloGameUtil", 1, localOutOfMemoryError, new Object[0]);
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.16
 * JD-Core Version:    0.7.0.1
 */