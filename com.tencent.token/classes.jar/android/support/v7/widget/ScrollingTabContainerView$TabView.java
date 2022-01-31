package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class ScrollingTabContainerView$TabView
  extends LinearLayout
{
  private final int[] BG_ATTRS = { 16842964 };
  private View mCustomView;
  private ImageView mIconView;
  private ActionBar.Tab mTab;
  private TextView mTextView;
  
  public ScrollingTabContainerView$TabView(ScrollingTabContainerView paramScrollingTabContainerView, Context paramContext, ActionBar.Tab paramTab, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.actionBarTabStyle);
    this.mTab = paramTab;
    paramScrollingTabContainerView = TintTypedArray.obtainStyledAttributes(paramContext, null, this.BG_ATTRS, R.attr.actionBarTabStyle, 0);
    if (paramScrollingTabContainerView.hasValue(0)) {
      setBackgroundDrawable(paramScrollingTabContainerView.getDrawable(0));
    }
    paramScrollingTabContainerView.recycle();
    if (paramBoolean) {
      setGravity(8388627);
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
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.this$0.mMaxTabWidth > 0) && (getMeasuredWidth() > this.this$0.mMaxTabWidth)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.this$0.mMaxTabWidth, 1073741824), paramInt2);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
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
      return;
    }
    if (this.mCustomView != null)
    {
      removeView(this.mCustomView);
      this.mCustomView = null;
    }
    Object localObject3 = ((ActionBar.Tab)localObject1).getIcon();
    localObject2 = ((ActionBar.Tab)localObject1).getText();
    int i;
    if (localObject3 != null)
    {
      Object localObject4;
      if (this.mIconView == null)
      {
        localObject4 = new AppCompatImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 16;
        ((ImageView)localObject4).setLayoutParams(localLayoutParams);
        addView((View)localObject4, 0);
        this.mIconView = ((ImageView)localObject4);
      }
      this.mIconView.setImageDrawable((Drawable)localObject3);
      this.mIconView.setVisibility(0);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label357;
      }
      i = 1;
      label209:
      if (i == 0) {
        break label362;
      }
      if (this.mTextView == null)
      {
        localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
        ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).gravity = 16;
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        addView((View)localObject3);
        this.mTextView = ((TextView)localObject3);
      }
      this.mTextView.setText((CharSequence)localObject2);
      this.mTextView.setVisibility(0);
      label300:
      if (this.mIconView != null) {
        this.mIconView.setContentDescription(((ActionBar.Tab)localObject1).getContentDescription());
      }
      if (i == 0) {
        break label389;
      }
    }
    label389:
    for (localObject1 = null;; localObject1 = ((ActionBar.Tab)localObject1).getContentDescription())
    {
      TooltipCompat.setTooltipText(this, (CharSequence)localObject1);
      return;
      if (this.mIconView == null) {
        break;
      }
      this.mIconView.setVisibility(8);
      this.mIconView.setImageDrawable(null);
      break;
      label357:
      i = 0;
      break label209;
      label362:
      if (this.mTextView == null) {
        break label300;
      }
      this.mTextView.setVisibility(8);
      this.mTextView.setText(null);
      break label300;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView.TabView
 * JD-Core Version:    0.7.0.1
 */