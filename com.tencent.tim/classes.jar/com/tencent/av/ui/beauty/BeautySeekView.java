package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import jft;
import jfu;
import wja;

public class BeautySeekView
  extends RelativeLayout
{
  private String RS;
  public boolean YX;
  private boolean YY = true;
  private a a;
  private Handler aP;
  private int ayF;
  private int ayG;
  private Drawable cg;
  public Runnable ck = new BeautySeekView.2(this);
  private View it;
  private int mBeautyValue;
  SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new jfu(this);
  private SeekBar mSeekBar;
  private int mThumbWidth;
  private TextView mTip;
  private TextView mTitle;
  
  public BeautySeekView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void avN()
  {
    this.ayG = this.mSeekBar.getMeasuredWidth();
    int i = this.mSeekBar.getPaddingLeft();
    int j = this.mSeekBar.getPaddingRight();
    int k = this.mSeekBar.getLeft();
    int m = (int)(this.ayF / 100.0F * (this.ayG - i - j)) + (k + i);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.it.getLayoutParams();
    localMarginLayoutParams.leftMargin = m;
    this.it.setLayoutParams(localMarginLayoutParams);
    if (QLog.isDevelopLevel()) {
      QLog.i("BeautySeekView", 4, String.format("updateMarker, pl: %s, pr: %s, w: %s, ml: %s, m: %s, left: %s, flag: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.ayG), Integer.valueOf(k), Integer.valueOf(this.ayF), Integer.valueOf(m), Boolean.valueOf(this.YY) }));
    }
  }
  
  private void init(Context paramContext)
  {
    this.aP = new Handler(Looper.getMainLooper());
    paramContext = inflate(paramContext, 2131559953, this);
    this.it = paramContext.findViewById(2131374205);
    this.it.setBackgroundResource(2130842791);
    this.mSeekBar = ((SeekBar)paramContext.findViewById(2131374122));
    this.mTitle = ((TextView)paramContext.findViewById(2131374121));
    this.mTip = ((TextView)paramContext.findViewById(2131374123));
    this.cg = getResources().getDrawable(2130842799);
    this.mTip.setVisibility(4);
    this.mSeekBar.setMax(100);
    this.mSeekBar.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
    this.mSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new jft(this));
    this.mThumbWidth = wja.dp2px(24.0F, getResources());
    if (AudioHelper.jY(0) == 1)
    {
      setBackgroundColor(-270080262);
      this.mTip.setBackgroundColor(-16777216);
      this.mSeekBar.setBackgroundColor(-536871168);
      setBackgroundColor(536870656);
    }
  }
  
  private void nq(int paramInt)
  {
    int i;
    if (this.it != null)
    {
      View localView = this.it;
      if (paramInt > this.ayF)
      {
        i = 2130842792;
        localView.setBackgroundResource(i);
      }
    }
    else
    {
      if (paramInt != 0) {
        break label63;
      }
      this.cg = getResources().getDrawable(2130842795);
    }
    for (;;)
    {
      this.mSeekBar.setThumb(this.cg);
      return;
      i = 2130842791;
      break;
      label63:
      if (paramInt <= 30) {
        this.cg = getResources().getDrawable(2130842797);
      } else if (paramInt <= 60) {
        this.cg = getResources().getDrawable(2130842798);
      } else {
        this.cg = getResources().getDrawable(2130842796);
      }
    }
  }
  
  private void updateTip(int paramInt)
  {
    if (this.ayF == 50) {}
    for (String str = paramInt - 50 + "%";; str = paramInt + "%")
    {
      this.mTip.setText(str);
      int i = this.mTip.getWidth();
      int j = this.mSeekBar.getWidth() - this.mSeekBar.getPaddingLeft() - this.mSeekBar.getPaddingRight();
      int k = ((RelativeLayout.LayoutParams)this.mSeekBar.getLayoutParams()).leftMargin;
      k = this.mSeekBar.getPaddingLeft() + k;
      float f1 = paramInt * 1.0F / Math.abs(this.mSeekBar.getMax());
      float f2 = j;
      int m = (int)((0.5F - f1) * this.cg.getIntrinsicWidth() + f2 * f1 - i / 2.0F);
      ((RelativeLayout.LayoutParams)this.mTip.getLayoutParams()).leftMargin = (k + m);
      if (QLog.isColorLevel()) {
        QLog.w("BeautySeekView", 2, "updateTip, progress[" + paramInt + "], seekBarLeft[" + k + "], tipWidth[" + i + "], thumbWidth[" + this.mThumbWidth + "], seekWidth[" + j + "]");
      }
      this.mTip.requestLayout();
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.RS = paramString2;
    if (this.mTitle != null) {
      this.mTitle.setText(paramString1);
    }
    if (this.ayF != paramInt2)
    {
      this.ayF = paramInt2;
      this.YY = true;
      avN();
    }
    mF(paramInt1);
  }
  
  public void mF(int paramInt)
  {
    if (this.mSeekBar != null) {
      this.mSeekBar.setProgress(paramInt);
    }
    nq(paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.YY) && (this.mSeekBar.getMeasuredWidth() != this.ayG))
    {
      this.YY = false;
      avN();
    }
  }
  
  public void setBeautySeekActionListener(a parama)
  {
    this.a = parama;
  }
  
  public void setMarginRight(int paramInt)
  {
    if (this.mSeekBar != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mSeekBar.getLayoutParams();
      if (QLog.isDevelopLevel()) {
        QLog.i("BeautySeekView", 4, "setMarginRight pre[" + localMarginLayoutParams.leftMargin + "], cur[" + paramInt + "]");
      }
      localMarginLayoutParams.rightMargin = paramInt;
      this.mSeekBar.setLayoutParams(localMarginLayoutParams);
      this.YY = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void j(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView
 * JD-Core Version:    0.7.0.1
 */