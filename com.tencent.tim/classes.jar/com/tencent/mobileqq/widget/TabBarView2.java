package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import anlm;
import aqnm;
import atau.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;
import wja;

public class TabBarView2
  extends TabBarView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private Paint aI;
  private int aXv;
  private int aYU = -16776961;
  private RectF ap;
  private boolean bqe;
  private Paint bu;
  private int ccf = 25;
  private int cch = 9;
  private int cci = 15;
  private int ccj = 16;
  private int cck = 16;
  private int ccp;
  private int ccq;
  private Rect textRect = new Rect();
  
  public TabBarView2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aXu = wja.dp2px(56.0F, getResources());
    this.mTextSize = 16;
    boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(BaseApplicationImpl.getApplication().getRuntime(), true);
    int k = this.ccf;
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    int i;
    int j;
    if (anlm.Vr()) {
      if (bool2)
      {
        i = 2131166736;
        k = 2131167383;
        int n = 255;
        j = i;
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      this.aXx = getResources().getColor(i);
      this.aXw = getResources().getColor(m);
      this.aYU = getResources().getColor(j);
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.cch = ((int)TypedValue.applyDimension(1, this.cch, localDisplayMetrics));
      this.cci = ((int)TypedValue.applyDimension(1, this.cci, localDisplayMetrics));
      this.ccj = ((int)TypedValue.applyDimension(1, this.ccj, localDisplayMetrics));
      this.cck = ((int)TypedValue.applyDimension(1, this.cck, localDisplayMetrics));
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sd);
      this.aYU = paramContext.getColor(2, this.aYU);
      this.ccf = paramContext.getInt(1, this.ccf);
      this.ccj = paramContext.getDimensionPixelSize(5, this.ccj);
      this.cck = paramContext.getDimensionPixelSize(6, this.cck);
      this.cch = paramContext.getDimensionPixelSize(4, this.cch);
      this.cci = paramContext.getDimensionPixelSize(3, this.cci);
      this.bqe = paramContext.getBoolean(12, false);
      if (this.bqe)
      {
        this.ccp = paramContext.getDimensionPixelSize(16, aqnm.dpToPx(25.0F));
        this.aXv = paramContext.getDimensionPixelSize(14, aqnm.dpToPx(3.0F));
        this.ccq = paramContext.getDimensionPixelSize(15, aqnm.dpToPx(6.0F));
        i = paramContext.getColor(13, getResources().getColor(2131165723));
        this.bu = new Paint();
        this.bu.setAntiAlias(true);
        this.bu.setColor(i);
      }
      paramContext.recycle();
      if (("1103".equals(ThemeUtil.curThemeId)) || (anlm.Vr()))
      {
        this.aYU = getResources().getColor(j);
        this.ccf = k;
      }
      initPaint();
      return;
      i = 2131166735;
      break;
      if (bool2)
      {
        m = 2131165722;
        i = 2131165721;
        j = 2131165720;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131167383;
        j = 2131167311;
      }
      else
      {
        i = 2131167383;
        m = 2131165723;
        j = 2131165723;
      }
    }
  }
  
  private void initPaint()
  {
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.FILL);
    this.ap = new RectF();
  }
  
  protected void bC(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.aXA);
    int i;
    int m;
    int j;
    int k;
    int n;
    if (localView1 != null)
    {
      this.aI.setColor(this.aYU);
      this.aI.setAlpha(this.ccf);
      View localView2 = (View)this.Js.get(this.aXA);
      this.paint.setTextSize(this.mTextSize * getContext().getResources().getDisplayMetrics().density + 0.5F);
      String str = (String)this.jP.get(this.aXA);
      this.paint.getTextBounds(str, 0, str.length(), this.textRect);
      float f1 = this.textRect.width();
      float f2 = this.textRect.height();
      i = localView1.getRight();
      m = localView1.getLeft();
      j = localView1.getBottom();
      k = localView1.getTop();
      m = (int)((i - m - f1) / 2.0F);
      i = (int)(f1 + m);
      k = (int)((j - k - f2) / 2.0F);
      n = (int)(f2 + k);
      if (localView2 != null)
      {
        j = localView1.getLeft() + m;
        i += localView1.getLeft();
        m = localView1.getTop();
        n = localView1.getTop() + n;
        if (this.ki <= 0.0F) {
          break label524;
        }
        localView1 = getChildAt(this.aXz);
        if (localView1 == null) {
          break label524;
        }
        f1 = this.paint.measureText(((String)this.jP.get(this.aXz)).toString());
        int i2 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
        int i1 = (int)(f1 + i2);
        f1 = j;
        f2 = this.ki;
        j = (int)((i2 + localView1.getLeft() - this.ccq - j) * f2 + f1);
        f1 = i;
        f2 = this.ki;
        i = (int)((i1 + localView1.getLeft() + this.ccq - i) * f2 + f1);
      }
    }
    label524:
    for (;;)
    {
      if (this.bqe)
      {
        k = (i - j - this.ccp) / 2;
        paramCanvas.drawRect(j + k, this.ccq + n, i - k, this.ccq + n + this.aXv, this.bu);
        return;
      }
      this.ap.set(j - this.cci, m + k - this.cch, i + this.cci, this.cch + n);
      paramCanvas.drawRoundRect(this.ap, this.ccj, this.cck, this.aI);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView2
 * JD-Core Version:    0.7.0.1
 */