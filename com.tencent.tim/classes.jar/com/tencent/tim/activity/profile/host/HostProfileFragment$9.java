package com.tencent.tim.activity.profile.host;

import alcn;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import aqcu;
import aqep;
import aqhu;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class HostProfileFragment$9
  implements Runnable
{
  HostProfileFragment$9(HostProfileFragment paramHostProfileFragment) {}
  
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
        if (HostProfileFragment.a(this.this$0).get())
        {
          localOptions.inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject3, HostProfileFragment.b(this.this$0).getWidth(), HostProfileFragment.c(this.this$0).getHeight()));
          ((BufferedInputStream)localObject3).close();
          localObject1 = aqcu.decodeFile((String)localObject1, localOptions);
          localObject2 = localObject1;
          if (localObject1 == null) {}
        }
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = QQAppInterface.getCircleFaceBitmap((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        localObject1 = localObject2;
        if (localObject1 == null) {
          break label235;
        }
        this.this$0.getActivity().runOnUiThread(new HostProfileFragment.9.1(this, (Bitmap)localObject1));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("AvatarPendantActivity decode Avatar, bitmap is null:");
          if (localObject1 != null) {
            break label258;
          }
          bool = true;
          QLog.d("Q.dynamicAvatar", 2, bool);
        }
        return;
      }
      catch (Exception localException2)
      {
        label258:
        for (;;)
        {
          label235:
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
        HostProfileFragment.a(this.this$0, HostProfileFragment.b(this.this$0).e.uin);
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.host.HostProfileFragment.9
 * JD-Core Version:    0.7.0.1
 */