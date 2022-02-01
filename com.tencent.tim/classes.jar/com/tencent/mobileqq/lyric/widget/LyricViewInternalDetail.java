package com.tencent.mobileqq.lyric.widget;

import aiwn;
import aiwp;
import aiws;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;

public class LyricViewInternalDetail
  extends LyricViewInternal
{
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.dga = this.mLineHeight;
  }
  
  private int ik(int paramInt)
  {
    int m;
    if ((this.f == null) || (this.f.isEmpty()))
    {
      Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
      m = 0;
      return m;
    }
    int i = this.f.size();
    int j;
    if (this.cmo)
    {
      j = this.dfW;
      i = this.dfX;
    }
    for (;;)
    {
      int k = this.mLineHeight;
      k = this.cVH;
      m = 0;
      k = j;
      j = m;
      m = i;
      if (k > i) {
        break;
      }
      m = ((aiwp)this.f.xs.get(k)).Ga();
      int n = this.mLineHeight;
      j += (m - 1) * this.dfK + n * m + this.cVH;
      if ((this.cms) && (this.g != null) && (this.g.size() == this.f.size()))
      {
        m = ((aiwp)this.g.xs.get(k)).Ga();
        n = this.mLineHeight;
        j = (m - 1) * this.dfK + n * m + this.cVH + j;
      }
      for (;;)
      {
        if (paramInt < j) {
          return k;
        }
        k += 1;
        break;
      }
      i -= 1;
      j = 0;
    }
  }
  
  public void LC(boolean paramBoolean)
  {
    Log.d("LyricViewInternalDetail", "showLyricPronounce:" + paramBoolean);
    if (this.cms == paramBoolean) {
      return;
    }
    this.cms = paramBoolean;
    this.cmr = false;
    aiws.w().post(new LyricViewInternalDetail.1(this));
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Paint paramPaint)
  {
    if ((this.cms) && (this.g != null) && (this.g.xs != null))
    {
      paramPaint = this.g.xs;
      if ((paramInt3 < paramPaint.size()) && (paramInt3 >= 0)) {}
    }
    else
    {
      return;
    }
    if ((paramBoolean) && (!this.mIsScrolling))
    {
      a((aiwp)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2);
      return;
    }
    a((aiwp)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2, this.mPaint, this.cb);
  }
  
  protected void c(Canvas paramCanvas, int paramInt)
  {
    int n = this.mLineHeight + this.cVH;
    ArrayList localArrayList = this.f.xs;
    int k = localArrayList.size();
    int j = this.dfY;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int i1;
    if (i >= k)
    {
      j = k - 1;
      if (localArrayList.isEmpty()) {
        break label380;
      }
      i1 = paramInt + Gc();
      i = this.dfS;
      if (!this.cmo) {
        break label381;
      }
      paramInt = this.dfW;
      k = this.dfX;
    }
    for (;;)
    {
      int m = paramInt;
      label97:
      if (m <= k)
      {
        aiwp localaiwp = (aiwp)localArrayList.get(m);
        paramInt = Math.abs(m - j);
        if (paramInt == 0) {
          if ((this.cml) && (this.f.mType == 2) && (this.cmu))
          {
            a(localaiwp, paramCanvas, i1, i);
            paramInt = i + localaiwp.Ga() * n;
            a(paramCanvas, i1, paramInt, true, m, null);
            i = paramInt;
            if (this.cms)
            {
              i = paramInt;
              if (this.g != null)
              {
                i = paramInt;
                if (this.g.xs != null)
                {
                  i = paramInt;
                  if (m < this.g.xs.size()) {
                    if (m >= 0) {
                      break label353;
                    }
                  }
                }
              }
            }
          }
        }
        for (i = paramInt;; i = paramInt + ((aiwp)this.g.xs.get(m)).Ga() * n)
        {
          m += 1;
          break label97;
          j = i;
          break;
          a(localaiwp, paramCanvas, i1, i, this.cmu);
          paramInt = i + localaiwp.Ga() * n;
          break label175;
          if ((paramInt > 0) && (paramInt <= this.dgb))
          {
            a(localaiwp, paramCanvas, i1, i, this.mPaint);
            paramInt = i + localaiwp.Ga() * n;
            a(paramCanvas, i1, paramInt, false, m, this.mPaint);
            break label187;
          }
          paramInt = i + localaiwp.Ga() * n;
          break label187;
        }
      }
      label175:
      label187:
      label353:
      label380:
      return;
      label381:
      k -= 1;
      paramInt = 0;
    }
  }
  
  public void dvf()
  {
    int m = 0;
    int n = this.mLineHeight + this.cVH;
    int j = this.dfY;
    if (this.cmo) {
      j -= this.dfW;
    }
    for (;;)
    {
      ArrayList localArrayList = this.f.xs;
      int i = localArrayList.size();
      int k;
      if (this.cmo)
      {
        i = this.dfW;
        k = this.dfX;
      }
      for (;;)
      {
        if (j > k) {
          return;
        }
        k = i;
        i = m;
        if (k < j)
        {
          i += ((aiwp)localArrayList.get(k)).Ga();
          if ((!this.cms) || (this.g == null) || (this.g.xs == null) || (k >= this.g.xs.size())) {
            break label230;
          }
          if (k >= 0) {}
        }
        label230:
        for (;;)
        {
          k += 1;
          break;
          i = ((aiwp)this.g.xs.get(k)).Ga() + i;
          continue;
          if (this.dgc >= 0)
          {
            this.dfZ = (this.dfS + (i + 1 - this.dgc) * n - this.cVH);
            return;
          }
          this.dfZ = (this.dfS + (i - this.dgb - this.dgc) * n - this.cVH);
          return;
        }
        k = i - 1;
        i = 0;
      }
    }
  }
  
  public int ii(int paramInt)
  {
    super.ii(paramInt);
    this.dfY = ik(this.dga + paramInt);
    postInvalidate();
    return this.dfY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */