package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import alid;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aojs;
import aqge;
import aqlv;
import aqul;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.IOException;
import mqq.os.MqqHandler;
import wpi;
import wpp;
import wpq;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, QQRecorder.a, wpi
{
  private TextView Ip;
  private TextView Iq;
  private String TAG = "common record panel";
  private MediaPlayerManager a;
  private QQAppInterface app;
  private QQRecorder b;
  private int bEC;
  private int bQi;
  private int bQj = 180000;
  public Handler bR;
  private boolean beZ = true;
  private VolumeIndicateSquareView d;
  private ViewGroup di;
  private ViewGroup dj;
  private PopupWindow jdField_e_of_type_AndroidWidgetPopupWindow;
  private VolumeIndicateSquareView jdField_e_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  int fateOfRecorder = 0;
  public BaseActivity i;
  private int mAudioType;
  protected double recordTime;
  private ImageView su;
  private Handler uiHandler = new wpp(this, Looper.getMainLooper());
  private View ws;
  
  public CommonRecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonRecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return vl();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler)
  {
    a(paramQQAppInterface, paramBaseActivity, paramHandler, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler, int paramInt)
  {
    a(paramQQAppInterface, paramBaseActivity, paramHandler, paramInt, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.app = paramQQAppInterface;
    this.i = paramBaseActivity;
    this.bR = paramHandler;
    this.mAudioType = paramInt;
    this.a = MediaPlayerManager.a(paramQQAppInterface);
    this.Ip = ((TextView)findViewById(2131373560));
    this.di = ((ViewGroup)findViewById(2131378702));
    this.dj = ((ViewGroup)findViewById(2131369145));
    this.d = ((VolumeIndicateSquareView)findViewById(2131369147));
    this.jdField_e_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131369148));
    this.Iq = ((TextView)findViewById(2131376977));
    this.su = ((ImageView)findViewById(2131376970));
    this.su.setOnClickListener(this);
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new CommonRecordSoundPanel.2(this), 100L);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.uiHandler.post(new CommonRecordSoundPanel.4(this));
    a(paramString, true, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.uiHandler.removeMessages(1);
    if (this.bQi < 1200) {
      this.uiHandler.post(new CommonRecordSoundPanel.10(this, paramString));
    }
    int j;
    do
    {
      return;
      j = getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + j);
      }
      if (j == 102)
      {
        alid.nZ(paramString);
        paramRecorderParam = this.bR.obtainMessage(102);
        paramRecorderParam.obj = paramString;
        this.bR.sendMessage(paramRecorderParam);
        return;
      }
    } while (j != 1);
    alid.Of(paramString);
    this.uiHandler.post(new CommonRecordSoundPanel.11(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    alid.Of(paramString1);
    xA(paramString1);
    this.uiHandler.removeMessages(1);
    this.uiHandler.post(new CommonRecordSoundPanel.9(this));
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    alid.nY(paramString);
    alid.a(paramString, paramRecorderParam, paramRecorderParam.length);
    aqge.ce(2131230758, false);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    alid.a(paramString, paramArrayOfByte, paramInt1);
    if (this.beZ)
    {
      this.beZ = false;
      this.uiHandler.removeMessages(1);
    }
    this.uiHandler.post(new CommonRecordSoundPanel.3(this, paramInt2, paramDouble));
    this.bQi = ((int)paramDouble);
  }
  
  public void afr()
  {
    this.Ip.setVisibility(8);
    this.di.setVisibility(0);
    this.dj.setVisibility(8);
    this.su.setVisibility(0);
  }
  
  public void as(int paramInt) {}
  
  public void at(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void b(QQRecorder.a parama)
  {
    if (this.uiHandler != null)
    {
      if (this.uiHandler.hasMessages(16711688)) {
        this.uiHandler.removeMessages(16711688);
      }
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
    }
    this.i.getWindow().addFlags(128);
    setRequestedOrientation4Recording(false);
    this.a.stop(true);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    ((Intent)localObject).setPackage(this.app.getApp().getPackageName());
    this.app.getApp().sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startRecord() is called");
    }
    if (this.b == null) {
      this.b = new QQRecorder(this.i);
    }
    String str;
    if (this.mAudioType == 0)
    {
      localObject = new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
      str = aojs.a(this.app.getCurrentAccountUin(), null, 2, null);
    }
    for (;;)
    {
      str = aqul.getSDKPrivatePath(str);
      File localFile = new File(str);
      localFile.getParentFile().mkdirs();
      try
      {
        localFile.createNewFile();
        this.b.b((QQRecorder.RecorderParam)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("QQRecorder", 2, "path: " + str);
        }
        this.b.a(parama);
        aqge.m(this.i, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
        }
        this.b.start(str);
        return;
        localObject = new QQRecorder.RecorderParam(aqlv.dZR, 16000, 1);
        str = aojs.a(this.app.getCurrentAccountUin(), null, 25, null);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOAudioPanel", 2, "recorderInit, createNewFile cause exception", localIOException);
          }
        }
      }
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public int bz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.bQi = 0;
    this.bR.sendEmptyMessage(3);
    this.uiHandler.post(new CommonRecordSoundPanel.7(this));
    this.uiHandler.removeMessages(1);
    this.uiHandler.sendEmptyMessageDelayed(1, 2000L);
    this.beZ = true;
    return 250;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.uiHandler.post(new CommonRecordSoundPanel.8(this));
  }
  
  public int getFateOfRecorder()
  {
    return this.fateOfRecorder;
  }
  
  public void hB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public boolean isRecording()
  {
    return (this.b != null) && (this.b.isRecording());
  }
  
  public void jd(int paramInt)
  {
    paramInt /= 1180;
    this.d.CB(paramInt);
    this.jdField_e_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.CB(paramInt);
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = false;
    boolean bool2 = isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      zV(102);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    boolean bool2;
    boolean bool1;
    if (j == 2131376970)
    {
      bool2 = isRecording();
      if ((Build.VERSION.SDK_INT < 23) || (this.i == null)) {
        break label388;
      }
      if (this.i.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        break label124;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool2 + " hasPermission is:" + bool1);
      }
      if (bool2) {
        zV(102);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label124:
        bool1 = false;
        break;
        if ((bool1) || (this.i == null)) {
          break label175;
        }
        this.i.requestPermissions(new wpq(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
        zV(102);
      }
      label175:
      bool1 = Environment.getExternalStorageState().equals("mounted");
      if (this.i != null)
      {
        j = this.i.getTitleBarHeight();
        if (!bool1) {
          break label370;
        }
        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
          break label352;
        }
        if (!this.app.bF()) {
          break label287;
        }
        QQToast.a(BaseApplication.getContext(), 2131697385, 0).show();
      }
      for (;;)
      {
        anot.a(this.app, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
        break;
        label287:
        if (AudioHelper.isForbidByRubbishMeizu(1))
        {
          ChatActivityUtils.db(this.i);
        }
        else
        {
          this.su.setImageResource(2130845668);
          this.su.setContentDescription(acfp.m(2131704240));
          b(this);
          setFateOfRecorder(102);
          getWindowVisibleDisplayFrame(new Rect());
          continue;
          label352:
          QQToast.a(BaseApplication.getContext(), 2131719248, 0).show(j);
          continue;
          label370:
          QQToast.a(BaseApplication.getContext(), 2131696377, 0).show(j);
        }
      }
      label388:
      bool1 = true;
    }
  }
  
  public void onDestroy()
  {
    boolean bool = isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool) {
      zV(1);
    }
  }
  
  public void onPause()
  {
    boolean bool = isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      zV(102);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return isRecording();
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    this.Ip.setVisibility(0);
    this.di.setVisibility(8);
    this.dj.setVisibility(8);
    this.su.setVisibility(0);
    this.su.setImageResource(2130845670);
    this.su.setContentDescription(acfp.m(2131704239));
    this.Iq.setText(AudioPanel.a(0.0D));
    if ((this.jdField_e_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_e_of_type_AndroidWidgetPopupWindow.isShowing())) {}
    try
    {
      this.jdField_e_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_e_of_type_AndroidWidgetPopupWindow = null;
      if (this.ws != null)
      {
        if (this.ws.getParent() != null) {
          ((ViewGroup)this.ws.getParent()).removeView(this.ws);
        }
        this.ws = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
        }
      }
    }
  }
  
  public void setFateOfRecorder(int paramInt)
  {
    this.fateOfRecorder = paramInt;
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    int j = 0;
    int k = 1;
    if (!paramBoolean)
    {
      this.bEC = this.i.getRequestedOrientation();
      int m = getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.isrFroyo()) {
        if (m == 1)
        {
          localObject = this.i;
          j = k;
          if (VersionUtils.isGingerBread()) {
            j = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(j);
        }
      }
      label66:
      do
      {
        do
        {
          do
          {
            break label66;
            do
            {
              return;
            } while (m != 2);
            localObject = this.i;
            if (VersionUtils.isGingerBread()) {}
            for (j = 6;; j = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(j);
              return;
            }
            if (VersionUtils.isHoneycombMR2())
            {
              localObject = this.i.getWindowManager().getDefaultDisplay();
              k = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((k == 0) || (k == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (k != 0) {}
                }
              }
              for (;;)
              {
                this.i.setRequestedOrientation(j);
                return;
                j = 8;
                continue;
                if (k == 0)
                {
                  j = 1;
                }
                else
                {
                  j = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (k != 1) {
                      j = 8;
                    }
                  }
                  else if (k == 1) {
                    j = 9;
                  } else {
                    j = 1;
                  }
                }
              }
            }
            j = this.i.getWindowManager().getDefaultDisplay().getRotation();
            if ((j != 0) && (j != 1)) {
              break;
            }
            if (m == 1)
            {
              this.i.setRequestedOrientation(1);
              return;
            }
          } while (m != 2);
          this.i.setRequestedOrientation(0);
          return;
        } while ((j != 2) && (j != 3));
        if (m == 1)
        {
          this.i.setRequestedOrientation(9);
          return;
        }
      } while (m != 2);
      this.i.setRequestedOrientation(8);
      return;
    }
    this.i.setRequestedOrientation(this.bEC);
  }
  
  public void setTimeOutTime(int paramInt)
  {
    this.bQj = paramInt;
  }
  
  public void startRecord()
  {
    if ((this.d != null) && (this.jdField_e_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView != null))
    {
      this.d.reset();
      this.jdField_e_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.reset();
    }
    this.Ip.setVisibility(8);
    this.di.setVisibility(8);
    this.dj.setVisibility(0);
    this.su.setVisibility(0);
  }
  
  public double v()
  {
    return this.recordTime;
  }
  
  public int vl()
  {
    this.bQj -= 200;
    this.uiHandler.sendEmptyMessageDelayed(16711687, this.bQj);
    return this.bQj + 200;
  }
  
  public void xA(String paramString)
  {
    this.i.runOnUiThread(new CommonRecordSoundPanel.5(this));
  }
  
  public void xB(String paramString)
  {
    setRequestedOrientation4Recording(true);
    this.i.getWindow().clearFlags(128);
  }
  
  public void zV(int paramInt)
  {
    if ((this.b != null) && (!this.b.isStop()) && (!this.uiHandler.hasMessages(16711686)))
    {
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.fateOfRecorder = paramInt;
      if (this.b != null)
      {
        Message localMessage = this.uiHandler.obtainMessage(16711686);
        this.uiHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */