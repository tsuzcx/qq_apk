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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import wja;

public class DynamicSingleLineLyricView
  extends TextView
  implements aipc, Handler.Callback
{
  protected aiwn a;
  private aiwr jdField_a_of_type_Aiwr;
  Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected long abR;
  private String bPo;
  private SparseArray<aiwr> cO = new SparseArray(4);
  private boolean ckU;
  protected int dej;
  private int dek;
  private int del;
  private WeakReference<aipn> hj;
  protected int mLastWidth;
  private volatile boolean mPaused = true;
  private int mScrollX;
  private int mState = 1;
  private int mStrokeColor;
  private int mStrokeWidth;
  protected Handler mSubHandler;
  protected Handler mUIHandler;
  
  public DynamicSingleLineLyricView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DynamicSingleLineLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void Qa(int paramInt)
  {
    this.mUIHandler.removeMessages(paramInt);
    this.mUIHandler.sendEmptyMessage(paramInt);
  }
  
  private String W(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return acfp.m(2131705355);
    case 1: 
      return acfp.m(2131705356);
    case 2: 
      return "";
    case 3: 
      return acfp.m(2131705354);
    }
    return acfp.m(2131705357);
  }
  
  private int a(aiwp paramaiwp, int paramInt)
  {
    this.ckU = false;
    long l1 = SystemClock.elapsedRealtime() - this.abR;
    long l2 = paramaiwp.mStartTime;
    long l3 = paramaiwp.mDuration;
    if (l1 > l2 + l3)
    {
      this.ckU = false;
      return paramInt;
    }
    int j = ((aiwr)paramaiwp.dj().get(0)).dfA;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int m;
    int i;
    if (j > k)
    {
      this.ckU = true;
      m = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(paramInt + 0.5F * k);
      i = paramInt + m;
      if (m < 0)
      {
        paramInt = i;
        if (i < 0) {
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      return paramInt;
      if (m > 0)
      {
        paramInt = j - k;
        if (i <= paramInt) {
          break label164;
        }
      }
      for (;;)
      {
        break;
        paramInt = this.mScrollX;
        break;
        label164:
        paramInt = i;
      }
      paramInt = 0;
    }
  }
  
  private int a(aiwr paramaiwr)
  {
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    i = paramaiwr.dfA - (i - j - k);
    if ((i >= 0) || (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT)) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return -i;
    }
    return -(int)(0.5F * i);
  }
  
  private void a(aiwn paramaiwn, int paramInt)
  {
    if (paramaiwn == null)
    {
      this.mUIHandler.removeMessages(4);
      paramaiwn = this.mUIHandler.obtainMessage(4, paramInt, 0, paramaiwn);
      this.mUIHandler.sendMessage(paramaiwn);
      return;
    }
    this.mSubHandler.removeMessages(3);
    paramaiwn = this.mSubHandler.obtainMessage(3, paramInt, 0, paramaiwn);
    this.mSubHandler.sendMessage(paramaiwn);
  }
  
  private boolean apl()
  {
    return (this.jdField_a_of_type_Aiwn == null) || (this.jdField_a_of_type_Aiwn.xs == null) || (this.jdField_a_of_type_Aiwn.xs.isEmpty()) || (this.mState != 2);
  }
  
  private int b(aiwr paramaiwr)
  {
    return Math.min(getPaddingLeft() + getPaddingRight() + paramaiwr.dfA, this.del);
  }
  
  private void init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.Lyric", 2, String.format("=======>init", new Object[0]));
    }
    this.mStrokeWidth = wja.dp2px(1.0F, getResources());
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    if (apl()) {
      return b((aiwr)this.cO.get(this.mState));
    }
    if (this.jdField_a_of_type_Aiwr != null) {
      return b(this.jdField_a_of_type_Aiwr);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    int m = 1;
    boolean bool = true;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        bool = false;
        do
        {
          do
          {
            return bool;
            i = getMeasuredWidth();
          } while (this.dej == i);
          if (QLog.isColorLevel()) {
            QLog.i("QQMusicPlay.Lyric", 2, String.format("MSG_SIZE_CHANGE %d", new Object[] { Integer.valueOf(getMeasuredWidth()) }));
          }
          this.mUIHandler.removeMessages(2);
          if (this.hj == null) {}
          for (paramMessage = null;; paramMessage = (aipn)this.hj.get())
          {
            if (paramMessage != null) {
              paramMessage.onSizeChange(getMeasuredWidth(), getMeasuredHeight());
            }
            this.dej = i;
            break;
          }
          localObject = (aiwn)paramMessage.obj;
          i = paramMessage.arg1;
        } while (localObject == null);
        paramMessage = new aiwn(2, 0, null);
        paramMessage.a((aiwn)localObject);
        paramMessage.a(getPaint(), getPaint(), 2147483647, true, false);
        this.mUIHandler.removeMessages(4);
        paramMessage = this.mUIHandler.obtainMessage(4, i, 0, paramMessage);
        this.mUIHandler.sendMessage(paramMessage);
        continue;
        this.jdField_a_of_type_Aiwn = ((aiwn)paramMessage.obj);
        this.mState = paramMessage.arg1;
        this.jdField_a_of_type_Aiwr = null;
        this.mScrollX = 0;
        Qa(5);
      }
    case 5: 
      this.mUIHandler.removeMessages(5);
      this.ckU = false;
      paramMessage = this.jdField_a_of_type_Aiwr;
      if (apl())
      {
        paramMessage = (aiwr)this.cO.get(this.mState);
        j = i;
        if (this.jdField_a_of_type_Aiwr != null) {
          if (this.jdField_a_of_type_Aiwr == paramMessage) {
            break label702;
          }
        }
      }
      break;
    }
    label394:
    label688:
    label695:
    label702:
    for (int j = i;; j = 0)
    {
      this.mScrollX = 0;
      i = 0;
      for (;;)
      {
        label348:
        this.jdField_a_of_type_Aiwr = paramMessage;
        label363:
        long l;
        int k;
        if (j != 0)
        {
          Qa(6);
          if ((this.mPaused) || (apl())) {
            break;
          }
          paramMessage = this.mUIHandler;
          if (!this.ckU) {
            break label637;
          }
          l = 100L;
          paramMessage.sendEmptyMessageDelayed(5, l);
          break;
          if (this.mPaused) {
            break label695;
          }
          i = (int)(SystemClock.elapsedRealtime() - this.abR);
          j = this.jdField_a_of_type_Aiwn.jdMethod_if(i);
          localObject = this.jdField_a_of_type_Aiwn.xs;
          k = ((ArrayList)localObject).size();
          i = j;
          if (j < 0) {
            i = 0;
          }
          j = i;
          if (i >= k) {
            j = k - 1;
          }
          localObject = (aiwp)((ArrayList)localObject).get(j);
          if (((aiwp)localObject).dj().isEmpty()) {
            break label695;
          }
          paramMessage = (aiwr)((aiwp)localObject).dj().get(0);
          k = this.mScrollX;
          if ((this.jdField_a_of_type_Aiwr != null) && ((this.jdField_a_of_type_Aiwr == paramMessage) || (b(this.jdField_a_of_type_Aiwr) == b(paramMessage)))) {
            break label688;
          }
          this.mScrollX = 0;
          i = 1;
        }
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            this.mScrollX = a((aiwp)localObject, this.mScrollX);
            if (this.mScrollX != k)
            {
              k = 1;
              label579:
              if (b(this.jdField_a_of_type_Aiwr) == b(paramMessage)) {
                break label618;
              }
            }
            for (;;)
            {
              k = k | j | m;
              j = i;
              i = k;
              break;
              k = 0;
              break label579;
              label618:
              m = 0;
            }
            if (i == 0) {
              break label363;
            }
            Qa(7);
            break label363;
            label637:
            l = 300L;
            break label394;
            this.mUIHandler.removeMessages(6);
            requestLayout();
            break;
            this.mUIHandler.removeMessages(7);
            invalidate();
            break;
          }
          k = i;
          i = j;
          j = k;
          break label348;
          i = 0;
        }
        j = 0;
        i = 0;
      }
    }
  }
  
  public boolean isPlaying()
  {
    return !this.mPaused;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    aiwr localaiwr = this.jdField_a_of_type_Aiwr;
    if (localaiwr != null)
    {
      if (this.dek == 0) {
        this.dek = FM();
      }
      paramCanvas.save();
      paramCanvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()), getPaddingTop() + (getMeasuredHeight() - getPaddingTop() - getPaddingBottom())));
      int i = getPaddingLeft() - this.mScrollX + a(localaiwr);
      int j = this.dek + getPaddingTop();
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localTextPaint.setStrokeWidth(this.mStrokeWidth);
      int k = getCurrentTextColor();
      localTextPaint.setColor(this.mStrokeColor);
      paramCanvas.drawText(localaiwr.mText, i, j, localTextPaint);
      localTextPaint.setColor(k);
      localTextPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(localaiwr.mText, i, j, localTextPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mLastWidth != getMeasuredWidth())
    {
      this.mLastWidth = getMeasuredWidth();
      Qa(5);
      this.mUIHandler.removeMessages(2);
      this.mUIHandler.sendEmptyMessageDelayed(2, 300L);
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
      Qa(5);
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
    this.abR = (SystemClock.elapsedRealtime() - paramInt + 30L);
    Qa(5);
  }
  
  public void setAlign(Paint.Align paramAlign)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align != paramAlign)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint$Align = paramAlign;
      Qa(7);
    }
  }
  
  public void setLineMaxWidth(int paramInt)
  {
    if (this.del != paramInt)
    {
      this.del = paramInt;
      Qa(6);
    }
  }
  
  public void setLyric(aiwn paramaiwn, int paramInt)
  {
    a(paramaiwn, paramInt);
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
    this.cO.clear();
    TextPaint localTextPaint = getPaint();
    paramInt = 1;
    while (paramInt <= 4)
    {
      Object localObject = W(paramInt);
      int i = (int)(localTextPaint.measureText((String)localObject) + 0.5D);
      localObject = new aiwr((String)localObject, 0, 0, i, i, null);
      this.cO.put(paramInt, localObject);
      paramInt += 1;
    }
    this.dek = 0;
    a(this.jdField_a_of_type_Aiwn, this.mState);
  }
  
  public void start()
  {
    try
    {
      this.mPaused = false;
      Qa(5);
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
      Qa(5);
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
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.DynamicSingleLineLyricView
 * JD-Core Version:    0.7.0.1
 */