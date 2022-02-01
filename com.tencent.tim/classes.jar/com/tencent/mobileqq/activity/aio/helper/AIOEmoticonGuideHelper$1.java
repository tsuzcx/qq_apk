package com.tencent.mobileqq.activity.aio.helper;

import aeif;
import aenf.b;
import aenf.c;
import afku;
import afky;
import android.os.Message;
import android.text.TextUtils;
import aoiz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wtk;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(wtk paramwtk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    aenf.c localc = (aenf.c)aeif.a().o(545);
    if (localc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
    }
    for (;;)
    {
      return;
      if (wtk.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
        }
      }
      else if (wtk.a(this.this$0, localc))
      {
        Object localObject = localc.a.Sw;
        if (ThemeUtil.isNowThemeIsNight(wtk.a(this.this$0).app, false, null)) {
          localObject = localc.a.bzL;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!aoiz.hasFile((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("aio_emoticon_guide.helper", 2, "file no download.");
            }
            URLDrawable.getDrawable((String)localObject).startDownload(false);
            return;
          }
          int i = localc.a.cNT;
          int j = localc.a.cNU;
          boolean bool;
          if (j == 1) {
            bool = afky.jm(i);
          }
          while (bool)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 2;
            ((Message)localObject).obj = localc;
            wtk.a(this.this$0).sendMessage((Message)localObject);
            return;
            if (j == 2) {
              bool = afku.jm(afku.hj(i));
            } else {
              bool = false;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */