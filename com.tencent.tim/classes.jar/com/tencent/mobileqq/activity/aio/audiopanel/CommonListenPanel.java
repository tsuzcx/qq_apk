package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqnt;
import aqnt.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wpi;

public class CommonListenPanel
  extends RelativeLayout
  implements View.OnClickListener, aqnt.a, wpi
{
  public static int bQf = 1;
  public static int bQg = bQf + 1;
  private TextView Io;
  private aqnt a;
  private QQAppInterface app;
  private String audioPath;
  private CircleProgressView b;
  private int bQe;
  private int bQh = bQf;
  Handler bR;
  private boolean beY;
  private double by;
  private BaseActivity h;
  
  public CommonListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    this.b.setProgress(0);
    this.b.setImageResource(2130845666);
    this.b.setContentDescription(acfp.m(2131704223));
    cap();
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.b.setProgress(paramInt1);
      this.Io.setText(AudioPanel.a(paramInt2));
      return;
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
  }
  
  void cap()
  {
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.audioPath);
    }
    cap();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370579) {
      if (!this.beY)
      {
        this.beY = true;
        QQAppInterface localQQAppInterface = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.bQh == bQg)
        {
          i = 1;
          anot.a(localQQAppInterface, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.bQh);
          }
          this.bR.sendEmptyMessage(103);
        }
      }
      else
      {
        if (this.a != null) {
          break label228;
        }
        this.a = new aqnt(this.audioPath, new Handler(), 1);
        this.a.cf(getContext());
        this.a.aFk();
        this.a.a(this);
        this.a.start();
        this.b.setImageResource(2130845668);
        this.b.setContentDescription(acfp.m(2131704219));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      label228:
      cap();
      this.Io.setText(AudioPanel.a(this.by));
      this.b.setProgress(0);
      this.b.setImageResource(2130845666);
      this.b.setContentDescription(acfp.m(2131704220));
      continue;
      if (i == 2131370578)
      {
        cap();
        if (this.bQe == 2)
        {
          setVisibility(8);
          this.bR.sendEmptyMessage(101);
        }
      }
      else if (i == 2131370581)
      {
        cap();
        if (this.by < 1000.0D)
        {
          QQToast.a(this.h, this.h.getString(2131700689), 0).show();
        }
        else if (this.bQe == 2)
        {
          setVisibility(8);
          this.bR.sendEmptyMessage(102);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.audioPath);
    }
    cap();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.audioPath);
    }
    if (this.a != null)
    {
      cap();
      this.Io.setText(AudioPanel.a(this.by));
      this.b.setProgress(0);
      this.b.setImageResource(2130845666);
      this.b.setContentDescription(acfp.m(2131704222));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble)
  {
    this.audioPath = paramString;
    this.by = paramDouble;
    this.Io.setText(AudioPanel.a(paramDouble));
    this.b.setProgress(0);
    this.b.setImageResource(2130845666);
    this.b.setContentDescription(acfp.m(2131704221));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.bQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel
 * JD-Core Version:    0.7.0.1
 */