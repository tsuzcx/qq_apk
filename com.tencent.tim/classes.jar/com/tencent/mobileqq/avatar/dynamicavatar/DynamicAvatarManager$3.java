package com.tencent.mobileqq.avatar.dynamicavatar;

import advl;
import advp;
import advr;
import adwc;
import android.text.TextUtils;
import aqcy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DynamicAvatarManager$3
  implements Runnable
{
  public DynamicAvatarManager$3(advr paramadvr, aqcy paramaqcy, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0.uV)
    {
      bool1 = this.this$0.uV.contains(this.a.bc);
      if (bool1)
      {
        if (aqcy.cTz) {}
        synchronized (this.this$0.uV)
        {
          this.this$0.uV.remove(this.a.bc);
          synchronized (this.this$0.uW)
          {
            if (!this.this$0.uW.contains(this.a.bc)) {
              this.this$0.uW.add(this.this$0.uW.size(), this.a.bc);
            }
            if (!TextUtils.isEmpty(this.a.mUrl)) {
              if (!this.a.cTD) {
                break label678;
              }
            }
          }
        }
      }
    }
    DynamicAvatar localDynamicAvatar;
    try
    {
      ??? = this.this$0.a(this.a.dYs, this.a.mId);
      if ((??? != null) && ((this.a.mSource == 1) || (this.a.mSource == 0))) {
        if (this.a.mSource == 0) {
          if (!advr.a(this.this$0).bRn)
          {
            bool1 = true;
            if ((!bool1) || (!adwc.w(System.currentTimeMillis(), ((DynamicAvatar)???).playTimeStamp))) {
              break label402;
            }
            bool2 = true;
            if (!bool2) {
              break label414;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "oneDayOnce:" + bool1 + " playedSameDay:" + bool2 + " uin:" + this.val$key);
            }
          }
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      synchronized (this.this$0.uV)
      {
        for (;;)
        {
          this.this$0.uV.remove(this.a.bc);
          return;
          localObject3 = finally;
          throw localObject3;
          localObject4 = finally;
          throw localObject4;
          localObject5 = finally;
          throw localObject5;
          localNullPointerException = localNullPointerException;
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, localNullPointerException.getMessage(), localNullPointerException);
          }
          localDynamicAvatar = null;
          continue;
          bool1 = false;
          continue;
          if (!advr.a(this.this$0).bRo) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        label402:
        boolean bool2 = false;
      }
    }
    label414:
    Setting localSetting = advr.a(this.this$0, this.a.dYs, this.a.mId);
    boolean bool1 = advr.a(this.this$0, localDynamicAvatar, localSetting, this.a.dYr);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: " + bool1);
    }
    if ((bool1) || (this.a.cTD)) {
      try
      {
        ((advp)advr.a(this.this$0).getBusinessHandler(97)).a(Long.valueOf(this.a.mId), this.a.dYs, this.a.dYr, this.a.dYt, this.a.cTA);
        return;
      }
      catch (Exception localException)
      {
        synchronized (this.this$0.uV)
        {
          this.this$0.uV.remove(this.a.bc);
          return;
        }
      }
    }
    String str = advr.a(this.a.dYr, this.a.dYt, (DynamicAvatar)???);
    ??? = advr.a(this.a.dYr, 640, (DynamicAvatar)???);
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "execute loadDynamicAvatarInfo runnable. url : " + str);
    }
    advr.a(this.this$0, this.val$key, str, (String)???);
    return;
    label678:
    advr.a(this.this$0, this.val$key, this.a.mUrl, this.a.mBigUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.3
 * JD-Core Version:    0.7.0.1
 */