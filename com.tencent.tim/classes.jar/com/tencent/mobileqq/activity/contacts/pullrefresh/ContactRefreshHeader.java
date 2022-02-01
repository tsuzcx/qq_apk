package com.tencent.mobileqq.activity.contacts.pullrefresh;

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
import zbj;
import zbk;

public class ContactRefreshHeader
  extends RelativeLayout
  implements son, zbj, zbk
{
  private a a;
  private boolean aEl;
  private int aVz;
  private RotateAnimation c;
  private int ccL = -1;
  private int ccM = -1;
  private int ccN = -1;
  private int ccO = -1;
  private int ccP = -1;
  private int ccQ = 0;
  private RotateAnimation d;
  private RelativeLayout fs;
  private Context mContext;
  private boolean mIsRefreshing;
  private ProgressBar mProgress;
  private int mPullType = 0;
  private TextView mTimeText;
  private TextView tj;
  private ImageView uQ;
  public long yb;
  
  public ContactRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.c = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.c.setDuration(100L);
    this.c.setFillAfter(true);
    this.d = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.d.setDuration(100L);
    this.d.setFillAfter(true);
    this.aVz = getResources().getDimensionPixelOffset(2131299308);
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
  
  private long eC()
  {
    long l = 0L;
    if (this.a != null) {
      l = this.a.ev();
    }
    return l;
  }
  
  private void gA(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.mTimeText.setVisibility(0);
      this.mTimeText.setText(String.format("%s%s", new Object[] { this.mContext.getString(2131720481), aqmu.a(paramLong, true, "yyyy-MM-dd") }));
      if (this.ccP >= 0) {
        this.mTimeText.setTextColor(this.ccP);
      }
      return;
    }
    this.mTimeText.setVisibility(8);
  }
  
  private void setColor(int paramInt)
  {
    if (paramInt >= 0) {
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
      this.mTimeText.setVisibility(8);
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
      label18:
      gA(paramLong);
      this.uQ.setVisibility(8);
      this.uQ.clearAnimation();
      this.mProgress.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label18;
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
  
  public void o(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.mIsRefreshing))
    {
      if (paramInt <= this.aVz) {
        break label40;
      }
      if (this.aEl)
      {
        this.aEl = false;
        R(eC());
      }
    }
    label40:
    while ((paramInt >= this.aVz) || (this.aEl)) {
      return;
    }
    this.aEl = true;
    Q(eC());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
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
  
  public void onPrepare() {}
  
  public void onRefresh() {}
  
  public void onRelease()
  {
    if (!this.mIsRefreshing)
    {
      this.mIsRefreshing = true;
      S(0L);
    }
  }
  
  public void onReset()
  {
    if (!this.mIsRefreshing) {
      reset();
    }
  }
  
  public void pn()
  {
    if (this.mProgress != null)
    {
      this.mProgress.setVisibility(8);
      this.mProgress.setVisibility(0);
    }
  }
  
  public void reset()
  {
    this.aEl = false;
    this.tj.setText(2131720483);
    this.uQ.clearAnimation();
    this.uQ.setVisibility(0);
    this.mProgress.setVisibility(8);
    this.mTimeText.setVisibility(0);
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
  
  public void setRefresh(boolean paramBoolean)
  {
    this.mIsRefreshing = paramBoolean;
  }
  
  public void setRefreshHeaderUpdateListener(a parama)
  {
    this.a = parama;
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
    Drawable localDrawable = null;
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      Object localObject = str;
      if (localDrawable != null)
      {
        paramInt = (int)this.tj.getTextSize() + 2;
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        localObject = new SpannableString("[O]" + " " + str);
        ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
      }
      this.tj.setText((CharSequence)localObject);
      setColor(this.ccO);
      this.mTimeText.setVisibility(8);
      return;
      localDrawable = getResources().getDrawable(2130850423);
      str = getResources().getString(2131720486);
      continue;
      localDrawable = getResources().getDrawable(2130850421);
      str = getResources().getString(2131720480);
      continue;
      localDrawable = getResources().getDrawable(2130850422);
      str = getResources().getString(2131720480);
    }
  }
  
  public static abstract interface a
  {
    public abstract long ev();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader
 * JD-Core Version:    0.7.0.1
 */