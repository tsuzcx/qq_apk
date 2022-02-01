package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnt;
import aqnt.a;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;
import xkx;

public class SmallPttPlayView
  extends RelativeLayout
  implements View.OnClickListener, aqnt.a, PttAudioWaveView.a
{
  private TextView JR;
  private aqnt a;
  private String audioPath;
  private int bVL;
  private boolean bhq;
  PttAudioWaveView c;
  private int mDuration;
  private float qx;
  
  public SmallPttPlayView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SmallPttPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SmallPttPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void clear()
  {
    this.qx = 0.0F;
    this.c.setProgress(0.0F);
    this.bhq = false;
    cap();
    this.c.setCanSupportSlide(false);
  }
  
  private void init()
  {
    this.c = new PttAudioWaveView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.width = wja.dp2px(120.0F, getContext().getResources());
    localLayoutParams.addRule(15, -1);
    this.c.setVisibility(8);
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
    this.c.setOnClickListener(this);
    this.c.setSeekListener(this);
    this.JR = new TextView(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = wja.dp2px(5.0F, getContext().getResources());
    this.JR.setTextSize(2, 14.0F);
    this.JR.setLayoutParams(localLayoutParams);
    this.JR.setGravity(16);
    addView(this.JR);
    setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("SmallPttPlayView", 2, "init width =" + getMeasuredWidth());
    }
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    this.bhq = true;
    cap();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    int i = (int)(this.mDuration * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("SmallPttPlayView", 2, "onSeekProgressUpdate, offset = " + i);
    }
    onClick(i);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    clear();
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    this.qx = (paramInt2 / paramInt1);
    this.c.setProgress(this.qx);
  }
  
  void cap()
  {
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
    }
    if ((this.c != null) && (!this.bhq) && (Math.abs(this.qx - 0.0F) < 1.0E-008D)) {
      this.c.setCanSupportSlide(false);
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(int paramInt)
  {
    if (this.a == null)
    {
      this.a = new aqnt(this.audioPath, new Handler(), this.bVL);
      this.a.cf(getContext());
      this.a.aFk();
      this.a.a(this);
      this.a.seekTo(paramInt);
      this.a.start();
      this.c.setCanSupportSlide(true);
      return;
    }
    cap();
  }
  
  public void onClick(View paramView)
  {
    onClick((int)(this.qx * this.mDuration));
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    clear();
  }
  
  public void onPause()
  {
    cap();
  }
  
  public void setDuration(int paramInt, String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.mDuration = paramInt;
    int i = paramInt / 1000;
    if (i <= 0)
    {
      this.JR.setText("1\"");
      int j = (int)wja.a((int)this.JR.getPaint().measureText(this.JR.getText().toString()), getContext().getResources());
      i = xkx.a(getContext(), i, 0.0F, j, 5, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("SmallPttPlayView", 2, "setDuration  length=" + i + " duration=" + paramInt + "  param.waveSampleLen" + paramRecorderParam.dZO);
      }
      if (i <= wja.dp2px(121.0F, getContext().getResources())) {
        break label456;
      }
      i = wja.dp2px(121.0F, getContext().getResources());
    }
    label456:
    for (;;)
    {
      this.c.setProgressColor(getContext().getResources().getColorStateList(2131167295).getDefaultColor());
      this.JR.setTextColor(getContext().getResources().getColorStateList(2131167295).getDefaultColor());
      Object localObject = PttAudioWaveView.a(paramRecorderParam.oY, paramRecorderParam.dZO);
      this.c.setAudioData((int[])localObject, i, paramInt / 1000);
      localObject = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject).width = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(5.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(5.0F, getContext().getResources());
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = (i + wja.dp2px(13.0F, getContext().getResources()) + (int)this.JR.getPaint().measureText(this.JR.getText().toString()));
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((VoiceTextEditPanel)getParent().getParent().getParent().getParent().getParent()).updateUI();
      this.audioPath = paramString;
      this.bVL = paramRecorderParam.mAudioType;
      return;
      this.JR.setText(i + "\"");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SmallPttPlayView
 * JD-Core Version:    0.7.0.1
 */