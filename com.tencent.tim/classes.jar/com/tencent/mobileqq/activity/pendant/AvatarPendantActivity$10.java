package com.tencent.mobileqq.activity.pendant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import aqcu;
import aqep;
import aqhu;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class AvatarPendantActivity$10
  implements Runnable
{
  AvatarPendantActivity$10(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    localObject2 = null;
    localObject1 = null;
    if (aqep.aBY()) {}
    for (;;)
    {
      Object localObject3;
      BitmapFactory.Options localOptions;
      boolean bool;
      try
      {
        localObject1 = aqep.BS();
        localObject3 = new File((String)localObject1);
        localOptions = new BitmapFactory.Options();
        localObject3 = new BufferedInputStream(new FileInputStream((File)localObject3));
        if (this.this$0.bR.get())
        {
          localOptions.inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject3, this.this$0.b.getWidth(), this.this$0.b.getHeight()));
          ((BufferedInputStream)localObject3).close();
          localObject1 = aqcu.decodeFile((String)localObject1, localOptions);
          localObject2 = localObject1;
          if (localObject1 == null) {}
        }
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = this.this$0.app;
        localObject2 = QQAppInterface.getCircleFaceBitmap((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        localObject1 = localObject2;
        if (localObject1 == null) {
          break label240;
        }
        this.this$0.runOnUiThread(new AvatarPendantActivity.10.1(this, (Bitmap)localObject1));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("AvatarPendantActivity decode Avatar, bitmap is null:");
          if (localObject1 != null) {
            break label260;
          }
          bool = true;
          QLog.d("Q.dynamicAvatar", 2, bool);
        }
        return;
      }
      catch (Exception localException2)
      {
        label260:
        for (;;)
        {
          label240:
          localObject2 = localObject1;
        }
      }
      localOptions.inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject3, 120, 120));
      continue;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AvatarPendantActivity", 2, localException1.toString());
        localObject1 = localObject2;
        continue;
        AvatarPendantActivity.a(this.this$0, this.this$0.c.uin);
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.10
 * JD-Core Version:    0.7.0.1
 */