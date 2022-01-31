package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.util.List;

class ActionBarView$HomeView
  extends FrameLayout
{
  private Drawable mDefaultUpIndicator;
  private ImageView mIconView;
  private int mUpIndicatorRes;
  private ImageView mUpView;
  private int mUpWidth;
  
  public ActionBarView$HomeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarView$HomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    CharSequence localCharSequence = getContentDescription();
    if (!TextUtils.isEmpty(localCharSequence)) {
      paramAccessibilityEvent.getText().add(localCharSequence);
    }
    return true;
  }
  
  public int getLeftOffset()
  {
    if (this.mUpView.getVisibility() == 8) {
      return this.mUpWidth;
    }
    return 0;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mUpIndicatorRes != 0) {
      setUpIndicator(this.mUpIndicatorRes);
    }
  }
  
  protected void onFinishInflate()
  {
    this.mUpView = ((ImageView)findViewById(2131230932));
    this.mIconView = ((ImageView)findViewById(2131230740));
    this.mDefaultUpIndicator = this.mUpView.getDrawable();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    int j = (paramInt4 - paramInt2) / 2;
    paramInt2 = i;
    paramInt4 = paramInt1;
    if (this.mUpView.getVisibility() != 8)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
      paramInt4 = this.mUpView.getMeasuredHeight();
      paramInt2 = this.mUpView.getMeasuredWidth();
      i = j - paramInt4 / 2;
      this.mUpView.layout(0, i, paramInt2, paramInt4 + i);
      paramInt4 = localLayoutParams.leftMargin;
      paramInt2 = localLayoutParams.rightMargin + (paramInt4 + paramInt2);
      paramInt4 = paramInt1 + paramInt2;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
    paramInt1 = this.mIconView.getMeasuredHeight();
    i = this.mIconView.getMeasuredWidth();
    paramInt3 = (paramInt3 - paramInt4) / 2;
    paramInt2 += Math.max(localLayoutParams.leftMargin, paramInt3 - i / 2);
    paramInt3 = Math.max(localLayoutParams.topMargin, j - paramInt1 / 2);
    this.mIconView.layout(paramInt2, paramInt3, i + paramInt2, paramInt1 + paramInt3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildWithMargins(this.mUpView, paramInt1, 0, paramInt2, 0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
    this.mUpWidth = (localLayoutParams.leftMargin + this.mUpView.getMeasuredWidth() + localLayoutParams.rightMargin);
    int i;
    int j;
    int k;
    int m;
    if (this.mUpView.getVisibility() == 8)
    {
      i = 0;
      j = localLayoutParams.topMargin;
      k = this.mUpView.getMeasuredHeight();
      m = localLayoutParams.bottomMargin;
      measureChildWithMargins(this.mIconView, paramInt1, i, paramInt2, 0);
      localLayoutParams = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
      i += localLayoutParams.leftMargin + this.mIconView.getMeasuredWidth() + localLayoutParams.rightMargin;
      int n = localLayoutParams.topMargin;
      int i1 = this.mIconView.getMeasuredHeight();
      j = Math.max(j + k + m, localLayoutParams.bottomMargin + (n + i1));
      i1 = View.MeasureSpec.getMode(paramInt1);
      n = View.MeasureSpec.getMode(paramInt2);
      m = View.MeasureSpec.getSize(paramInt1);
      k = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = m;
      switch (i1)
      {
      default: 
        paramInt1 = i;
      case 1073741824: 
        label226:
        paramInt2 = k;
        switch (n)
        {
        }
        break;
      }
    }
    for (paramInt2 = j;; paramInt2 = Math.min(j, k))
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      i = this.mUpWidth;
      break;
      paramInt1 = Math.min(i, m);
      break label226;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIconView.setImageDrawable(paramDrawable);
  }
  
  public void setUp(boolean paramBoolean)
  {
    ImageView localImageView = this.mUpView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setUpIndicator(int paramInt)
  {
    this.mUpIndicatorRes = paramInt;
    ImageView localImageView = this.mUpView;
    if (paramInt != 0) {}
    for (Drawable localDrawable = getResources().getDrawable(paramInt);; localDrawable = null)
    {
      localImageView.setImageDrawable(localDrawable);
      return;
    }
  }
  
  public void setUpIndicator(Drawable paramDrawable)
  {
    ImageView localImageView = this.mUpView;
    if (paramDrawable != null) {}
    for (;;)
    {
      localImageView.setImageDrawable(paramDrawable);
      this.mUpIndicatorRes = 0;
      return;
      paramDrawable = this.mDefaultUpIndicator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.HomeView
 * JD-Core Version:    0.7.0.1
 */