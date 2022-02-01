package com.tencent.mobileqq.activity.richmedia.subtitles;

import aatg;
import aath;
import aath.a;
import aatn;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import anot;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import wre;

public class SubtitleLayout
  extends RelativeLayout
  implements aath.a
{
  private long MC = -1L;
  private long MD;
  private long Mv = -1L;
  private aatn a;
  private boolean bzA;
  private boolean bzo;
  private boolean bzy;
  private boolean bzz;
  public int ckC = 0;
  private int ckD = 0;
  private Handler co;
  private Handler mHandler;
  private int mMode = 0;
  private boolean mPause;
  private Random mRandom;
  private Timer mTimer;
  private TimerTask mTimerTask;
  
  public SubtitleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  private void Gy(int paramInt)
  {
    if (!this.bzy) {
      return;
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    this.mHandler.postDelayed(new SubtitleLayout.2(this), paramInt);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "startTranslator, mode:" + this.mMode + " type:" + paramInt + " stropfirst:" + paramBoolean1 + " recordmode:" + paramBoolean2 + " resumecapture:" + paramBoolean3);
    }
    if ((this.mMode != 0) || (paramInt == 0)) {
      return;
    }
    if (paramBoolean1) {
      aath.a().bn(false, false);
    }
    switch (paramInt)
    {
    default: 
      aath.a().a(this, true, paramBoolean2, paramBoolean3);
      return;
    case 1: 
    case 2: 
      aath.a().a(this, false, paramBoolean2, paramBoolean3);
      return;
    }
    aath.a().a(this, true, paramBoolean2, paramBoolean3);
  }
  
  private void cvi()
  {
    if (this.co != null)
    {
      this.co.removeCallbacksAndMessages(null);
      this.co = null;
      this.bzz = false;
    }
  }
  
  private void cyF()
  {
    if (this.co != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "count timer exist.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "start countdown timer.");
    }
    this.bzz = false;
    this.co = new Handler(Looper.getMainLooper());
    this.co.postDelayed(new SubtitleLayout.1(this), 180000L);
  }
  
  private void cyG()
  {
    try
    {
      if ((this.mTimer == null) || (this.mTimerTask == null))
      {
        if ((!this.mPause) || (this.Mv == -1L)) {
          this.Mv = 0L;
        }
        startTimer();
      }
      return;
    }
    finally {}
  }
  
  private void startPreview()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "startDemo begin");
    }
    if (this.a == null) {}
    while (this.bzy) {
      return;
    }
    if (this.mRandom == null) {
      this.mRandom = new Random();
    }
    this.bzy = true;
    Gy(0);
  }
  
  /* Error */
  private void startTimer()
  {
    // Byte code:
    //   0: ldc 106
    //   2: iconst_2
    //   3: ldc 190
    //   5: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 176	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimerTask	Ljava/util/TimerTask;
    //   14: ifnonnull +15 -> 29
    //   17: aload_0
    //   18: new 192	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout$3
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 193	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout$3:<init>	(Lcom/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout;)V
    //   26: putfield 176	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimerTask	Ljava/util/TimerTask;
    //   29: aload_0
    //   30: getfield 174	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimer	Ljava/util/Timer;
    //   33: ifnonnull +14 -> 47
    //   36: aload_0
    //   37: new 195	java/util/Timer
    //   40: dup
    //   41: invokespecial 196	java/util/Timer:<init>	()V
    //   44: putfield 174	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimer	Ljava/util/Timer;
    //   47: aload_0
    //   48: getfield 174	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimer	Ljava/util/Timer;
    //   51: aload_0
    //   52: getfield 176	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:mTimerTask	Ljava/util/TimerTask;
    //   55: lconst_0
    //   56: ldc2_w 197
    //   59: invokevirtual 202	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   62: invokestatic 205	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   65: invokestatic 66	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   68: if_acmpne +10 -> 78
    //   71: aload_0
    //   72: invokevirtual 208	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:invalidate	()V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: invokevirtual 211	com/tencent/mobileqq/activity/richmedia/subtitles/SubtitleLayout:postInvalidate	()V
    //   82: goto -7 -> 75
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	SubtitleLayout
    //   85	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	29	85	finally
    //   29	47	85	finally
    //   47	75	85	finally
    //   75	77	85	finally
    //   78	82	85	finally
    //   86	88	85	finally
  }
  
  private void stopPreview()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "stopDemo begin");
    }
    if (!this.bzy) {
      return;
    }
    this.bzy = false;
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mRandom = null;
  }
  
  private void stopTimer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "StopTimer begin");
    }
    try
    {
      if (this.mTimerTask != null)
      {
        this.mTimerTask.cancel();
        this.mTimerTask = null;
      }
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("SubtitleLayout", 2, "setAnimText:" + paramString1 + " " + paramString2);
    try
    {
      if ((this.a == null) || (this.mMode != 0) || (this.ckC == 0)) {
        return;
      }
      if ((this.bzy) && ((!this.bzz) || (this.bzA)))
      {
        stopPreview();
        clear();
        if ((this.bzA) && (this.a != null))
        {
          this.a.reset();
          this.a.setState(3);
          this.MC = 0L;
        }
      }
      if (this.bzo)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.MD;
        HashMap localHashMap = new HashMap();
        localHashMap.put("pressStartTransCost", String.valueOf(l1 - l2));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubtitlePressTranslate", true, 0L, 0L, localHashMap, null);
        this.bzo = false;
      }
      this.a.b(paramLong1, paramLong2, paramString1, paramString2, paramBoolean);
      cyG();
      return;
    }
    finally {}
  }
  
  public void aq(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4)) {
      return;
    }
    int i = paramArrayOfByte.length;
    setAnimType(wre.bytesToInt(paramArrayOfByte, 0), null, paramArrayOfByte, 4, i - 4);
  }
  
  public void clear()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "clear begin");
    }
    try
    {
      if (this.a != null) {
        this.a.clear();
      }
      return;
    }
    finally {}
  }
  
  public void destroy()
  {
    try
    {
      if (this.a != null)
      {
        this.a.unInit();
        this.a = null;
      }
      this.bzy = false;
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
      }
      cvi();
      this.mRandom = null;
      return;
    }
    finally {}
  }
  
  public void init(int paramInt)
  {
    this.mMode = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "init, mode:" + this.mMode);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (this.a != null)
      {
        this.Mv = this.a.a(paramCanvas, null, -1L);
        int i = 10;
        while ((this.mMode != 0) && (this.Mv < this.MC) && (this.Mv != -1L) && (this.Mv != -2L) && (i > 0))
        {
          this.Mv = this.a.a(paramCanvas, null, -1L);
          i -= 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public void pause()
  {
    if (this.ckC == 0) {
      return;
    }
    this.mPause = true;
    stopTimer();
    try
    {
      if (this.a != null) {
        this.a.pause(true);
      }
      if (this.mMode == 0)
      {
        aath.a().bn(true, false);
        cvi();
        stopPreview();
      }
      this.MC = 0L;
      return;
    }
    finally {}
  }
  
  public void resume()
  {
    if (this.ckC == 0) {}
    for (;;)
    {
      return;
      this.mPause = false;
      try
      {
        if (this.a != null) {
          this.a.pause(false);
        }
        cyG();
        if ((this.mMode != 0) || (this.bzA)) {
          continue;
        }
        startPreview();
        cyF();
        b(this.ckC, false, false, true);
        return;
      }
      finally {}
    }
  }
  
  public void setAnimType(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "setAnimTye, type:" + paramInt1 + " font:" + paramString);
    }
    if ((this.ckC == paramInt1) && (this.mMode == 0)) {
      if (this.ckC != 0)
      {
        startPreview();
        cyG();
      }
    }
    do
    {
      return;
      clear();
      this.ckC = paramInt1;
      if ((this.ckC == 0) && (this.mMode == 0))
      {
        aath.a().bn(true, false);
        cvi();
      }
      if (this.a != null)
      {
        this.a.unInit();
        this.a = null;
      }
      this.a = aatg.a(this.ckC);
    } while (this.a == null);
    if (this.mMode == 0)
    {
      paramInt1 = getWidth();
      paramInt2 = getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("SubtitleLayout", 2, "subtitlelayout width:" + paramInt1 + " height:" + paramInt2);
      }
      this.a.a(getContext(), paramInt1, paramInt2, 30, false, paramString);
      this.a.setState(this.ckD);
      stopPreview();
      clear();
      startPreview();
      cyG();
      b(this.ckC, false, false, true);
      cyF();
      return;
    }
    this.a.a(getContext(), -1.0F, -1.0F, -1, paramArrayOfByte, paramInt2, paramInt3, true);
  }
  
  public void setState(int paramInt)
  {
    try
    {
      if (this.a != null) {
        this.a.setState(paramInt);
      }
      this.ckD = paramInt;
      return;
    }
    finally {}
  }
  
  public void setTimeStamp(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.MC = (paramLong / 30L);
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "start ,mode:" + this.mMode);
    }
    if (this.mMode == 0)
    {
      anot.a(null, "dc00898", "", "", "0X8008758", "0X8008758", 0, 0, "", "", "", "");
      if (this.bzy) {
        stopPreview();
      }
      clear();
      startPreview();
      cyG();
      this.bzA = true;
      b(this.ckC, true, true, true);
      cvi();
    }
    for (;;)
    {
      this.MD = System.currentTimeMillis();
      this.bzo = true;
      return;
      this.mPause = false;
      cyG();
      try
      {
        if (this.a != null)
        {
          this.a.reset();
          this.a.setState(3);
          this.MC = 0L;
        }
      }
      finally {}
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleLayout", 2, "Stop, mode:" + this.mMode);
    }
    this.mPause = false;
    stopTimer();
    this.MC = 0L;
    if (this.mMode == 0)
    {
      this.bzA = false;
      aath.a().bn(false, false);
      stopPreview();
      setState(this.ckD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout
 * JD-Core Version:    0.7.0.1
 */