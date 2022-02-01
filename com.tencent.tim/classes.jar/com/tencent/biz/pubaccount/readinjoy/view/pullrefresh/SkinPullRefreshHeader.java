package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import son;

public class SkinPullRefreshHeader
  extends RelativeLayout
  implements son
{
  int bbe = Color.parseColor("#f7f7f7");
  GradientDrawable d = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { Color.parseColor("#59000000"), 0 });
  private RelativeLayout fs;
  private ImageView kQ;
  private Context mContext;
  private ProgressBar mProgress;
  private int mPullType = 0;
  private View mV;
  private View maskView;
  private TextView tj;
  public long yb;
  
  public SkinPullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    setBackgroundColor(this.bbe);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private void baf()
  {
    if (this.fs == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fs.getLayoutParams();
    if (this.mPullType == 0)
    {
      a(localLayoutParams, 10);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      this.fs.setLayoutParams(localLayoutParams);
      return;
      a(localLayoutParams, 12);
      localLayoutParams.addRule(10);
    }
  }
  
  public void B(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.tj.setVisibility(0);
      this.tj.setText(paramString);
      return;
    }
    this.tj.setVisibility(8);
  }
  
  public void K(int paramInt, String paramString)
  {
    this.tj.setVisibility(0);
    this.mProgress.setVisibility(4);
    Drawable localDrawable = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = paramString;
      if (localDrawable != null)
      {
        paramInt = (int)this.tj.getTextSize() + 2;
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        localObject = new SpannableString("[O]" + " " + paramString);
        ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
      }
      this.tj.setText((CharSequence)localObject);
      return;
      localDrawable = getResources().getDrawable(2130850423);
      continue;
      localDrawable = getResources().getDrawable(2130850421);
      continue;
      localDrawable = getResources().getDrawable(2130850422);
    }
  }
  
  public void Q(long paramLong)
  {
    this.mProgress.setVisibility(4);
    this.tj.setVisibility(4);
  }
  
  public void R(long paramLong)
  {
    this.tj.setText(2131720485);
  }
  
  public void S(long paramLong)
  {
    this.mProgress.setVisibility(0);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      this.kQ.setImageDrawable(paramDrawable);
      setBackgroundColor(this.bbe);
      if (this.maskView != null)
      {
        if (!paramBoolean) {
          break label51;
        }
        this.maskView.setVisibility(0);
        this.maskView.setBackgroundDrawable(this.d);
      }
    }
    return;
    label51:
    this.maskView.setVisibility(8);
  }
  
  public long dl()
  {
    return this.yb;
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.fs = ((RelativeLayout)findViewById(2131365360));
    this.mProgress = ((ProgressBar)findViewById(2131377037));
    this.kQ = ((ImageView)findViewById(2131377039));
    this.tj = ((TextView)findViewById(2131377036));
    this.maskView = findViewById(2131377033);
    this.mV = findViewById(2131377040);
    Q(0L);
  }
  
  public void pn()
  {
    if (this.mProgress != null)
    {
      this.mProgress.setVisibility(8);
      this.mProgress.setVisibility(0);
    }
  }
  
  public void setAdTabVisibility(boolean paramBoolean)
  {
    View localView;
    if (this.mV != null)
    {
      localView = this.mV;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.mPullType != paramInt)
    {
      this.mPullType = paramInt;
      baf();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void tT(int paramInt)
  {
    this.mProgress.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.SkinPullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */