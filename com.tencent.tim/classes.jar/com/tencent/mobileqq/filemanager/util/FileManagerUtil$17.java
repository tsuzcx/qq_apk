package com.tencent.mobileqq.filemanager.util;

import ahav;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import aqho;
import aqlr;
import aqoo;
import aqoq;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public final class FileManagerUtil$17
  implements Runnable
{
  public FileManagerUtil$17(Context paramContext, int paramInt, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(this.val$context.getResources(), this.cYW, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Object localObject2 = BitmapFactory.decodeResource(this.val$context.getResources(), this.cYW, (BitmapFactory.Options)localObject1);
      if (localObject2 == null) {
        return;
      }
      int i = aqho.O(this.val$context);
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getWidth() != i) {
        if (aqoq.cVg) {
          break label163;
        }
      }
      label163:
      for (localObject1 = aqoo.a().createScaledBitmapByConfig((Bitmap)localObject2, i); Build.VERSION.SDK_INT < 26; localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, i, false))
      {
        localObject2 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject2).putExtra(this.bJI, true);
        ((Intent)localObject2).setClassName(this.val$context, JumpActivity.class.getName());
        ((Intent)localObject2).setFlags(337641472);
        aqlr.a(this.val$app, (Intent)localObject2, this.bJJ, (Bitmap)localObject1);
        return;
      }
      ahav.e(this.val$context, this.bJI, this.bJJ, this.cYW);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.17
 * JD-Core Version:    0.7.0.1
 */