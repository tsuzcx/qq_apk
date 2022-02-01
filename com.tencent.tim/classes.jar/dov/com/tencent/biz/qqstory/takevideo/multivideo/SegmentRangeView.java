package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import aypq;
import aypq.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rpv;

public class SegmentRangeView
  extends View
  implements aypq.a
{
  private float FU = 8.0F;
  private float FV = 20.0F;
  private float FW = 72.0F;
  private float FX = 3.0F;
  private float FY = 30.0F;
  private float FZ;
  private List<Bitmap> Fz = new ArrayList();
  private float Ga;
  private final float Gb = 0.6F;
  private List<Pair<Long, Long>> NB;
  private aypq a;
  private long aDb;
  private long aDc;
  private boolean dAm;
  private boolean dAn;
  private boolean dAo = true;
  private Paint dm;
  private Bitmap hY;
  private Bitmap hZ;
  private int mFrameCount;
  private int mFrameHeight;
  private int mFrameWidth;
  private float mLastX;
  private WeakReference<a> mListenerRef;
  private Paint mMaskPaint;
  private boolean mReverse;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public SegmentRangeView(Context paramContext)
  {
    super(paramContext);
    gI(paramContext);
  }
  
  public SegmentRangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    gI(paramContext);
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
    long l2 = ((float)this.aDb * (paramFloat - this.FV) * 1.0F / (getWidth() - this.FV * 2.0F));
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
    this.FV = ((int)c(paramContext, this.FV));
    this.FW = ((int)c(paramContext, this.FW));
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
      return (float)((float)paramLong * (getWidth() - this.FV * 2.0F) * 1.0F / (float)this.aDb + this.FV);
      l = paramLong;
      if (paramLong > this.aDb) {
        l = this.aDb;
      }
    }
  }
  
  private int x(float paramFloat)
  {
    Math.abs(this.Ga - this.FZ);
    if ((paramFloat > this.FZ - this.FV - this.FY) && (paramFloat < this.FZ + this.FY))
    {
      if ((paramFloat <= this.Ga - this.FY) || (paramFloat >= this.Ga + this.FV + this.FY) || (Math.abs(paramFloat - this.FZ) < Math.abs(paramFloat - this.Ga))) {
        return 0;
      }
      return 1;
    }
    if ((paramFloat > this.Ga - this.FY) && (paramFloat < this.Ga + this.FV + this.FY)) {
      return 1;
    }
    return -1;
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
    this.aDc = paramLong1;
    this.dAo = paramBoolean1;
    boolean bool = rpv.j(paramInt2, paramInt3, paramInt1);
    if (paramBoolean1)
    {
      this.mVideoWidth = paramInt2;
      this.mVideoHeight = paramInt3;
      paramInt1 = 0;
      this.a = new aypq(getContext(), paramBoolean2, bool);
      this.a.a(paramString, paramLong1, paramLong2, paramInt1, this);
      this.mMaskPaint = new Paint(1);
      this.mMaskPaint.setColor(2130706432);
      this.mMaskPaint.setStyle(Paint.Style.FILL);
      this.dm = new Paint(1);
      this.dm.setStyle(Paint.Style.FILL);
      this.dm.setColor(-15550475);
      this.FZ = this.FV;
      this.Ga = this.FZ;
      this.hY = t(2130845505);
      this.hZ = t(2130845507);
      return;
    }
    if ((bool) && (paramBoolean2)) {}
    for (int i = paramInt1 + 90;; i = paramInt1)
    {
      if (paramInt1 % 180 > 0)
      {
        this.mVideoWidth = paramInt3;
        this.mVideoHeight = paramInt2;
        paramInt1 = i;
        break;
      }
      this.mVideoWidth = paramInt2;
      this.mVideoHeight = paramInt3;
      paramInt1 = i;
      break;
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
    this.Fz.add(paramBitmap);
    invalidate();
  }
  
  public final List<Pair<Long, Long>> ia()
  {
    if (this.FZ >= this.Ga) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    long l1 = b(this.FZ);
    long l2 = b(this.Ga);
    long l3;
    if ((l1 > l2) && (this.mReverse))
    {
      l3 = l2;
      l2 = l1;
    }
    for (;;)
    {
      localArrayList.add(new Pair(Long.valueOf(l3), Long.valueOf(l2)));
      return localArrayList;
      QLog.e("SegmentRangeView", 2, "geRanges, start:" + l1 + " end:" + l2);
      l3 = l1;
    }
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
    paramCanvas.drawRect(this.FZ, 0.0F, this.Ga, getHeight(), this.mMaskPaint);
    paramCanvas.drawRect(this.FZ, 0.0F, this.Ga, this.FX, this.dm);
    paramCanvas.drawRect(this.FZ, getHeight() - this.FX, this.Ga, getHeight(), this.dm);
    paramCanvas.drawBitmap(this.hY, (int)(this.FZ - this.FV), 0.0F, null);
    paramCanvas.drawBitmap(this.hZ, (int)this.Ga, 0.0F, null);
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
      if (this.dAo)
      {
        f = this.mVideoWidth * 1.0F / this.mVideoHeight;
        this.mFrameWidth = ((int)(f * paramInt2));
        this.mFrameHeight = paramInt2;
        if (this.mFrameWidth != 0) {
          break label115;
        }
      }
    }
    label115:
    while (this.NB == null)
    {
      do
      {
        for (;;)
        {
          return;
          float f = 0.6F;
        }
        this.mFrameCount = (paramInt1 / this.mFrameWidth);
        if (this.mFrameCount * this.mFrameWidth != paramInt1) {
          this.mFrameCount += 1;
        }
      } while (this.mFrameCount == 0);
      if (this.a != null)
      {
        this.a.stop();
        this.a.u(this.mFrameCount, this.mFrameWidth, this.mFrameHeight);
      }
    }
    List localList = this.NB;
    this.NB = null;
    setRanges(localList);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      f = paramMotionEvent.getX();
      this.mLastX = f;
      int i = x(f);
      if (i == 0)
      {
        this.dAm = true;
        return true;
      }
      if (i == 1)
      {
        this.dAn = true;
        return true;
      }
      return true;
    case 2: 
      f = paramMotionEvent.getX() - this.mLastX;
      if (this.dAm)
      {
        this.mLastX = paramMotionEvent.getX();
        this.FZ = (f + this.FZ);
        if (this.FZ <= this.FV) {
          this.FZ = this.FV;
        }
        if (this.FZ > this.Ga - getWidth() * 0.1F) {
          this.FZ = (this.Ga - getWidth() * 0.1F);
        }
        if (this.mListenerRef == null) {
          break label457;
        }
      }
      break;
    }
    label455:
    label457:
    for (paramMotionEvent = (a)this.mListenerRef.get();; paramMotionEvent = null)
    {
      if (paramMotionEvent != null)
      {
        if (this.mReverse) {
          break label223;
        }
        paramMotionEvent.op(b(this.FZ));
      }
      for (;;)
      {
        label217:
        invalidate();
        return true;
        label223:
        paramMotionEvent.onSeekEnd(b(this.FZ));
        continue;
        if (this.dAn)
        {
          this.mLastX = paramMotionEvent.getX();
          this.Ga = (f + this.Ga);
          if (this.Ga + this.FV >= getWidth()) {
            this.Ga = (getWidth() - this.FV);
          }
          if (this.FZ + getWidth() * 0.1F > this.Ga) {
            this.Ga = (this.FZ + getWidth() * 0.1F);
          }
          if (this.mListenerRef != null) {}
          for (paramMotionEvent = (a)this.mListenerRef.get();; paramMotionEvent = null)
          {
            if (paramMotionEvent == null) {
              break label455;
            }
            if (!this.mReverse)
            {
              paramMotionEvent.onSeekEnd(b(this.Ga));
              break label217;
            }
            paramMotionEvent.op(b(this.Ga));
            break label217;
            if ((!this.dAm) && (!this.dAn)) {
              break;
            }
            this.dAm = false;
            this.dAn = false;
            return true;
            if ((!this.dAm) && (!this.dAn)) {
              break;
            }
            this.dAm = false;
            this.dAn = false;
            return true;
          }
        }
      }
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (getWidth() == 0)
    {
      this.NB = paramList;
      if (this.NB == null) {
        this.NB = new ArrayList();
      }
      return;
    }
    float f1;
    float f2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      f1 = h(0L);
      f2 = h(this.aDb);
      if (!this.mReverse)
      {
        this.FZ = f1;
        this.Ga = f2;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.FZ = f2;
      this.Ga = f1;
      continue;
      this.FZ = h(((Long)((Pair)paramList.get(0)).first).longValue());
      this.Ga = h(((Long)((Pair)paramList.get(0)).second).longValue());
      if ((this.Ga < this.FZ) && (this.mReverse))
      {
        f1 = this.Ga;
        this.Ga = this.FZ;
        this.FZ = f1;
      }
      else
      {
        QLog.e("SegmentRangeView", 2, "setRanges error, left:" + this.FZ + " right:" + this.Ga);
      }
    }
  }
  
  public Bitmap t(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt, null);
      return localBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
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
    this.NB = null;
  }
  
  static abstract interface a
  {
    public abstract void oS(List<Long> paramList);
    
    public abstract void onSeekEnd(long paramLong);
    
    public abstract void op(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentRangeView
 * JD-Core Version:    0.7.0.1
 */