package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;
import wra;
import wra.a;
import wrf;
import wrq;

public class DoodleMsgView
  extends View
{
  private long Is = -1L;
  private int JO;
  private wra.a jdField_a_of_type_Wra$a;
  private wra jdField_a_of_type_Wra;
  private WeakReference<a> ac;
  private Handler bS = new Handler();
  private Bitmap jdField_bd_of_type_AndroidGraphicsBitmap;
  private Paint jdField_bd_of_type_AndroidGraphicsPaint;
  private Paint bn;
  private Canvas i;
  private Timer mTimer;
  private TimerTask mTimerTask;
  private int mViewHeight;
  
  public DoodleMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean av(int paramInt1, int paramInt2)
  {
    bool = true;
    label99:
    try
    {
      if ((this.i != null) && (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)) {
        return true;
      }
    }
    finally {}
    try
    {
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
      {
        wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
        this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      }
      this.i = null;
      this.jdField_bd_of_type_AndroidGraphicsBitmap = wrq.a().e(paramInt1, paramInt2);
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap == null) {
        break label207;
      }
      this.i = new Canvas(this.jdField_bd_of_type_AndroidGraphicsBitmap);
      this.i.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    }
    catch (Exception localException)
    {
      QLog.e("DoodleMsgView", 2, "create bitmapcache execption!" + localException);
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap == null) {
        break label160;
      }
      wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      this.i = null;
      bool = false;
      break label99;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("DoodleMsgView", 2, "create bitmapcache OOM!");
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap == null) {
        break label202;
      }
      wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      this.i = null;
      bool = false;
      break label99;
    }
    return bool;
  }
  
  private void clearCache()
  {
    try
    {
      if (this.jdField_bd_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_bd_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_bd_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.i != null) && (this.jdField_bd_of_type_AndroidGraphicsPaint != null)) {
        this.i.drawPaint(this.jdField_bd_of_type_AndroidGraphicsPaint);
      }
      return;
    }
    finally {}
  }
  
  private void fX(long paramLong)
  {
    if (this.jdField_a_of_type_Wra == null) {
      return;
    }
    long l1 = this.jdField_a_of_type_Wra.eo();
    label34:
    Object localObject;
    TimerTask localTimerTask;
    if (l1 <= 3000L)
    {
      l1 = (int)((float)l1 * 1.0F / 1.2F);
      l1 /= 25L;
      long l2 = this.jdField_a_of_type_Wra.eo();
      this.mTimerTask = new DoodleMsgView.2(this, l2, l2 / (l1 + 1L));
      this.mTimer = new Timer();
      this.Is = 0L;
      localObject = this.mTimer;
      localTimerTask = this.mTimerTask;
      if (paramLong <= 0L) {
        break label180;
      }
    }
    for (;;)
    {
      ((Timer)localObject).schedule(localTimerTask, paramLong, 25L);
      if (this.ac == null) {
        break;
      }
      localObject = (a)this.ac.get();
      if (localObject == null) {
        break;
      }
      ((a)localObject).onPlayStart();
      return;
      if (l1 <= 20000L)
      {
        l1 = (int)((float)l1 * 1.0F / 1.5F);
        break label34;
      }
      l1 = (int)((float)l1 * 1.0F / 1.8F);
      break label34;
      label180:
      paramLong = 0L;
    }
  }
  
  private void fu(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Wra != null) {
      return;
    }
    this.jdField_a_of_type_Wra = new wra();
    this.jdField_a_of_type_Wra$a = new wrf(this);
    this.jdField_a_of_type_Wra.a(this.jdField_a_of_type_Wra$a, 1, paramInt1, paramInt2);
  }
  
  private boolean isPlaying()
  {
    return this.mTimerTask != null;
  }
  
  private void stopTimer()
  {
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
  
  public void a(a parama, int paramInt1, int paramInt2)
  {
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init begin");
    this.ac = new WeakReference(parama);
    this.i = null;
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    fu(paramInt1, paramInt2);
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init end");
  }
  
  public void aGs()
  {
    if (this.jdField_a_of_type_Wra != null) {
      this.jdField_a_of_type_Wra.aGs();
    }
  }
  
  public void clear()
  {
    clearCache();
    invalidate();
  }
  
  public int getDataState()
  {
    if (this.jdField_a_of_type_Wra != null) {
      return this.jdField_a_of_type_Wra.getDataState();
    }
    return 4;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_Wra != null) && (this.jdField_a_of_type_Wra.getDataState() != 0))
    {
      QLog.d("DoodleMsgView", 2, "onDraw not ready");
      return;
    }
    try
    {
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_bd_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.jdField_bd_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_bd_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, this.JO, this.mViewHeight), null);
      }
      return;
    }
    finally {}
  }
  
  public void pause(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wra != null) {
      this.jdField_a_of_type_Wra.pause(paramBoolean);
    }
  }
  
  public void play(long paramLong)
  {
    QLog.d("DoodleMsgView", 2, "play:");
    if ((this.jdField_a_of_type_Wra == null) || (this.jdField_a_of_type_Wra.vX() == 0))
    {
      if (this.ac != null)
      {
        a locala = (a)this.ac.get();
        if (locala != null) {
          locala.buY();
        }
      }
      return;
    }
    if (isPlaying()) {
      stop();
    }
    fX(paramLong);
  }
  
  public void runOnUIThread(Runnable paramRunnable)
  {
    this.bS.post(paramRunnable);
  }
  
  public void setContent(String paramString, boolean paramBoolean)
  {
    QLog.d("DoodleMsgView", 2, "setContent:" + paramString + " prepare:" + paramBoolean);
    if (this.jdField_a_of_type_Wra == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Wra.a(paramString, paramBoolean, getContext()))
        {
          QLog.d("DoodleMsgView", 2, "drawer setdata return true:");
          stopTimer();
          return;
        }
        QLog.d("DoodleMsgView", 2, "drawer setdata same data:" + getDataState());
      } while (this.ac == null);
      paramString = (a)this.ac.get();
    } while (paramString == null);
    paramString.CH(getDataState());
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgView", 2, "stop");
    }
    stopTimer();
    this.Is = -9223372036854775808L;
    if ((this.jdField_a_of_type_Wra != null) && (isShown()))
    {
      this.jdField_a_of_type_Wra.k(2147483647L, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgView", 2, "preparesegments");
      }
    }
    QLog.d("DoodleMsgView", 2, "stop end");
  }
  
  protected void unInit()
  {
    if (this.jdField_a_of_type_Wra != null)
    {
      stop();
      this.jdField_a_of_type_Wra.unInit();
      this.jdField_a_of_type_Wra = null;
    }
    this.jdField_a_of_type_Wra$a = null;
    if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
    {
      wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
    }
    QLog.d("DoodleMsgView", 2, "DoodleMsgView unInit");
  }
  
  static abstract interface a
  {
    public abstract void CH(int paramInt);
    
    public abstract void buY();
    
    public abstract void onPlayStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView
 * JD-Core Version:    0.7.0.1
 */