package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import anot;
import anpc;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import pky;
import wja;
import xkx.a;

public class PttAudioWaveView
  extends View
{
  boolean EX = false;
  private int MAX_VALUE;
  private int MIN_HEIGHT;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_IN;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a;
  private int aDH;
  private float[] aM = new float[0];
  private int aeh;
  RectF ai = new RectF();
  private int bUe = -1;
  int bUf = c(this.mSelectColor, 0.33F);
  private int bUg;
  private int bUh;
  private int bUi;
  private int bUj;
  private int bUk;
  private int bUl;
  int bUm = 15;
  private int bUn;
  private volatile boolean bhn = true;
  boolean bho = false;
  boolean bhp = false;
  public boolean bhq = false;
  boolean bhr = true;
  boolean bhs = false;
  boolean bht = false;
  boolean bhu = false;
  Bitmap bitmapSrc;
  private Paint bo;
  PorterDuffXfermode jdField_c_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  View.OnLongClickListener jdField_c_of_type_AndroidViewView$OnLongClickListener;
  View.OnClickListener clickListener;
  Bitmap ef;
  Runnable er = new PttAudioWaveView.1(this);
  private int[] hu;
  Canvas j;
  Canvas k;
  private int lineWidth;
  float mDownX = 0.0F;
  float mDownY = 0.0F;
  private int mOffset;
  private int mSelectColor = -1;
  private int mStrokeWidth = 1;
  int paddingBottom;
  int paddingLeft;
  int paddingRight;
  int paddingTop;
  private float progress;
  private float qj;
  private float qk;
  private float ql = 1.5F;
  
  public PttAudioWaveView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PttAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 100)
    {
      int[] arrayOfInt2 = new int[paramInt];
      i = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i >= paramInt) {
          break;
        }
        arrayOfInt2[i] = ((int)(paramArrayOfInt[i] * 0.02480583F));
        if (arrayOfInt2[i] > 255) {
          arrayOfInt2[i] = 255;
        }
        i += 1;
      }
    }
    int[] arrayOfInt1 = new int[100];
    float f3 = paramInt / 100.0F;
    long l1 = 0L;
    int m = 0;
    int n = 0;
    int i = 0;
    float f2;
    for (float f1 = f3; m < paramInt; f1 = f2)
    {
      long l2 = l1 + paramArrayOfInt[m];
      int i2 = i + 1;
      int i1 = n;
      i = i2;
      l1 = l2;
      f2 = f1;
      if (m > f1)
      {
        arrayOfInt1[n] = ((int)((float)l2 / i2 * 0.02480583F));
        if (arrayOfInt1[n] > 255) {
          arrayOfInt1[n] = 255;
        }
        i1 = n + 1;
        f2 = f3 * (i1 + 1);
        i = 0;
        l1 = 0L;
      }
      m += 1;
      n = i1;
    }
    return arrayOfInt1;
  }
  
  private void aC(Canvas paramCanvas)
  {
    this.bo.setStrokeWidth(this.lineWidth);
    if (this.qj > this.bUj) {
      this.qj = this.bUj;
    }
    if (this.qj < this.bUk) {
      this.qj = this.bUk;
    }
    if (this.bhr)
    {
      float f1 = this.qj;
      float f2 = this.qj;
      float f3 = getMeasuredHeight();
      int i = this.bUf;
      int m = this.mSelectColor;
      int n = this.bUf;
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(f1, 0.0F, f2, f3, new int[] { i, m, n }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
      this.bo.setShader((Shader)localObject);
      paramCanvas.drawLine(this.qj, 0.0F, this.qj, getMeasuredHeight(), this.bo);
      this.bo.setShader(null);
    }
  }
  
  public static float b(int paramInt1, int paramInt2, float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramInt1 / paramInt2, 2.0F * paramFloat));
  }
  
  private void b(float paramFloat, int paramInt1, int paramInt2)
  {
    this.progress = ((paramFloat - paramInt1) / (paramInt2 - paramInt1));
  }
  
  public static int c(int paramInt, float paramFloat)
  {
    float f1 = (paramInt >> 16 & 0xFF) / 255.0F;
    float f2 = (paramInt >> 8 & 0xFF) / 255.0F;
    float f3 = (paramInt & 0xFF) / 255.0F;
    paramInt = (int)((paramInt >> 24 & 0xFF) / 255.0F * paramFloat * 255.0F + 0.5F);
    return (int)(f1 * 255.0F + 0.5F) << 16 | paramInt << 24 | (int)(f2 * 255.0F + 0.5F) << 8 | (int)(f3 * 255.0F + 0.5F);
  }
  
  private void cdT()
  {
    int i = 0;
    if ((this.k == null) || (this.bo == null) || (this.aM.length <= 0) || (!this.bht)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PttAudioWaveView", 2, "drawBitMapDesWave mSelectColor=" + Integer.toHexString(this.mSelectColor) + "bitmpt" + this.ef.getHeight() + " " + this.ef.getWidth() + " len" + this.aM.length + " this=" + this);
      }
      this.bht = false;
      this.bo.setStrokeWidth(1.0F);
      this.bo.setColor(this.mSelectColor);
      this.bo.setXfermode(this.jdField_c_of_type_AndroidGraphicsPorterDuffXfermode);
      this.k.drawPaint(this.bo);
      this.bo.setXfermode(null);
      while (i < this.aM.length)
      {
        f(i, this.bUe - this.aM[i] / 2.0F, this.bUe + this.aM[i] / 2.0F);
        i += 1;
      }
    }
  }
  
  private void cdU()
  {
    this.bo.setStrokeWidth(1.0F);
    this.bo.setXfermode(this.jdField_c_of_type_AndroidGraphicsPorterDuffXfermode);
    this.j.drawPaint(this.bo);
    this.bo.setXfermode(null);
    this.ai.set(0.0F, 0.0F, this.qj, getMeasuredHeight());
    this.j.drawRect(this.ai, this.bo);
    this.bo.setAlpha(75);
    this.ai.set(this.qj, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    this.j.drawRect(this.ai, this.bo);
    this.bo.setAlpha(255);
  }
  
  private void init()
  {
    this.bo = new Paint();
    this.bo.setAntiAlias(true);
    this.bo.setColor(this.mSelectColor);
    this.bo.setStrokeWidth(this.mStrokeWidth);
    this.bUg = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.MIN_HEIGHT = wja.dp2px(3.0F, getResources());
    this.MAX_VALUE = this.MIN_HEIGHT;
    this.bUi = (wja.dp2px(3.0F, getResources()) - 1);
    this.lineWidth = wja.dp2px(1.0F, getResources());
    this.bUl = wja.dp2px(174.0F, getResources());
    this.bUn = wja.dp2px(5.0F, getResources());
  }
  
  private void z(View paramView, boolean paramBoolean)
  {
    if ((paramView != null) && (paramView.isPressed() != paramBoolean) && ((xkx.a)paramView.getTag() != null))
    {
      ChatMessage localChatMessage = wja.a(paramView);
      if ((localChatMessage != null) && (localChatMessage.vipBubbleID == 0L)) {
        paramView.setPressed(paramBoolean);
      }
    }
    super.setPressed(paramBoolean);
  }
  
  public void cdS()
  {
    this.bhn = true;
    int m = this.hu.length;
    this.aM = new float[this.hu.length];
    int n = this.aeh;
    int i1 = this.bUh;
    int i = 0;
    float f1;
    float f2;
    if (i < this.aM.length)
    {
      f1 = b(this.hu[i], 255, this.ql);
      if (f1 > 0.9D) {
        f2 = this.MIN_HEIGHT;
      }
      for (f1 = f1 * (this.bUh - this.MIN_HEIGHT) + f2 + (float)Math.sin(6.28D / (m % 4 + 3) * i) * (n - i1);; f1 = f1 * (this.aeh - this.MIN_HEIGHT) + f2)
      {
        if (f1 > this.MAX_VALUE) {
          this.MAX_VALUE = ((int)f1);
        }
        this.aM[i] = f1;
        i += 1;
        break;
        f2 = this.MIN_HEIGHT;
      }
    }
    i = 1;
    while (i < this.aM.length - 1)
    {
      f1 = this.aM[(i - 1)];
      f2 = this.aM[(i + 1)];
      if (f1 * 0.5D > this.aM[i]) {
        this.aM[i] = ((f1 + this.aM[i]) / 2.0F);
      }
      if (f2 * 0.5D > this.aM[i]) {
        this.aM[i] = ((f2 + this.aM[i]) / 2.0F);
      }
      i += 1;
    }
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "destory");
    }
    if ((this.bitmapSrc != null) && (!this.bitmapSrc.isRecycled())) {
      this.bitmapSrc.recycle();
    }
    if ((this.ef != null) && (!this.ef.isRecycled())) {
      this.ef.recycle();
    }
    this.bitmapSrc = null;
    this.ef = null;
  }
  
  protected void f(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = this.aM.length;
    float f2 = (getMeasuredWidth() - this.mStrokeWidth - this.paddingLeft - this.paddingRight) / i;
    float f1 = f2;
    if (f2 > this.bUn) {
      f1 = this.bUn;
    }
    this.qk = f1;
    i = (int)(f1 * paramInt) + this.mStrokeWidth + this.paddingLeft;
    int m = i + this.bUi;
    this.ai.set(i, paramFloat1, m, paramFloat2);
    this.k.drawRect(this.ai, this.bo);
    if (paramInt == this.aM.length - 1) {
      this.bUj = m;
    }
    if (paramInt == 0) {
      this.bUk = i;
    }
    paramInt = (int)(this.bUi / 2.0F);
    this.ai.set(i, paramFloat1 - paramInt + 1.0F, m, paramInt + paramFloat1 + 1.0F);
    this.k.drawArc(this.ai, 180.0F, 180.0F, true, this.bo);
    this.ai.set(i, paramFloat2 - paramInt - 1.0F, m, paramInt + paramFloat2 - 1.0F);
    this.k.drawArc(this.ai, 180.0F, -180.0F, true, this.bo);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.bitmapSrc == null) || (this.bitmapSrc.isRecycled()) || (this.ef == null) || (this.ef.isRecycled())) {
      return;
    }
    cdT();
    int i;
    if ((this.qj > 0.0F) || (this.bhq))
    {
      i = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
      this.bhu = true;
    }
    for (;;)
    {
      this.bo.setXfermode(null);
      this.bo.setColor(this.mSelectColor);
      paramCanvas.drawBitmap(this.ef, 0.0F, 0.0F, this.bo);
      if (this.qj > 0.0F)
      {
        cdU();
        this.bo.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
        paramCanvas.drawBitmap(this.bitmapSrc, 0.0F, 0.0F, this.bo);
        this.bo.setXfermode(null);
      }
      if ((this.qj > 0.0F) || (this.bhq)) {
        aC(paramCanvas);
      }
      if (!this.bhu) {
        break;
      }
      paramCanvas.restoreToCount(i);
      this.bhu = false;
      return;
      paramCanvas.save();
      i = 0;
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "onLayout changed=" + paramBoolean + " left=" + paramInt1 + " top=" + paramInt2 + " right=" + paramInt3 + " bottom=" + paramInt4 + " hasDataConvert=" + this.bhn);
    }
    if ((getMeasuredWidth() <= 0) || (getMeasuredHeight() <= 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.paddingLeft = getPaddingLeft();
      this.paddingTop = getPaddingTop();
      this.paddingRight = getPaddingRight();
      this.paddingBottom = getPaddingBottom();
      this.mOffset = ((this.mOffset + getMeasuredWidth() / 2) / 2 - getMeasuredWidth() / 2);
      if (this.mOffset < 0) {
        this.mOffset = 0;
      }
      this.bUe = (getMeasuredHeight() / 2);
      this.aeh = (getMeasuredHeight() - wja.dp2px(this.bUm, getResources()) * 2);
      if (this.aeh < wja.dp2px(12.0F, getResources())) {
        this.aeh = wja.dp2px(12.0F, getResources());
      }
      this.bitmapSrc = Bitmap.createBitmap(this.bUl + this.paddingLeft + this.paddingRight, getMeasuredHeight() + this.paddingTop + this.paddingBottom, Bitmap.Config.ARGB_8888);
      this.ef = Bitmap.createBitmap(this.bUl + this.paddingLeft + this.paddingRight, getMeasuredHeight() + this.paddingTop + this.paddingBottom, Bitmap.Config.ARGB_8888);
      this.j = new Canvas(this.bitmapSrc);
      this.k = new Canvas(this.ef);
      this.bht = true;
      this.aDH = (this.bUe + this.aeh / 2);
      this.bUh = ((int)(this.aeh * 0.8D));
    } while (this.bhn);
    cdS();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (paramMotionEvent.getAction() == 0)
    {
      this.mDownX = paramMotionEvent.getX();
      this.mDownY = paramMotionEvent.getY();
      if (this.bhs) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.bho = false;
      this.EX = false;
      this.bhq = false;
    }
    do
    {
      do
      {
        do
        {
          try
          {
            z((View)getParent().getParent().getParent(), true);
            getHandler().postDelayed(this.er, 500L);
            bool1 = true;
            return bool1;
          }
          catch (Exception paramMotionEvent)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "onTouchEvent ACTION_DOWN error:" + paramMotionEvent.toString());
              }
            }
          }
          if (paramMotionEvent.getAction() == 2)
          {
            float f1 = Math.abs(paramMotionEvent.getX() - this.mDownX);
            float f2 = Math.abs(paramMotionEvent.getY() - this.mDownY);
            if ((f1 > this.bUg) || (f2 > this.bUg))
            {
              if (this.bhp)
              {
                this.qj = paramMotionEvent.getX();
                invalidate();
                b(paramMotionEvent.getX(), this.bUk, this.bUj);
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a != null) && (!this.bhq))
                {
                  this.bhq = true;
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a.a(this);
                }
              }
              getHandler().removeCallbacks(this.er);
              this.EX = true;
            }
            return true;
          }
          if (paramMotionEvent.getAction() != 1) {
            break;
          }
          getHandler().removeCallbacks(this.er);
          this.bhq = false;
          try
          {
            z((View)getParent().getParent().getParent(), false);
            if ((!this.bho) && (!this.EX))
            {
              if (this.clickListener != null) {
                this.clickListener.onClick(this);
              }
              return true;
            }
          }
          catch (Exception paramMotionEvent)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "ACTION_UP error:" + paramMotionEvent.toString());
              }
            }
            bool1 = bool2;
          }
        } while (this.bho);
        bool1 = bool2;
      } while (!this.bhp);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a.a(this, this.progress);
        anot.a(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
      }
      return true;
      boolean bool1 = bool2;
    } while (paramMotionEvent.getAction() != 3);
    getHandler().removeCallbacks(this.er);
    this.bhq = false;
    return false;
  }
  
  public void setAudioData(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.bhn = false;
    if (QLog.isColorLevel()) {
      QLog.d("PttAudioWaveView", 2, "setAudioData mCenterHeight=" + this.bUe + " data.length" + this.aM.length);
    }
    int m = paramInt1 / wja.dp2px(5.0F, getResources());
    int i = m;
    if (m > 34) {
      i = 34;
    }
    if (i < 3) {}
    for (m = 3;; m = i)
    {
      if (paramArrayOfInt == null)
      {
        this.hu = new int[m];
        paramArrayOfInt = new Random(System.currentTimeMillis());
        paramInt1 = 0;
        while (paramInt1 < m)
        {
          this.hu[paramInt1] = paramArrayOfInt.nextInt(255);
          paramInt1 += 1;
        }
      }
      int[] arrayOfInt = new int[m];
      float f2 = paramArrayOfInt.length / m;
      i = 0;
      long l = 0L;
      int i1 = 0;
      int i4 = 0;
      int i3 = 0;
      int i2 = 255;
      int n = 0;
      float f1 = f2;
      int i5;
      if (n < paramArrayOfInt.length)
      {
        l += paramArrayOfInt[n];
        i5 = i + 1;
        if ((n < f1) && (n != paramArrayOfInt.length - 1)) {
          break label512;
        }
        i = i1 + 1;
        arrayOfInt[i1] = ((int)(l / i5));
        i4 += arrayOfInt[(i - 1)];
        i3 = Math.max(i3, arrayOfInt[(i - 1)]);
        i2 = Math.min(i2, arrayOfInt[(i - 1)]);
        f1 = f2 * (i + 1);
        l = 0L;
        i5 = 0;
        i1 = i;
      }
      label512:
      for (i = i5;; i = i5)
      {
        n += 1;
        break;
        this.hu = arrayOfInt;
        if ((this.aM.length <= 0) && (this.bUe > 0))
        {
          cdS();
          this.bht = true;
        }
        if (new Random().nextInt(1000) == 520)
        {
          paramArrayOfInt = new HashMap();
          paramArrayOfInt.put("voiceLength", String.valueOf(paramInt2));
          paramArrayOfInt.put("waveWidth", String.valueOf(paramInt1));
          paramArrayOfInt.put("waveNum", String.valueOf(m));
          paramArrayOfInt.put("waveMax", String.valueOf(i3));
          paramArrayOfInt.put("waveMin", String.valueOf(i2));
          paramArrayOfInt.put("waveAvg", String.valueOf(i4 / m));
          paramArrayOfInt.put("waveVar", String.valueOf(Math.sqrt(pky.a(arrayOfInt))));
          if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "real do report");
          }
          anpc.a(BaseApplication.getContext()).collectPerformance("", "PttWaveInfo", true, 0L, 0L, paramArrayOfInt, "");
        }
        return;
      }
    }
  }
  
  public void setCanSupportSlide(boolean paramBoolean)
  {
    this.bhp = paramBoolean;
  }
  
  public void setMaxTopBottomPadding(int paramInt)
  {
    this.bUm = paramInt;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void setProgress(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    this.progress = u(f);
    this.qj = (this.bUj * this.progress);
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    if (paramInt != this.mSelectColor)
    {
      this.mSelectColor = paramInt;
      this.bUf = c(this.mSelectColor, 0.33F);
      this.bht = true;
      invalidate();
    }
  }
  
  public void setSeekListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView$a = parama;
  }
  
  public void setShouldDisallowInterceptTouch(boolean paramBoolean)
  {
    this.bhs = paramBoolean;
  }
  
  public void setShowProgressLine(boolean paramBoolean)
  {
    this.bhr = paramBoolean;
  }
  
  public float u(float paramFloat)
  {
    float f = this.qk * this.aM.length;
    paramFloat /= f;
    return (f - (this.qk - this.bUi)) * paramFloat;
  }
  
  public static abstract interface a
  {
    public abstract void a(PttAudioWaveView paramPttAudioWaveView);
    
    public abstract void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioWaveView
 * JD-Core Version:    0.7.0.1
 */