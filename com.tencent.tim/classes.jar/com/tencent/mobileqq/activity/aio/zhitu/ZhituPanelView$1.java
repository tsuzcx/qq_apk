package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import anot;
import aqhq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import ykm;
import ykv;

class ZhituPanelView$1
  implements Runnable
{
  ZhituPanelView$1(ZhituPanelView paramZhituPanelView, ykv paramykv) {}
  
  public void run()
  {
    Object localObject3;
    if (!this.d.isGif)
    {
      localObject3 = ykm.a(this.this$0.mBaseChatPie.app).g(this.d.url, this.d.gJ);
      if (!(this.d.drawable instanceof BitmapDrawable)) {
        break label496;
      }
    }
    File localFile;
    label340:
    label496:
    for (Object localObject1 = ((BitmapDrawable)this.d.drawable).getBitmap();; localFile = null)
    {
      if (localObject1 == null) {
        return;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!((File)localObject3).exists())
            {
              ((File)localObject3).getParentFile().mkdirs();
              ((File)localObject3).createNewFile();
            }
            boolean bool = aqhq.c((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
            if (!bool) {
              break;
            }
            localObject1 = localObject3;
            if (ykm.a(this.this$0.mBaseChatPie.app).getCurType() != 7220) {
              break label340;
            }
            this.d.path = ((File)localObject1).getAbsolutePath();
            ykm.a(this.this$0.mBaseChatPie.app).i(this.d);
            anot.a(this.this$0.mBaseChatPie.app, "dc00898", "", "", "0X8008C72", "0X8008C72", ykm.fq(ykm.a(this.this$0.mBaseChatPie.app).getCurType()), 0, "", "", "", "");
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            ykm.a(localOutOfMemoryError1);
            return;
          }
          if (this.d.path == null) {
            try
            {
              Object localObject2 = ykm.a(this.this$0.mBaseChatPie.app).a(this.d);
              if (localObject2 == null) {
                break;
              }
              localObject2 = new File((String)localObject2);
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              for (;;)
              {
                QLog.e(ZhituPanelView.access$000(), 1, "oom when save bitmap");
                ykm.a(localOutOfMemoryError2);
                localFile = null;
              }
            }
          }
        }
        localFile = ykm.a(this.this$0.mBaseChatPie.app).g(this.d.url, this.d.gJ);
        aqhq.copyFile(this.d.path, localFile.getAbsolutePath());
        continue;
        localObject3 = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localFile.getAbsolutePath());
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1049);
        ((Intent)localObject3).putExtra("uin", this.this$0.mBaseChatPie.sessionInfo.aTl);
        ((Intent)localObject3).putExtra("uintype", this.this$0.mBaseChatPie.sessionInfo.cZ);
        ((Intent)localObject3).putExtra("troop_uin", this.this$0.mBaseChatPie.sessionInfo.troopUin);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).putExtra("send_in_background", true);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
        new SendPhotoTask(this.this$0.mBaseChatPie.a(), (Intent)localObject3, null).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.1
 * JD-Core Version:    0.7.0.1
 */