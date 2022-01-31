package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.Tab;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ScrollingTabContainerView$TabView
  extends LinearLayout
{
  private View mCustomView;
  private ImageView mIconView;
  private ScrollingTabContainerView mParent;
  private ActionBar.Tab mTab;
  private TextView mTextView;
  
  public ScrollingTabContainerView$TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void attach(ScrollingTabContainerView paramScrollingTabContainerView, ActionBar.Tab paramTab, boolean paramBoolean)
  {
    this.mParent = paramScrollingTabContainerView;
    this.mTab = paramTab;
    if (paramBoolean) {
      setGravity(19);
    }
    update();
  }
  
  public void bindTab(ActionBar.Tab paramTab)
  {
    this.mTab = paramTab;
    update();
  }
  
  public ActionBar.Tab getTab()
  {
    return this.mTab;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mParent != null) {}
    for (paramInt1 = this.mParent.mMaxTabWidth;; paramInt1 = 0)
    {
      if ((paramInt1 > 0) && (getMeasuredWidth() > paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      return;
    }
  }
  
  public void update()
  {
    Object localObject1 = this.mTab;
    Object localObject2 = ((ActionBar.Tab)localObject1).getCustomView();
    if (localObject2 != null)
    {
      localObject1 = ((View)localObject2).getParent();
      if (localObject1 != this)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)localObject2);
        }
        addView((View)localObject2);
      }
      this.mCustomView = ((View)localObject2);
      if (this.mTextView != null) {
        this.mTextView.setVisibility(8);
      }
      if (this.mIconView != null)
      {
        this.mIconView.setVisibility(8);
        this.mIconView.setImageDrawable(null);
      }
    }
    label328:
    label353:
    for (;;)
    {
      return;
      if (this.mCustomView != null)
      {
        removeView(this.mCustomView);
        this.mCustomView = null;
      }
      Object localObject3 = ((ActionBar.Tab)localObject1).getIcon();
      localObject2 = ((ActionBar.Tab)localObject1).getText();
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.mIconView == null)
        {
          localObject4 = new ImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.mIconView = ((ImageView)localObject4);
        }
        this.mIconView.setImageDrawable((Drawable)localObject3);
        this.mIconView.setVisibility(0);
        if (localObject2 == null) {
          break label328;
        }
        if (this.mTextView == null)
        {
          localObject3 = new CompatTextView(getContext(), null, 2130771977);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.mTextView = ((TextView)localObject3);
        }
        this.mTextView.setText((CharSequence)localObject2);
        this.mTextView.setVisibility(0);
      }
      for (;;)
      {
        if (this.mIconView == null) {
          break label353;
        }
        this.mIconView.setContentDescription(((ActionBar.Tab)localObject1).getContentDescription());
        return;
        if (this.mIconView == null) {
          break;
        }
        this.mIconView.setVisibility(8);
        this.mIconView.setImageDrawable(null);
        break;
        if (this.mTextView != null)
        {
          this.mTextView.setVisibility(8);
          this.mTextView.setText(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabView
 * JD-Core Version:    0.7.0.1
 */