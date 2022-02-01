package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmu;
import son;

public class PullRefreshHeader
  extends RelativeLayout
  implements son
{
  private RotateAnimation c;
  private int ccL = 0;
  private int ccM = 0;
  private int ccN = 0;
  private int ccO = 0;
  private int ccP = 0;
  private int ccQ = 0;
  private RotateAnimation d;
  private RelativeLayout fs;
  private Context mContext;
  private ProgressBar mProgress;
  private int mPullType = 0;
  private TextView mTimeText;
  private TextView tj;
  private ImageView uQ;
  public long yb;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.c = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.c.setDuration(100L);
    this.c.setFillAfter(true);
    this.d = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.d.setDuration(100L);
    this.d.setFillAfter(true);
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
  
  private void gA(long paramLong)
  {
    if (this.mTimeText == null) {}
    do
    {
      return;
      if (paramLong == 0L) {
        break;
      }
      this.mTimeText.setVisibility(0);
      this.mTimeText.setText(String.format("%s%s", new Object[] { this.mContext.getString(2131720481), aqmu.a(paramLong, true, "yyyy-MM-dd") }));
    } while (this.ccP < 0);
    this.mTimeText.setTextColor(this.ccP);
    return;
    this.mTimeText.setVisibility(8);
  }
  
  private void setColor(int paramInt)
  {
    if (paramInt != 0) {
      this.tj.setTextColor(paramInt);
    }
  }
  
  public void K(int paramInt, String paramString)
  {
    this.uQ.clearAnimation();
    this.uQ.setVisibility(4);
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
      setColor(this.ccO);
      if (this.mTimeText != null) {
        this.mTimeText.setVisibility(8);
      }
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
    this.uQ.setVisibility(0);
    this.uQ.clearAnimation();
    if (this.mPullType == 0)
    {
      if (this.ccQ == 0) {
        this.uQ.setImageResource(2130850419);
      }
      for (;;)
      {
        this.tj.setText(2131720483);
        setColor(this.ccL);
        gA(paramLong);
        return;
        this.uQ.setImageResource(2130839678);
      }
    }
    if (this.ccQ == 0) {
      this.uQ.setImageResource(2130850420);
    }
    for (;;)
    {
      this.tj.setText(2131720484);
      break;
      this.uQ.setImageResource(2130839679);
    }
  }
  
  public void R(long paramLong)
  {
    this.uQ.clearAnimation();
    this.uQ.startAnimation(this.c);
    this.tj.setText(2131720485);
    setColor(this.ccM);
    gA(paramLong);
  }
  
  public void S(long paramLong)
  {
    try
    {
      this.tj.setText(2131720482);
      setColor(this.ccN);
      label17:
      gA(paramLong);
      this.uQ.setVisibility(8);
      this.uQ.clearAnimation();
      this.mProgress.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
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
    this.uQ = ((ImageView)findViewById(2131377034));
    this.tj = ((TextView)findViewById(2131377036));
    this.mTimeText = ((TextView)findViewById(2131377043));
    if (this.mPullType != 0) {
      baf();
    }
    if (this.ccQ != 0) {
      this.uQ.setImageResource(2130839680);
    }
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
  
  public void setArrowColor(int paramInt)
  {
    this.ccQ = paramInt;
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
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.ccL = paramInt1;
    this.ccM = paramInt2;
    this.ccN = paramInt3;
    this.ccO = paramInt4;
    this.ccP = paramInt5;
  }
  
  public void tT(int paramInt)
  {
    this.uQ.clearAnimation();
    this.uQ.setVisibility(4);
    this.mProgress.setVisibility(4);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (0 != 0)
      {
        paramInt = (int)this.tj.getTextSize();
        throw new NullPointerException();
      }
      this.tj.setText(str);
      setColor(this.ccO);
      if (this.mTimeText != null) {
        this.mTimeText.setVisibility(8);
      }
      return;
      getResources().getDrawable(2130850423);
      str = getResources().getString(2131720486);
      continue;
      getResources().getDrawable(2130850421);
      str = getResources().getString(2131720480);
      continue;
      getResources().getDrawable(2130850422);
      str = getResources().getString(2131720480);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */