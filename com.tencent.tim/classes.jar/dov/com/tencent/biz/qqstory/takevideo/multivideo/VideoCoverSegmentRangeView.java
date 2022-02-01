package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import aqcl;
import aypq;
import aypq.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rop;
import rpv;

public class VideoCoverSegmentRangeView
  extends View
  implements aypq.a
{
  private float FU = 8.0F;
  private float FX = 4.0F;
  private float FY = 10.0F;
  private float FZ;
  private List<Bitmap> Fz = new ArrayList();
  private float Ga;
  private aypq a;
  private long aCz = -1L;
  private long aDb;
  private long aDd = -1L;
  private boolean dAo = true;
  private Paint dm;
  private int eMy = -1;
  private int mFrameCount = 7;
  private int mFrameHeight;
  private int mFrameWidth;
  private float mLastX;
  private WeakReference<a> mListenerRef;
  private Paint mMaskPaint;
  private boolean mReverse;
  private long mStartTime;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mViewHeight;
  
  public VideoCoverSegmentRangeView(Context paramContext)
  {
    super(paramContext);
    gI(paramContext);
  }
  
  public VideoCoverSegmentRangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    gI(paramContext);
  }
  
  private void am(MotionEvent paramMotionEvent)
  {
    float f;
    if (this.eMy == 0)
    {
      f = paramMotionEvent.getX() - this.mLastX;
      this.mLastX = paramMotionEvent.getX();
      this.FZ += f;
    }
    for (this.Ga = (f + this.Ga);; this.Ga = (this.FZ + this.mFrameWidth + this.FX))
    {
      if (this.FZ <= 0.0F)
      {
        this.FZ = 0.0F;
        this.Ga = (this.mFrameWidth + this.FX);
      }
      if (this.Ga + this.FX >= getWidth())
      {
        this.Ga = (getWidth() - this.FX);
        this.FZ = (this.Ga - (this.mFrameWidth + this.FX));
      }
      paramMotionEvent = null;
      if (this.mListenerRef != null) {
        paramMotionEvent = (a)this.mListenerRef.get();
      }
      if (paramMotionEvent != null)
      {
        this.aCz = (b(this.FZ) + this.mStartTime);
        paramMotionEvent.onSeekTo(this.aCz);
      }
      return;
      this.FZ = (paramMotionEvent.getX() - (this.mFrameWidth >> 1));
    }
  }
  
  private static float b(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramResources.getDisplayMetrics().density * paramFloat;
  }
  
  private long b(float paramFloat)
  {
    long l2 = ((float)this.aDb * paramFloat / (getWidth() - this.mFrameWidth));
    long l1 = l2;
    if (this.mReverse)
    {
      l2 = this.aDb - l2;
      if (l2 < 0L) {
        return 0L;
      }
      l1 = l2;
      if (l2 > this.aDb) {
        return this.aDb;
      }
    }
    return l1;
  }
  
  public static float c(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return b(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private void ci(Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (this.Fz.size() == 0)) {}
    do
    {
      return;
      i = getWidth();
      j = getHeight();
    } while ((i <= this.FU + this.FU) || (j <= this.FU + this.FU) || (i <= this.FU + this.FU) || (j <= this.FU + this.FU));
    paramCanvas.save();
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.FU, 0.0F);
    ((Path)localObject).lineTo(i - this.FU, 0.0F);
    ((Path)localObject).quadTo(i, 0.0F, i, this.FU);
    ((Path)localObject).lineTo(i, j - this.FU);
    ((Path)localObject).quadTo(i, j, i - this.FU, j);
    ((Path)localObject).lineTo(this.FU, j);
    ((Path)localObject).quadTo(0.0F, j, 0.0F, j - this.FU);
    ((Path)localObject).lineTo(0.0F, this.FU);
    ((Path)localObject).quadTo(0.0F, 0.0F, this.FU, 0.0F);
    paramCanvas.clipPath((Path)localObject);
    if (!this.mReverse)
    {
      localObject = this.Fz.iterator();
      for (i = 0; ((Iterator)localObject).hasNext(); i = this.mFrameWidth + i) {
        paramCanvas.drawBitmap((Bitmap)((Iterator)localObject).next(), i, 0.0F, null);
      }
    }
    int i = this.Fz.size() - 1;
    int j = 0;
    while (i >= 0)
    {
      paramCanvas.drawBitmap((Bitmap)this.Fz.get(i), j, 0.0F, null);
      j += this.mFrameWidth;
      i -= 1;
    }
    paramCanvas.restore();
  }
  
  private void gI(Context paramContext)
  {
    this.FU = ((int)c(paramContext, this.FU));
    this.FX = ((int)c(paramContext, this.FX));
    this.FY = c(paramContext, this.FY);
  }
  
  private float h(long paramLong)
  {
    long l;
    if (paramLong < 0L) {
      l = 0L;
    }
    for (;;)
    {
      paramLong = l;
      if (this.mReverse) {
        paramLong = this.aDb - l;
      }
      return (float)((float)((getWidth() - this.mFrameWidth) * paramLong) * 1.0F / (float)this.aDb);
      l = paramLong;
      if (paramLong > this.aDb) {
        l = this.aDb;
      }
    }
  }
  
  private void oq(long paramLong)
  {
    try
    {
      int i = (int)(paramLong / 1000L + 1L);
      aqcl.speak(this, String.format(acfp.m(2131716372), new Object[] { Integer.valueOf(i) }));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int x(float paramFloat)
  {
    if ((paramFloat > this.FZ - this.FY) && (paramFloat < this.Ga + this.FY)) {
      return 0;
    }
    return 1;
  }
  
  public void ZK(boolean paramBoolean)
  {
    if (this.mReverse != paramBoolean)
    {
      this.mReverse = paramBoolean;
      invalidate();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    this.mListenerRef = new WeakReference(parama);
    this.aDb = (paramLong2 - paramLong1);
    this.mStartTime = paramLong1;
    this.dAo = paramBoolean1;
    paramBoolean1 = rpv.j(paramInt2, paramInt3, paramInt1);
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (int i = paramInt1 + 90;; i = paramInt1)
    {
      if (paramInt1 % 180 != 0) {
        this.mVideoWidth = paramInt3;
      }
      for (this.mVideoHeight = paramInt2;; this.mVideoHeight = paramInt3)
      {
        this.a = new aypq(getContext(), paramBoolean2, paramBoolean1);
        this.a.a(paramString, paramLong1, paramLong2, i, this);
        this.mMaskPaint = new Paint(1);
        this.mMaskPaint.setColor(2130706432);
        this.mMaskPaint.setStyle(Paint.Style.FILL);
        this.dm = new Paint(1);
        this.dm.setStyle(Paint.Style.FILL);
        this.dm.setColor(-15550475);
        this.FZ = 0.0F;
        this.Ga = 0.0F;
        return;
        this.mVideoWidth = paramInt2;
      }
    }
  }
  
  public void eTj()
  {
    if (this.mFrameCount != this.Fz.size())
    {
      QLog.d("SegmentRangeView", 2, "onLaadEnd, frame num error!!, target:" + this.mFrameCount + "  real:" + this.Fz.size());
      if (this.Fz.size() > 0)
      {
        Bitmap localBitmap = (Bitmap)this.Fz.get(this.Fz.size() - 1);
        int i = this.mFrameCount - this.Fz.size();
        while (i > 0)
        {
          this.Fz.add(localBitmap);
          i -= 1;
        }
      }
    }
    invalidate();
  }
  
  public void g(int paramInt, Bitmap paramBitmap)
  {
    if ((this.mFrameWidth == 0) || (this.mFrameHeight == 0))
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, width:" + this.mFrameWidth + "  height:" + this.mFrameHeight);
      return;
    }
    if (paramBitmap == null)
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, bitmap is null");
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getHeight() != this.mViewHeight) {
      localBitmap = rop.b(paramBitmap, paramBitmap.getWidth(), this.mViewHeight, true);
    }
    this.Fz.add(localBitmap);
    invalidate();
  }
  
  public void oT(List<Long> paramList)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.oS(paramList);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ci(paramCanvas);
    paramCanvas.drawRect(0.0F, 0.0F, this.FZ, getHeight(), this.mMaskPaint);
    paramCanvas.drawRect(this.Ga + this.FX, 0.0F, getWidth(), getHeight(), this.mMaskPaint);
    paramCanvas.drawRect(this.FZ, 0.0F, this.Ga, this.FX, this.dm);
    paramCanvas.drawRect(this.FZ, getHeight() - this.FX, this.Ga, getHeight(), this.dm);
    paramCanvas.drawRect(this.FZ, 0.0F, this.FZ + this.FX, getHeight(), this.dm);
    paramCanvas.drawRect(this.Ga, 0.0F, this.Ga + this.FX, getHeight(), this.dm);
  }
  
  public void onLoadStart() {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SegmentRangeView", 2, "onsizechanged, will reload frame: " + paramInt1 + "-" + paramInt2);
      }
      if (!this.dAo) {
        break label175;
      }
      this.mFrameCount = 7;
      this.mFrameWidth = (paramInt1 / this.mFrameCount + 1);
      this.mFrameHeight = ((int)(this.mVideoHeight / this.mVideoWidth * this.mFrameWidth));
    }
    for (this.mViewHeight = paramInt2;; this.mViewHeight = paramInt2)
    {
      if (this.a != null)
      {
        this.a.stop();
        this.a.u(this.mFrameCount, this.mFrameWidth, this.mFrameHeight);
      }
      if (this.aDd != -1L)
      {
        setCoverFrameTime(this.aDd);
        this.aDd = -1L;
      }
      return;
      label175:
      this.mFrameCount = 7;
      this.mFrameWidth = (paramInt1 / this.mFrameCount + 1);
      this.mFrameHeight = paramInt2;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = false;
    case 0: 
    case 2: 
      do
      {
        return bool;
        float f = paramMotionEvent.getX();
        this.mLastX = f;
        this.eMy = x(f);
      } while (this.eMy != 0);
      am(paramMotionEvent);
      invalidate();
      return true;
    case 1: 
      if (this.eMy == 1)
      {
        am(paramMotionEvent);
        invalidate();
        oq(this.aCz);
      }
      for (;;)
      {
        this.eMy = -1;
        return true;
        if (this.eMy == 0) {
          oq(this.aCz);
        }
      }
    }
    this.eMy = -1;
    return true;
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (getWidth() == 0)
    {
      this.aDd = paramLong;
      return;
    }
    this.FZ = h(paramLong - this.mStartTime);
    this.Ga = (this.FZ + this.mFrameWidth + this.FX);
    this.aCz = paramLong;
    invalidate();
  }
  
  public void unInit()
  {
    this.mListenerRef = null;
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
    this.Fz.clear();
    this.aDd = 0L;
  }
  
  static abstract interface a
  {
    public abstract void oS(List<Long> paramList);
    
    public abstract void onSeekTo(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentRangeView
 * JD-Core Version:    0.7.0.1
 */