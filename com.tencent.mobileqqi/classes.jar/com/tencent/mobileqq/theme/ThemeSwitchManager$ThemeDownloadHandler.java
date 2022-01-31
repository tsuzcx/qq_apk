package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ThemeSwitchManager$ThemeDownloadHandler
  extends TransProcessorHandler
{
  private ThemeSwitchManager$ThemeDownloadHandler(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    Object localObject1 = (FileMsg)paramMessage.obj;
    int k;
    long l;
    if (localObject1 != null)
    {
      k = paramMessage.what;
      paramMessage = ((FileMsg)localObject1).e;
      l = ((FileMsg)localObject1).d;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "handleMessage:" + k + " " + " " + paramMessage + " " + l + " ");
      }
      if ((!TextUtils.isEmpty(paramMessage)) && (paramMessage.startsWith(AppConstants.bb))) {
        break label147;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "not download theme file message" + AppConstants.bb);
      }
    }
    label147:
    label1178:
    label1480:
    label1481:
    for (;;)
    {
      return;
      Object localObject2 = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(ThemeSwitchManager.access$000(this.this$0));
      if ((localObject2 == null) || (!((ThemeUtil.ThemeInfo)localObject2).downloadUrl.equals(((FileMsg)localObject1).k)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ThemeSwitch", 4, "not download theme file url" + ((FileMsg)localObject1).k);
        }
      }
      else
      {
        paramMessage = new Bundle();
        int i;
        if (k == 2002)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ThemeSwitch", 4, "download theme file process transferedSize: " + l + ", filesize=" + ((FileMsg)localObject1).a);
          }
          if (localObject2 != null)
          {
            ((ThemeUtil.ThemeInfo)localObject2).downsize = l;
            ((ThemeUtil.ThemeInfo)localObject2).status = "2";
            this.this$0.downloadThemeMap.put(ThemeSwitchManager.access$000(this.this$0), localObject2);
            ThemeUtil.setThemeInfo(ThemeSwitchManager.access$100(this.this$0), (ThemeUtil.ThemeInfo)localObject2);
            paramMessage.putInt("result", 3);
            paramMessage.putLong("transferedSize", l);
            paramMessage.putLong("filesize", ((ThemeUtil.ThemeInfo)localObject2).size);
            ThemeSwitchManager.access$200(this.this$0, true, false, paramMessage);
            i = j;
            if (l == ((ThemeUtil.ThemeInfo)localObject2).size)
            {
              removeMessages(2002);
              i = j;
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (i == 0) {
              break label1481;
            }
            ThemeSwitchManager.access$800(this.this$0, paramMessage);
            return;
            if (ThemeSwitchManager.isDownloadingInProgress)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitch", 2, "downloadThemeMap themeInfo is null,themeId=" + ThemeSwitchManager.access$000(this.this$0));
              }
              ThemeSwitchManager.isDownloadingInProgress = false;
              paramMessage.putInt("result", 256);
              paramMessage.putCharSequence("message", "downloadThemeMap themeInfo is null,themeId=" + ThemeSwitchManager.access$000(this.this$0));
              i = 1;
            }
            else
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("ThemeSwitch", 2, "user pause download, themeId=" + ThemeSwitchManager.access$000(this.this$0));
                i = j;
                continue;
                if (k != 2003) {
                  break label1270;
                }
                try
                {
                  localObject1 = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(ThemeSwitchManager.access$000(this.this$0));
                  if (localObject1 == null) {
                    break label1178;
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("ThemeSwitch", 4, "download theme success themeID: " + ((ThemeUtil.ThemeInfo)localObject1).themeId);
                  }
                  ((ThemeUtil.ThemeInfo)localObject1).downsize = l;
                  ((ThemeUtil.ThemeInfo)localObject1).status = "3";
                  this.this$0.downloadThemeMap.remove(ThemeSwitchManager.access$000(this.this$0));
                  ThemeUtil.setThemeInfo(ThemeSwitchManager.access$100(this.this$0), (ThemeUtil.ThemeInfo)localObject1);
                  paramMessage.putInt("result", 1);
                  paramMessage.putCharSequence("message", "ok, Theme downloaded.");
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  localObject2 = ThemeSwitchManager.access$300(this.this$0, ThemeSwitchManager.access$100(this.this$0));
                  if (localObject2 == null) {
                    break;
                  }
                  Object localObject3 = localObject2[1];
                  Activity localActivity = (Activity)ThemeSwitchManager.access$400(this.this$0).get();
                  if ((localObject3 != null) && (localActivity != null) && (localObject3.equals(SplashActivity.class.getName())) && ((localActivity instanceof SplashActivity)) && (((FrameActivity)localActivity).a() == 3))
                  {
                    paramMessage.putSerializable("themeinfo", (Serializable)localObject1);
                    if (ThemeSwitchManager.access$500(this.this$0)) {
                      ThemeSwitchManager.access$200(this.this$0, true, false, paramMessage);
                    }
                    this.this$0.setup(BaseApplicationImpl.a.a(), (ThemeUtil.ThemeInfo)localObject1);
                  }
                  else if ((!localObject2[0].equals(ThemeSwitchManager.access$100(this.this$0).getPackageName())) || (localObject3.equals(AVActivity.class.getName())) || (localObject3.equals(VideoInviteFull.class.getName())) || (localObject3.equals(AIOGalleryActivity.class.getName())))
                  {
                    if (ThemeSwitchManager.access$600(this.this$0) == null) {
                      ThemeSwitchManager.access$602(this.this$0, ThreadManager.b());
                    }
                    this.this$0.isComplete = false;
                    if (ThemeSwitchManager.access$700(this.this$0) == null) {
                      ThemeSwitchManager.access$702(this.this$0, new ThemeSwitchManager.ThemeDownloadHandler.1(this, localActivity, paramMessage, (ThemeUtil.ThemeInfo)localObject1));
                    }
                    localObject1 = new IntentFilter();
                    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
                    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
                    if (this.this$0.screenBroadcastReceiver == null) {
                      this.this$0.screenBroadcastReceiver = new ThemeSwitchManager.ThemeDownloadHandler.2(this);
                    }
                    ThemeSwitchManager.access$100(this.this$0).registerReceiver(this.this$0.screenBroadcastReceiver, (IntentFilter)localObject1);
                    ThemeSwitchManager.access$600(this.this$0).postDelayed(ThemeSwitchManager.access$700(this.this$0), 3000L);
                  }
                }
                catch (Exception localException1)
                {
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  localException1.printStackTrace();
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "File download finish Exception:" + localException1.getMessage());
                  i = 1;
                }
              }
            }
          }
          continue;
          if (ThemeSwitchManager.access$500(this.this$0))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("themedownloadalert", true);
            ((Intent)localObject2).putExtra("themeID", localException1.themeId);
            ((Intent)localObject2).setClass(ThemeSwitchManager.access$100(this.this$0), ThemeSwitchDlgActivity.class);
            if (BaseActivity.a != null)
            {
              BaseActivity.a.startActivity((Intent)localObject2);
              return;
            }
            ((Intent)localObject2).setFlags(268435456);
            ThemeSwitchManager.access$100(this.this$0).startActivity((Intent)localObject2);
            return;
            if (ThemeSwitchManager.isDownloadingInProgress)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitch", 2, "downloadThemeMap themeInfo is null,themeId=" + ThemeSwitchManager.access$000(this.this$0));
              }
              ThemeSwitchManager.isDownloadingInProgress = false;
              paramMessage.putInt("result", 256);
              paramMessage.putCharSequence("message", "downloadThemeMap themeInfo is null,themeId=" + ThemeSwitchManager.access$000(this.this$0));
              i = 1;
              break label1480;
              label1270:
              if (k == 2005)
              {
                try
                {
                  ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(ThemeSwitchManager.access$000(this.this$0));
                  if (localThemeInfo != null)
                  {
                    localThemeInfo.downsize = l;
                    localThemeInfo.status = "4";
                    ThemeUtil.setThemeInfo(ThemeSwitchManager.access$100(this.this$0), localThemeInfo);
                    this.this$0.downloadThemeMap.remove(ThemeSwitchManager.access$000(this.this$0));
                  }
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "recv error");
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  i = 1;
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "File download revice error Exception:" + localException2.getMessage());
                  i = 1;
                }
              }
              else
              {
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("ThemeSwitch", 2, "unknown what: " + k);
                  i = j;
                }
              }
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler
 * JD-Core Version:    0.7.0.1
 */