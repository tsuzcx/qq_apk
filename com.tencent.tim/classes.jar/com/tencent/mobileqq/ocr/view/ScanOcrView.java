package com.tencent.mobileqq.ocr.view;

import akos;
import akot;
import akou;
import akov;
import akow;
import akox;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScanOcrView
  extends View
{
  public boolean SD;
  public a a;
  AnimatorSet ar;
  AnimatorSet as;
  a b;
  int bSZ;
  a c;
  int cVk;
  public boolean ctx = false;
  boolean cty = false;
  int dom;
  int don;
  int doo;
  int dop;
  int doq = 1;
  Drawable dt;
  Drawable ff;
  Drawable fg;
  Context mContext;
  int mCoverHeight;
  Handler mHandler = new akos(this);
  int mHeight;
  long mLastTime;
  int mLineHeight;
  Paint mPaint;
  int mWidth;
  int paddingBottom;
  int paddingLeft;
  int paddingRight;
  int paddingTop;
  
  public ScanOcrView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ScanOcrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  @TargetApi(12)
  private void Si(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "realPlayScanRectAnimation, hasDoneCnt=" + paramInt + ",mScanRectPlaying=" + this.ctx + ",mPlaying=" + this.SD);
    }
    if (paramInt == 2) {
      return;
    }
    this.c = this.a;
    this.a = a(paramInt, this.c);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    localValueAnimator1.addUpdateListener(new akot(this));
    localValueAnimator1.setDuration(200L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator2.addUpdateListener(new akou(this));
    localValueAnimator2.setDuration(200L);
    localValueAnimator2.addListener(new akov(this, paramInt));
    int i = this.a.dov;
    if (paramInt == 0) {
      i = this.a.dou;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.ar = localAnimatorSet;
    localAnimatorSet.setStartDelay(i);
    localAnimatorSet.start();
    invalidate();
  }
  
  private a a()
  {
    int i = dp2px(200.0F, getResources());
    int j = dp2px(200.0F, getResources());
    int m = this.don;
    int k = this.dop;
    m /= 2;
    k /= 2;
    Rect localRect = new Rect();
    localRect.left = (m - i / 2);
    localRect.top = (k - j / 2);
    localRect.right = (localRect.left + i);
    localRect.bottom = (localRect.top + j);
    a locala = new a();
    locala.ck = localRect;
    locala.dos = i;
    locala.dot = j;
    locala.cl = new Rect(localRect);
    locala.dow = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "generateScanRectHoldAniParam, \n" + locala);
    }
    return locala;
  }
  
  private a a(int paramInt, a parama)
  {
    int i = dp2px(200.0F, getResources());
    int j = dp2px(100.0F, getResources());
    Object localObject1 = new Random();
    int k = j + ((Random)localObject1).nextInt(i) % (i - j + 1);
    int m = this.don;
    int n = this.dop;
    int i1 = (int)(m * 0.3F + this.paddingLeft + 0.5F);
    int i3 = (int)(n * 0.3F + this.paddingTop + 0.5F);
    int i2 = (int)(i1 + m * 0.4F + 0.5F);
    int i4 = (int)(i3 + n * 0.4F + 0.5F);
    Object localObject2 = new ArrayList();
    i = 0;
    while (i < 2)
    {
      ((List)localObject2).add(Integer.valueOf(i));
      i += 1;
    }
    if ((paramInt == 0) || (parama == null)) {
      i = ((Random)localObject1).nextInt(2);
    }
    for (;;)
    {
      if (i < ((List)localObject2).size()) {}
      for (i = ((Integer)((List)localObject2).get(i)).intValue();; i = 0)
      {
        j = i;
        if (i >= 2) {
          j = 1;
        }
        i4 = (i4 - i3) / 2;
        i = i3 + i4 * j;
        i3 = i4 + i;
        parama = new Rect(i1, i, i2, i3);
        i4 = ((Random)localObject1).nextInt(i2);
        int i5 = ((Random)localObject1).nextInt(i3);
        localObject1 = new Rect();
        ((Rect)localObject1).left = (i1 + i4 % (i2 - i1 + 1) - k / 2);
        ((Rect)localObject1).top = (i5 % (i3 - i + 1) + i - k / 2);
        ((Rect)localObject1).right = (((Rect)localObject1).left + k);
        ((Rect)localObject1).bottom = (((Rect)localObject1).top + k);
        localObject2 = new a();
        ((a)localObject2).dou = 500;
        ((a)localObject2).dov = 700;
        if (((a)localObject2).dov < 0) {
          ((a)localObject2).dov = 0;
        }
        ((a)localObject2).dos = k;
        ((a)localObject2).dot = k;
        ((a)localObject2).ck = ((Rect)localObject1);
        ((a)localObject2).cl = new Rect((Rect)localObject1);
        ((a)localObject2).dow = 0;
        ((a)localObject2).cj = parama;
        ((a)localObject2).dox = j;
        if (QLog.isColorLevel()) {
          QLog.i("ScanOcrView", 2, "generateScanRectAniParam, hasDoneCnt=" + paramInt + "," + m + "*" + n + "\n" + localObject2);
        }
        return localObject2;
        ((List)localObject2).remove(Integer.valueOf(parama.dox));
        if (((List)localObject2).size() <= 0) {
          break label558;
        }
        i = ((Random)localObject1).nextInt(((List)localObject2).size());
        break;
      }
      label558:
      i = 0;
    }
  }
  
  private void dCr()
  {
    if (this.doq == 0) {
      this.dop = (this.doo - this.cVk);
    }
    while (this.doq != 1) {
      return;
    }
    this.dop = this.doo;
  }
  
  @TargetApi(12)
  private void dCw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "realPlayScanRectHoldAnimation, ,mScanRectHoldPlaying=" + this.cty + ",mPlaying=" + this.SD);
    }
    this.b = a();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    Object localObject = this.b;
    localValueAnimator1.addUpdateListener(new akow(this, (a)localObject));
    localValueAnimator1.setDuration(200L);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator2.addUpdateListener(new akox(this, (a)localObject));
    localValueAnimator2.setDuration(100L);
    localValueAnimator2.setRepeatCount(3);
    localValueAnimator2.setRepeatMode(2);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.as = ((AnimatorSet)localObject);
    ((AnimatorSet)localObject).start();
    invalidate();
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    this.dt = getResources().getDrawable(2130846532);
    this.ff = getResources().getDrawable(2130846531);
    this.fg = getResources().getDrawable(2130846533);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(1275068416);
    this.mLineHeight = dp2px(10.0F, this.mContext.getResources());
    this.dom = dp2px(5.0F, this.mContext.getResources());
    this.mCoverHeight = dp2px(212.0F, this.mContext.getResources());
    this.mCoverHeight = dp2px(212.0F, this.mContext.getResources());
    this.cVk = dp2px(110.0F, this.mContext.getResources());
  }
  
  public void Sh(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScan, mPlaying=" + this.SD + ",scanType=" + paramInt + ",mScanType=" + this.doq);
    }
    this.mHandler.removeMessages(0);
    if (paramInt != this.doq)
    {
      stopScan();
      dCt();
    }
    if (!this.SD)
    {
      this.bSZ = 0;
      this.mLastTime = System.currentTimeMillis();
      this.doq = paramInt;
      dCr();
      this.SD = true;
      invalidate();
    }
  }
  
  public void dCs()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScanRectAnimation, mScanRectPlaying=" + this.ctx);
    }
    if (!this.ctx)
    {
      this.ctx = true;
      Si(0);
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void dCt()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScanRectAnimation, mScanRectPlaying=" + this.ctx);
    }
    this.ctx = false;
    if (this.ar != null) {
      this.ar.cancel();
    }
    invalidate();
  }
  
  public void dCu()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "startScanRectHoldAni, mScanRectHoldPlaying=" + this.cty);
    }
    if (!this.cty)
    {
      this.cty = true;
      dCw();
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void dCv()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScanRectHoldAni, mScanRectHoldPlaying=" + this.cty);
    }
    this.cty = false;
    if (this.ar != null) {
      this.ar.cancel();
    }
    invalidate();
  }
  
  public boolean isPlaying()
  {
    return this.SD;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    int j;
    if (this.SD)
    {
      if (this.bSZ >= this.dop)
      {
        this.bSZ = 0;
        stopScan();
        dCt();
        if (this.doq == 0) {
          dCs();
        }
        this.mHandler.removeMessages(0);
        paramCanvas = Message.obtain(this.mHandler, 0, this.doq, 0);
        this.mHandler.sendMessageDelayed(paramCanvas, 2000L);
        return;
      }
      if (this.bSZ == 0) {
        break label416;
      }
      j = (int)((System.currentTimeMillis() - this.mLastTime) * this.dop / 2000L);
      if (this.bSZ + j <= this.dop) {
        break label403;
      }
      this.bSZ = this.dop;
      label127:
      j = this.bSZ - this.mCoverHeight;
      if (j >= 0) {
        break label425;
      }
    }
    for (;;)
    {
      this.ff.setBounds(this.paddingLeft, i, this.paddingLeft + this.don, this.bSZ);
      this.ff.draw(paramCanvas);
      this.dt.setBounds(this.paddingLeft, this.bSZ - this.mLineHeight + this.dom, this.paddingLeft + this.don, this.bSZ + this.dom);
      this.dt.draw(paramCanvas);
      this.mLastTime = System.currentTimeMillis();
      invalidate();
      if ((this.ctx) && (this.a != null))
      {
        this.fg.setAlpha(this.a.dow);
        this.fg.setBounds(this.a.cl.left, this.a.cl.top, this.a.cl.right, this.a.cl.bottom);
        this.fg.draw(paramCanvas);
      }
      if ((!this.cty) || (this.b == null)) {
        break;
      }
      this.fg.setAlpha(this.b.dow);
      this.fg.setBounds(this.b.cl.left, this.b.cl.top, this.b.cl.right, this.b.cl.bottom);
      this.fg.draw(paramCanvas);
      return;
      label403:
      this.bSZ = (j + this.bSZ);
      break label127;
      label416:
      this.bSZ = 10;
      break label127;
      label425:
      i = j;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.don = (this.mWidth - this.paddingLeft - this.paddingRight);
    this.doo = (this.mHeight - this.paddingTop - this.paddingBottom);
    dCr();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.paddingLeft = paramInt1;
    this.paddingRight = paramInt3;
    this.paddingTop = paramInt2;
    this.paddingBottom = paramInt4;
  }
  
  public void stopScan()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "stopScan, mPlaying=" + this.SD + ",scanType=" + this.doq);
    }
    this.mHandler.removeMessages(0);
    this.SD = false;
    invalidate();
  }
  
  public static class a
  {
    Rect cj = new Rect();
    public Rect ck = new Rect();
    public Rect cl = new Rect();
    public int dos;
    public int dot;
    int dou;
    int dov;
    public int dow;
    int dox;
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("currAlpha = ").append(this.dow).append("\n").append("currRect = ");
      if (this.cl != null)
      {
        str = this.cl.toShortString();
        localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("radomAreaIndex = ").append(this.dox).append("\n").append("radomRect = ");
        if (this.cj == null) {
          break label182;
        }
        str = this.cj.toShortString();
        label95:
        localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("gapDuration = ").append(this.dou).append("\n").append("startRect = ");
        if (this.ck == null) {
          break label188;
        }
      }
      label182:
      label188:
      for (String str = this.ck.toShortString();; str = "")
      {
        localStringBuilder2.append(str).append("\n").append("edageWidth = ").append(this.dos).append("\n");
        return localStringBuilder1.toString();
        str = "";
        break;
        str = "";
        break label95;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView
 * JD-Core Version:    0.7.0.1
 */