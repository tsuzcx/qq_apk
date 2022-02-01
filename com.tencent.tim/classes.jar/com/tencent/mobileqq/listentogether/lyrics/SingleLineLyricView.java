package com.tencent.mobileqq.listentogether.lyrics;

import acfp;
import aipc;
import aipn;
import aiwn;
import aiwp;
import aiwr;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import wja;

public class SingleLineLyricView
  extends TextView
  implements aipc, Handler.Callback
{
  protected aiwn a;
  private aiwr jdField_a_of_type_Aiwr;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected volatile long abR;
  private String bPo;
  private SparseArray<aiwr> cO = new SparseArray(4);
  private boolean ckU;
  private volatile int deK;
  private volatile int deL;
  private int dek;
  private int del;
  private WeakReference<aipn> hj;
  protected int mLastWidth;
  private volatile boolean mPaused = true;
  private int mScrollX;
  private int mState = 1;
  private int mStrokeColor;
  private int mStrokeWidth;
  protected Handler mUIHandler;
  
  public SingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int FM()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i) * 0.5F - localFontMetrics.ascent);
  }
  
  private String W(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return acfp.m(2131714617);
    case 1: 
      return acfp.m(2131714620);
    case 2: 
      return "";
    case 3: 
      return acfp.m(2131714619);
    }
    return acfp.m(2131714618);
  }
  
  private int a(aiwr paramaiwr)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramaiwr.dfy * 2;
    }
    return paramaiwr.dfy;
  }
  
  private void a(Canvas paramCanvas, aiwr paramaiwr)
  {
    this.jdField_a_of_type_Aiwr = paramaiwr;
    paramCanvas.save();
    paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
    int i = getPaddingLeft() - this.mScrollX + a(paramaiwr);
    if (this.dek == 0) {
      this.dek = FM();
    }
    int j = this.dek + getPaddingTop();
    TextPaint localTextPaint = getPaint();
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localTextPaint.setStrokeWidth(this.mStrokeWidth);
    int k = getCurrentTextColor();
    localTextPaint.setColor(this.mStrokeColor);
    paramCanvas.drawText(paramaiwr.mText, i, j, localTextPaint);
    localTextPaint.setColor(k);
    localTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(paramaiwr.mText, i, j, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(aiwp paramaiwp)
  {
    boolean bool = false;
    long l1 = SystemClock.elapsedRealtime() - this.abR;
    long l2 = paramaiwp.mStartTime;
    long l3 = paramaiwp.mDuration;
    if (l1 > l2 + l3) {
      return false;
    }
    int j = ((aiwr)paramaiwp.dj().get(0)).dfA;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int m;
    int i;
    if (j > k)
    {
      m = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(this.mScrollX + 0.5F * k);
      i = this.mScrollX + m;
      if (m < 0)
      {
        if (i >= 0) {
          break label172;
        }
        i = 0;
        bool = true;
      }
    }
    for (;;)
    {
      this.mScrollX = i;
      return bool;
      if (m > 0)
      {
        j -= k;
        if (i <= j) {
          break label169;
        }
        i = j;
      }
      label169:
      for (;;)
      {
        bool = true;
        break;
        i = this.mScrollX;
        bool = true;
        break;
      }
      label172:
      bool = true;
      continue;
      i = 0;
    }
  }
  
  private boolean apl()
  {
    return (this.jdField_a_of_type_Aiwn == null) || (this.jdField_a_of_type_Aiwn.xs == null) || (this.jdField_a_of_type_Aiwn.xs.isEmpty()) || (this.mState != 2);
  }
  
  private void doRefresh()
  {
    this.mUIHandler.removeMessages(0);
    this.mUIHandler.sendEmptyMessage(0);
  }
  
  private void dtC()
  {
    this.cO.clear();
    TextPaint localTextPaint = getPaint();
    int i = 1;
    while (i <= 4)
    {
      Object localObject = W(i);
      int j = (int)(localTextPaint.measureText((String)localObject) + 0.5D);
      localObject = new aiwr((String)localObject, 0, 0, j, j, null);
      this.cO.put(i, localObject);
      i += 1;
    }
  }
  
  private void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.mStrokeWidth = wja.dp2px(1.0F, getResources());
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    if ((this.mState == 2) || (this.cO.get(this.mState) == null)) {
      return getPaddingLeft() + getPaddingRight() + this.del;
    }
    return ((aiwr)this.cO.get(this.mState)).dfA + getPaddingLeft() + getPaddingRight();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.mUIHandler.removeMessages(0);
      if ((!this.mPaused) && (!apl()))
      {
        paramMessage = this.mUIHandler;
        if (!this.ckU) {
          break label99;
        }
      }
      label99:
      for (long l = 200L;; l = 500L)
      {
        paramMessage.sendEmptyMessageDelayed(0, l);
        if ((apl()) && (this.jdField_a_of_type_Aiwr != null)) {
          break;
        }
        invalidate();
        return false;
      }
      this.mUIHandler.removeMessages(1);
      requestLayout();
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE", new Object[0]));
      }
      this.mUIHandler.removeMessages(2);
      if (this.hj == null) {}
      for (paramMessage = null; paramMessage != null; paramMessage = (aipn)this.hj.get())
      {
        paramMessage.onSizeChange(getMeasuredWidth(), getMeasuredHeight());
        return false;
      }
    }
  }
  
  public boolean isPlaying()
  {
    return !this.mPaused;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.ckU = false;
    Object localObject;
    if (apl())
    {
      localObject = (aiwr)this.cO.get(this.mState);
      this.mScrollX = 0;
    }
    for (;;)
    {
      if (localObject != null) {
        a(paramCanvas, (aiwr)localObject);
      }
      aiwp localaiwp;
      do
      {
        return;
        if (this.mPaused)
        {
          localObject = this.jdField_a_of_type_Aiwr;
          break;
        }
        int i = (int)(SystemClock.elapsedRealtime() - this.abR);
        this.deK = i;
        int j = this.jdField_a_of_type_Aiwn.jdMethod_if(i);
        localObject = this.jdField_a_of_type_Aiwn.xs;
        int k = ((ArrayList)localObject).size();
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = i;
        if (i >= k) {
          j = k - 1;
        }
        this.deL = j;
        localaiwp = (aiwp)((ArrayList)localObject).get(j);
      } while (localaiwp.dj().isEmpty());
      localObject = (aiwr)localaiwp.dj().get(0);
      this.ckU = a(localaiwp);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mLastWidth != getMeasuredWidth())
    {
      this.mLastWidth = getMeasuredWidth();
      this.mUIHandler.removeMessages(2);
      this.mUIHandler.sendEmptyMessageDelayed(2, 300L);
      if (this.jdField_a_of_type_Aiwn != null)
      {
        paramInt1 = getMeasuredWidth();
        paramInt2 = getPaddingRight();
        paramInt3 = getPaddingLeft();
        this.jdField_a_of_type_Aiwn.a(getPaint(), getPaint(), paramInt1 - paramInt2 - paramInt3, true, false);
      }
      this.dek = 0;
      this.jdField_a_of_type_Aiwr = null;
      this.mScrollX = 0;
      doRefresh();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("onLayout w=%d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getSuggestedMinimumWidth(), View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void pause()
  {
    try
    {
      this.mPaused = true;
      doRefresh();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seek(int paramInt)
  {
    this.abR = (SystemClock.elapsedRealtime() - paramInt);
    doRefresh();
  }
  
  public void setAlign(Paint.Align paramAlign)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align != paramAlign)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint$Align = paramAlign;
      doRefresh();
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    this.del = paramInt;
    requestLayout();
  }
  
  public void setLyric(aiwn paramaiwn, int paramInt)
  {
    aiwn localaiwn;
    if (paramaiwn != null)
    {
      localaiwn = new aiwn(2, 0, null);
      localaiwn.a(paramaiwn);
    }
    for (this.jdField_a_of_type_Aiwn = localaiwn;; this.jdField_a_of_type_Aiwn = null)
    {
      this.mState = paramInt;
      this.mLastWidth = -1;
      this.jdField_a_of_type_Aiwr = null;
      this.mUIHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public void setOnSizeChangeListener(aipn paramaipn)
  {
    if (paramaipn == null)
    {
      this.hj = null;
      return;
    }
    this.hj = new WeakReference(paramaipn);
  }
  
  public void setSongId(String paramString)
  {
    this.bPo = paramString;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.mStrokeColor = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    dtC();
    this.mLastWidth = -1;
    this.mUIHandler.sendEmptyMessage(1);
  }
  
  public void start()
  {
    try
    {
      this.mPaused = false;
      doRefresh();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void stop()
  {
    try
    {
      this.mPaused = true;
      doRefresh();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String wZ()
  {
    return this.bPo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.SingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */