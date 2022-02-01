package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import anot;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PressToChangeVoicePanel$3
  implements Runnable
{
  PressToChangeVoicePanel$3(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.this$0, true);
    boolean bool = this.this$0.a.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
    }
    if (bool)
    {
      if (this.this$0.a.qh())
      {
        this.this$0.setClickable(false);
        this.this$0.a.zV(2);
      }
      return;
    }
    PressToChangeVoicePanel.b(this.this$0.app, true, "0X8006386");
    if (PressToChangeVoicePanel.GW == null)
    {
      QQToast.a(BaseApplication.getContext(), 2131700594, 0).show();
      return;
    }
    aomq.aqc = SystemClock.uptimeMillis();
    int i = this.this$0.a.a().getTitleBarHeight();
    Object localObject = this.this$0.a.a();
    if (!QQRecorder.aES())
    {
      QQToast.a(BaseApplication.getContext(), 2131719248, 0).show(i);
      label173:
      if (!this.this$0.a.aSf) {
        break label623;
      }
    }
    label623:
    for (i = 1;; i = 2)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005472", "0X8005472", i, 0, "", "", "", "3.4.4");
      if (this.this$0.b == null) {
        break;
      }
      this.this$0.b.G(this.this$0);
      return;
      if (!QQRecorder.mw(((QQRecorder.RecorderParam)localObject).mAudioType))
      {
        QQToast.a(BaseApplication.getContext(), 2131695039, 0).show(i);
        break label173;
      }
      if (this.this$0.app.bF())
      {
        QQToast.a(BaseApplication.getContext(), 2131697385, 0).show();
        break label173;
      }
      if (AudioHelper.isForbidByRubbishMeizu(1))
      {
        ChatActivityUtils.db(this.this$0.a.a());
        break label173;
      }
      this.this$0.cau();
      this.this$0.a.a(this.this$0, false, (QQRecorder.RecorderParam)localObject);
      this.this$0.a.setFateOfRecorder(2);
      this.this$0.b.setStatus(3);
      this.this$0.cav();
      localObject = new Rect();
      Rect localRect = new Rect();
      this.this$0.df.getGlobalVisibleRect(localRect);
      this.this$0.getWindowVisibleDisplayFrame((Rect)localObject);
      localRect = new Rect();
      this.this$0.dg.getGlobalVisibleRect(localRect);
      int j = localRect.bottom;
      if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
      {
        i = j;
        if (Build.MODEL.startsWith("ivvi"))
        {
          i = j;
          if (Build.VERSION.SDK_INT != 22) {}
        }
      }
      else
      {
        i = j - ((Rect)localObject).top;
      }
      if (localRect.top <= this.this$0.getResources().getDisplayMetrics().heightPixels) {
        this.this$0.e = AudioPanel.a(this.this$0.a.a(), ((Rect)localObject).width(), i, this.this$0, 0, 0, 0);
      }
      this.this$0.ws = AudioPanel.a(this.this$0.a.a(), this.this$0.df, this.this$0.dg);
      break label173;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.3
 * JD-Core Version:    0.7.0.1
 */