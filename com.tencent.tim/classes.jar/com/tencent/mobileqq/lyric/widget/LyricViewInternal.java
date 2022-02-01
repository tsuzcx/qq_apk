package com.tencent.mobileqq.lyric.widget;

import aiwm;
import aiwn;
import aiwp;
import aiwr;
import aixc;
import aixf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LyricViewInternal
  extends View
{
  protected final Handler aY = new aixf(this, Looper.getMainLooper());
  protected volatile boolean bNn = true;
  protected final String bPQ;
  protected String bPR;
  protected final Paint bU = new Paint();
  protected final Paint bV = new Paint();
  protected final Paint bW = new Paint();
  protected final Paint bX = new Paint();
  protected final Paint bY = new Paint();
  protected final Paint bZ = new Paint();
  protected int cVH;
  protected final Paint ca = new Paint();
  protected final Paint cb = new Paint();
  protected final Paint cc = new Paint();
  protected volatile boolean cml;
  public boolean cmn;
  protected volatile boolean cmo;
  protected volatile boolean cmr;
  protected volatile boolean cms;
  protected volatile boolean cmt;
  protected volatile boolean cmu;
  protected int cqg;
  protected int dfC;
  protected int dfJ;
  protected int dfK;
  public int dfM;
  protected int dfN = -1;
  protected int dfO = -1;
  protected int dfS;
  protected int dfT = -1;
  protected int dfU = 3500;
  protected int dfV = -1;
  protected int dfW;
  protected int dfX;
  protected int dfY;
  protected volatile int dfZ;
  protected int dga;
  protected int dgb;
  protected int dgc;
  protected aiwn f;
  protected aiwn g;
  protected Scroller j;
  Bitmap mBitmap = null;
  Context mContext;
  protected volatile boolean mIsScrolling;
  protected int mLineHeight;
  protected Object mLock = new Object();
  protected final Paint mPaint = new Paint();
  protected int mState = 0;
  protected int mWidth;
  protected int mWindowWidth;
  protected float xa;
  
  public LyricViewInternal(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternal(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramAttributeSet = (WindowManager)this.mContext.getSystemService("window");
    if (Build.VERSION.SDK_INT < 13) {}
    Object localObject;
    for (this.mWindowWidth = paramAttributeSet.getDefaultDisplay().getWidth();; this.mWindowWidth = ((Point)localObject).x)
    {
      localObject = new DisplayMetrics();
      paramAttributeSet.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.xa = ((DisplayMetrics)localObject).density;
      this.bPQ = paramContext.getString(2131720383);
      this.bPR = paramContext.getString(2131720382);
      this.j = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
      return;
      localObject = new Point();
      paramAttributeSet.getDefaultDisplay().getSize((Point)localObject);
    }
  }
  
  public int Gb()
  {
    return this.dfZ;
  }
  
  protected int Gc()
  {
    if (this.dfT == -1) {
      this.dfT = ((int)(43.0F * this.xa));
    }
    return this.dfT;
  }
  
  public void LC(boolean paramBoolean) {}
  
  void a(aiwn paramaiwn1, aiwn paramaiwn2)
  {
    for (;;)
    {
      try
      {
        Log.d("ModuleLyricViewInternal", "setLyric begin");
        this.bNn = true;
        this.cmr = false;
        if (paramaiwn1 != null)
        {
          dvh();
          aiwn localaiwn = new aiwn(2, 0, null);
          localaiwn.a(paramaiwn1);
          this.f = localaiwn;
          if ((paramaiwn2 != null) && (paramaiwn1.size() == paramaiwn2.size()))
          {
            paramaiwn1 = new aiwn(2, 0, null);
            paramaiwn1.a(paramaiwn2);
            this.g = paramaiwn1;
            setState(70);
            Log.d("ModuleLyricViewInternal", "setLyric end");
            return;
          }
          Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
          this.g = new aiwn(2, 0, null);
          continue;
        }
        Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      }
      finally {}
      setState(40);
    }
  }
  
  protected void a(aiwp paramaiwp, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int m;
      int k;
      try
      {
        ArrayList localArrayList = paramaiwp.dj();
        int i1 = this.cqg;
        Paint localPaint = this.bU;
        m = 0;
        i = paramInt2;
        if (m >= localArrayList.size()) {
          break label773;
        }
        aiwr localaiwr = (aiwr)localArrayList.get(m);
        if (localaiwr.xv == null)
        {
          paramInt2 = i;
          break label783;
        }
        int n;
        float f3;
        float f2;
        float f1;
        long l;
        float f4;
        if (m == 0)
        {
          n = this.cVH;
          if ((localaiwr.getStartTime() > i1) || (localaiwr.getEndTime() < i1)) {
            continue;
          }
          f3 = 0.0F;
          f2 = 0.0F;
          paramaiwp = null;
          k = 0;
          paramInt2 = 0;
          if (paramInt2 >= localaiwr.xv.size()) {
            break label776;
          }
          paramaiwp = (aiwm)localaiwr.xv.get(paramInt2);
          aiwm localaiwm = null;
          if (paramInt2 < localaiwr.xv.size() - 1) {
            localaiwm = (aiwm)localaiwr.xv.get(paramInt2 + 1);
          }
          if ((paramaiwp.mStartTime > i1) || (localaiwm == null) || (localaiwm.mStartTime <= i1)) {
            continue;
          }
          f1 = (float)(i1 - paramaiwp.mStartTime);
          l = paramaiwp.mDuration;
          f1 /= (float)l;
          f2 = f1;
          f3 = f1;
          if (paramaiwp != null)
          {
            f1 = paramInt1;
            f4 = f1;
            if (paramInt2 == 0) {}
          }
        }
        try
        {
          if (localaiwr.mText.length() >= ((aiwm)localaiwr.xv.get(paramInt2 - 1)).mEnd)
          {
            f4 = this.bU.measureText(localaiwr.mText.substring(0, ((aiwm)localaiwr.xv.get(paramInt2 - 1)).mEnd));
            f1 = f4 + f1;
            f4 = f1;
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          try
          {
            if (paramInt2 == localaiwr.xv.size() - 1)
            {
              f1 = this.bW.measureText(localaiwr.mText.substring(paramaiwp.mStart, localaiwr.mText.length()));
              k = localPaint.getColor();
              int i2 = this.bV.getColor();
              localaiwr.a(paramCanvas, paramInt1, i + n, this.bV, localPaint, this.bW, paramInt2, f1, f4, new int[] { k, i2 }, new float[] { f3, f2 });
              paramInt2 = this.dfJ + n + i;
              break label783;
              n = this.dfK;
              continue;
              if ((paramaiwp.mStartTime <= i1) && (paramaiwp.mStartTime + paramaiwp.mDuration >= i1))
              {
                f1 = (float)(i1 - paramaiwp.mStartTime);
                l = paramaiwp.mDuration;
                f3 = f1 / (float)l;
                f2 = f3;
                continue;
              }
              k = paramInt2;
              paramInt2 += 1;
              continue;
              f4 = this.bU.measureText(localaiwr.mText.substring(0, localaiwr.mText.length()));
              f1 = f4 + f1;
              continue;
              localStringIndexOutOfBoundsException = localStringIndexOutOfBoundsException;
              f4 = this.bU.measureText(localaiwr.mText.substring(0, localaiwr.mText.length()));
              f4 = f1 + f4;
              continue;
            }
            if (localaiwr.mText.length() >= paramaiwp.mEnd)
            {
              f1 = this.bW.measureText(localaiwr.mText.substring(paramaiwp.mStart, paramaiwp.mEnd));
              continue;
            }
            f1 = this.bW.measureText(localaiwr.mText.substring(paramaiwp.mStart, localaiwr.mText.length()));
            continue;
          }
          catch (StringIndexOutOfBoundsException paramaiwp)
          {
            f1 = this.bW.measureText(localaiwr.mText.substring(0, localaiwr.mText.length()));
            continue;
          }
        }
        if (localaiwr.getEndTime() < i1)
        {
          localaiwr.a(paramCanvas, paramInt1, i + n, localPaint, true);
          continue;
        }
        localaiwr.a(paramCanvas, paramInt1, i + n, this.bV, true);
      }
      finally {}
      continue;
      label773:
      return;
      label776:
      paramInt2 = k;
      continue;
      label783:
      m += 1;
      int i = paramInt2;
    }
  }
  
  protected void a(aiwp paramaiwp, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramaiwp = paramaiwp.dj();
    int m = this.mLineHeight;
    int n = this.cVH;
    int k = 0;
    int i = paramInt2;
    paramInt2 = k;
    while (paramInt2 < paramaiwp.size())
    {
      ((aiwr)paramaiwp.get(paramInt2)).a(paramCanvas, paramInt1, i + this.cVH, paramPaint, false);
      i += m + n;
      paramInt2 += 1;
    }
  }
  
  protected void a(aiwp paramaiwp, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2)
  {
    paramaiwp = paramaiwp.dj();
    int m = this.mLineHeight;
    int n = this.cVH;
    int k = 0;
    int i = paramInt2;
    paramInt2 = k;
    while (paramInt2 < paramaiwp.size())
    {
      ((aiwr)paramaiwp.get(paramInt2)).a(paramCanvas, paramInt1, i + this.cVH, paramPaint1, paramPaint2);
      i += m + n;
      paramInt2 += 1;
    }
  }
  
  protected void a(aiwp paramaiwp, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramaiwp.dj();
    if (paramBoolean) {}
    for (paramaiwp = this.bU;; paramaiwp = this.mPaint)
    {
      int m = this.mLineHeight;
      int n = this.cVH;
      int k = 0;
      int i = paramInt2;
      paramInt2 = k;
      while (paramInt2 < localArrayList.size())
      {
        ((aiwr)localArrayList.get(paramInt2)).a(paramCanvas, paramInt1, i + this.cVH, paramaiwp, paramBoolean);
        i += m + n;
        paramInt2 += 1;
      }
    }
  }
  
  public void a(aixc paramaixc)
  {
    this.f = new aiwn(2, 0, null);
    this.g = new aiwn(2, 0, null);
    this.dfK = paramaixc.dfK;
    this.mLineHeight = paramaixc.dfF;
    this.cVH = paramaixc.cVH;
    int i = paramaixc.dfG;
    int k = paramaixc.dfH;
    int m = paramaixc.dfI;
    this.dfJ = paramaixc.dfJ;
    int n = paramaixc.dfD;
    this.dfC = paramaixc.dfC;
    this.cml = paramaixc.cml;
    boolean bool = paramaixc.cmm;
    this.cmu = true;
    this.dgb = 3;
    this.dgc = 2;
    this.dfM = paramaixc.dfM;
    this.cmn = paramaixc.cmn;
    this.bV.setAntiAlias(true);
    this.bV.setTextSize(i);
    this.bV.setColor(m);
    this.bW.setAntiAlias(true);
    this.bW.setTextSize(i);
    this.bW.setColor(k);
    this.bU.setAntiAlias(true);
    this.bU.setTextSize(i);
    this.bU.setColor(k);
    this.bU.setFakeBoldText(bool);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(this.dfC);
    this.mPaint.setColor(n);
    this.bY.setAntiAlias(true);
    this.bY.setTextSize(this.dfC);
    this.bY.setColor(n);
    this.bY.setAlpha(127);
    this.bZ.setAntiAlias(true);
    this.bZ.setTextSize(this.dfC);
    this.bZ.setColor(n);
    this.bZ.setAlpha(51);
    this.ca.setAntiAlias(true);
    this.ca.setTextSize(this.dfC);
    this.ca.setColor(n);
    this.ca.setAlpha(25);
    this.bX.setAntiAlias(true);
    this.bX.setTextSize(this.dfC);
    this.cb.setAntiAlias(true);
    this.cb.setTextSize(this.dfC);
    this.cb.setColor(n);
    this.cb.setAlpha(255);
    this.cc.setAntiAlias(true);
    this.cc.setTextSize(i);
    this.cc.setColor(n);
    this.cc.setAlpha(255);
    this.dfS = this.cVH;
  }
  
  protected void a(Canvas paramCanvas, Paint paramPaint, String paramString, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    paramString = paramString.split("\n");
    int i = 0;
    int k = 0;
    while (i < paramString.length)
    {
      int m = this.mWidth;
      int n = (int)this.mPaint.measureText(paramString[i]);
      paramCanvas.drawText(paramString[i], (m - n >> 1) + paramInt1, paramInt2 + k, paramPaint);
      paramPaint.getTextBounds(paramString[i], 0, paramString[i].length(), localRect);
      k += localRect.height() + 20;
      i += 1;
    }
  }
  
  public aiwn c()
  {
    return this.f;
  }
  
  protected void c(Canvas paramCanvas, int paramInt) {}
  
  public aiwn d()
  {
    return this.f;
  }
  
  public void dvf() {}
  
  void dvg()
  {
    this.bNn = false;
    ThreadManager.getUIHandler().post(new LyricViewInternal.2(this));
  }
  
  public void dvh()
  {
    this.cmo = false;
    this.dfN = -1;
    this.dfO = -1;
    this.dfW = 0;
    this.dfX = 0;
    this.cmr = false;
  }
  
  public void iB(int paramInt1, int paramInt2)
  {
    this.dfY = paramInt1;
    this.cqg = paramInt2;
    dvf();
    postInvalidate();
  }
  
  public int ii(int paramInt)
  {
    this.mIsScrolling = true;
    return this.dfY;
  }
  
  public int ij(int paramInt)
  {
    paramInt = this.dfY;
    this.mIsScrolling = false;
    return paramInt;
  }
  
  public void ob(int paramInt)
  {
    this.dgb = ((paramInt - this.dfS - this.dfJ) / (this.mLineHeight + this.cVH) + 1);
    if (this.dgb < 0) {
      this.dgb = 2;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = (getMeasuredHeight() >> 1) - this.mLineHeight;
    switch (this.mState)
    {
    default: 
      if (this.bPR != null)
      {
        scrollTo(0, 0);
        this.j.setFinalX(0);
        a(paramCanvas, this.mPaint, this.bPR, 0, i);
      }
      break;
    }
    do
    {
      return;
      c(paramCanvas, 0);
      return;
    } while (this.bPQ == null);
    scrollTo(0, 0);
    this.j.setFinalX(0);
    a(paramCanvas, this.mPaint, this.bPQ, 0, i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 0;
    View localView = (View)((View)getParent()).getParent();
    int k = localView.getMeasuredWidth();
    int m = localView.getMeasuredHeight();
    if (this.mState == 70)
    {
      paramInt1 = k - (Gc() << 1);
      int n = this.mLineHeight;
      int i1 = this.cVH;
      if (this.cmn)
      {
        this.f.a(this.bU, this.mPaint, paramInt1, false, true);
        if ((this.g != null) && (this.f.size() == this.g.size()))
        {
          if (!this.cmn) {
            break label222;
          }
          this.g.a(this.bU, this.mPaint, paramInt1, false, true);
        }
      }
      int i;
      for (;;)
      {
        if (!this.cmo) {
          break label241;
        }
        i = this.dfW;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i > this.dfX) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.f.xs.get(i) != null) {
            paramInt1 = paramInt2 + ((aiwp)this.f.xs.get(i)).Ga();
          }
          i += 1;
          paramInt2 = paramInt1;
        }
        this.f.a(this.bU, this.mPaint, paramInt1);
        break;
        label222:
        this.g.a(this.bU, this.mPaint, paramInt1);
      }
      label241:
      paramInt1 = this.f.Ga();
      paramInt2 = paramInt1;
      if (this.cms)
      {
        paramInt2 = paramInt1;
        if (this.g != null)
        {
          paramInt2 = paramInt1;
          if (this.g.xs != null) {
            if (this.cmo)
            {
              i = this.dfW;
              paramInt2 = paramInt1;
              if (i <= this.dfX)
              {
                paramInt2 = paramInt1;
                if (i < this.g.xs.size()) {
                  if (i >= 0) {
                    break label332;
                  }
                }
                label332:
                for (paramInt2 = paramInt1;; paramInt2 = paramInt1 + ((aiwp)this.g.xs.get(i)).Ga())
                {
                  i += 1;
                  paramInt1 = paramInt2;
                  break;
                }
              }
            }
            else
            {
              paramInt2 = paramInt1 + this.g.Ga();
            }
          }
        }
      }
      this.dfU = (paramInt2 * (n + i1));
      setMeasuredDimension(k, this.dfU + m);
      return;
    }
    setMeasuredDimension(k, m);
  }
  
  public void setDrawAttachInfo(boolean paramBoolean)
  {
    this.cmt = paramBoolean;
  }
  
  public void setHighlightCurrentLine(boolean paramBoolean)
  {
    this.cmu = paramBoolean;
  }
  
  public void setHighlightLineNumber(int paramInt)
  {
    this.dgc = paramInt;
  }
  
  public void setIndicator(Bitmap paramBitmap) {}
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.cmn = paramBoolean;
  }
  
  public void setLyricColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
  
  public void setLyricHilightColor(int paramInt)
  {
    this.bW.setColor(paramInt);
    this.bU.setColor(paramInt);
  }
  
  public void setScore(int[] paramArrayOfInt) {}
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      if ((this.f == null) || (this.f.isEmpty())) {
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      }
    }
    else
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
      return;
    }
    if ((this.dfN == paramInt1) && (this.dfO == paramInt2))
    {
      Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
      return;
    }
    this.dfN = paramInt1;
    this.dfO = paramInt2;
    this.dfW = this.f.ig(paramInt1);
    this.dfX = this.f.ih(paramInt2);
    if ((this.dfW < 0) || (this.dfX < 0))
    {
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
      this.cmo = false;
      return;
    }
    this.cmo = true;
    this.cmr = false;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    this.aY.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternal
 * JD-Core Version:    0.7.0.1
 */