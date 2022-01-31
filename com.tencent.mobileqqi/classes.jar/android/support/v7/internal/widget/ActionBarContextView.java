package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqqi.R.styleable;

public class ActionBarContextView
  extends AbsActionBarView
{
  private static final String TAG = "ActionBarContextView";
  private View mClose;
  private View mCustomView;
  private Drawable mSplitBackground;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772026);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.h, paramInt, 0);
    setBackgroundDrawable(paramContext.getDrawable(3));
    this.mTitleStyleRes = paramContext.getResourceId(1, 0);
    this.mSubtitleStyleRes = paramContext.getResourceId(2, 0);
    this.mContentHeight = paramContext.getLayoutDimension(0, 0);
    this.mSplitBackground = paramContext.getDrawable(4);
    paramContext.recycle();
  }
  
  private void initTitle()
  {
    int m = 8;
    int j = 1;
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(2130903046, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(2131230933));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(2131230934));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    int i;
    label164:
    Object localObject;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      i = 1;
      if (TextUtils.isEmpty(this.mSubtitle)) {
        break label231;
      }
      localObject = this.mSubtitleView;
      if (j == 0) {
        break label236;
      }
    }
    label231:
    label236:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.mTitleLayout;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (this.mTitleLayout.getParent() == null) {
        addView(this.mTitleLayout);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label164;
    }
  }
  
  public void closeMode()
  {
    if (this.mClose == null) {
      killMode();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.hideOverflowMenu();
    }
    return false;
  }
  
  public void initForMode(ActionMode paramActionMode)
  {
    if (this.mClose == null)
    {
      this.mClose = LayoutInflater.from(getContext()).inflate(2130903050, this, false);
      addView(this.mClose);
    }
    ViewGroup.LayoutParams localLayoutParams;
    for (;;)
    {
      this.mClose.findViewById(2131230935).setOnClickListener(new ActionBarContextView.1(this, paramActionMode));
      paramActionMode = (MenuBuilder)paramActionMode.getMenu();
      if (this.mActionMenuPresenter != null) {
        this.mActionMenuPresenter.dismissPopupMenus();
      }
      this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
      this.mActionMenuPresenter.setReserveOverflow(true);
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      if (this.mSplitActionBar) {
        break;
      }
      paramActionMode.addMenuPresenter(this.mActionMenuPresenter);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(null);
      addView(this.mMenuView, localLayoutParams);
      return;
      if (this.mClose.getParent() == null) {
        addView(this.mClose);
      }
    }
    this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
    this.mActionMenuPresenter.setItemLimit(2147483647);
    localLayoutParams.width = -1;
    localLayoutParams.height = this.mContentHeight;
    paramActionMode.addMenuPresenter(this.mActionMenuPresenter);
    this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
    this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
    this.mSplitView.addView(this.mMenuView, localLayoutParams);
  }
  
  public boolean isOverflowMenuShowing()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    return false;
  }
  
  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }
  
  public void killMode()
  {
    removeAllViews();
    if (this.mSplitView != null) {
      this.mSplitView.removeView(this.mMenuView);
    }
    this.mCustomView = null;
    this.mMenuView = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    if ((this.mClose != null) && (this.mClose.getVisibility() != 8))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      paramInt2 = i + localMarginLayoutParams.leftMargin;
      paramInt4 = positionChild(this.mClose, paramInt2, j, k);
    }
    for (paramInt2 = localMarginLayoutParams.rightMargin + (paramInt2 + paramInt4);; paramInt2 = i)
    {
      paramInt4 = paramInt2;
      if (this.mTitleLayout != null)
      {
        paramInt4 = paramInt2;
        if (this.mCustomView == null)
        {
          paramInt4 = paramInt2;
          if (this.mTitleLayout.getVisibility() != 8) {
            paramInt4 = paramInt2 + positionChild(this.mTitleLayout, paramInt2, j, k);
          }
        }
      }
      if (this.mCustomView != null) {
        positionChild(this.mCustomView, paramInt4, j, k);
      }
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
      if (this.mMenuView != null) {
        positionChildInverse(this.mMenuView, paramInt1, j, k);
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1073741824;
    int m = 0;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i;
    int n;
    int j;
    if (this.mContentHeight > 0)
    {
      i = this.mContentHeight;
      int i2 = getPaddingTop() + getPaddingBottom();
      paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
      n = i - i2;
      j = View.MeasureSpec.makeMeasureSpec(n, -2147483648);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.mClose != null)
      {
        paramInt1 = measureChildView(this.mClose, paramInt1, j, 0);
        localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.mMenuView != null)
      {
        paramInt1 = paramInt2;
        if (this.mMenuView.getParent() == this) {
          paramInt1 = measureChildView(this.mMenuView, paramInt2, j, 0);
        }
      }
      paramInt2 = paramInt1;
      if (this.mTitleLayout != null)
      {
        paramInt2 = paramInt1;
        if (this.mCustomView == null)
        {
          if (!this.mTitleOptional) {
            break label512;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.mTitleLayout.measure(paramInt2, j);
          int i3 = this.mTitleLayout.getMeasuredWidth();
          if (i3 > paramInt1) {
            break label500;
          }
          j = 1;
          label307:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i3;
          }
          localObject = this.mTitleLayout;
          if (j == 0) {
            break label506;
          }
          paramInt1 = 0;
          label332:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label338:
      if (this.mCustomView != null)
      {
        localObject = this.mCustomView.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject).width == -2) {
          break label528;
        }
        paramInt1 = 1073741824;
        label368:
        j = paramInt2;
        if (((ViewGroup.LayoutParams)localObject).width >= 0) {
          j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -2) {
          break label535;
        }
        paramInt2 = k;
        if (((ViewGroup.LayoutParams)localObject).height < 0) {
          break label542;
        }
        k = Math.min(((ViewGroup.LayoutParams)localObject).height, n);
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      label403:
      label423:
      if (this.mContentHeight > 0) {
        break label557;
      }
      j = getChildCount();
      paramInt1 = 0;
      paramInt2 = m;
      label460:
      if (paramInt2 >= j) {
        break label549;
      }
      i = getChildAt(paramInt2).getMeasuredHeight() + i2;
      if (i <= paramInt1) {
        break label565;
      }
      paramInt1 = i;
    }
    label512:
    label528:
    label535:
    label542:
    label549:
    label557:
    label565:
    for (;;)
    {
      paramInt2 += 1;
      break label460;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      label500:
      j = 0;
      break label307;
      label506:
      paramInt1 = 8;
      break label332;
      paramInt2 = measureChildView(this.mTitleLayout, paramInt1, j, 0);
      break label338;
      paramInt1 = -2147483648;
      break label368;
      paramInt2 = -2147483648;
      break label403;
      k = n;
      break label423;
      setMeasuredDimension(i1, paramInt1);
      return;
      setMeasuredDimension(i1, i);
      return;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null) {
      removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if (this.mTitleLayout != null)
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    ViewGroup localViewGroup;
    if (this.mSplitActionBar != paramBoolean) {
      if (this.mActionMenuPresenter != null)
      {
        localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (paramBoolean) {
          break label91;
        }
        this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
        this.mMenuView.setBackgroundDrawable(null);
        localViewGroup = (ViewGroup)this.mMenuView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(this.mMenuView);
        }
        addView(this.mMenuView, localLayoutParams);
      }
    }
    for (;;)
    {
      super.setSplitActionBar(paramBoolean);
      return;
      label91:
      this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.mActionMenuPresenter.setItemLimit(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.mContentHeight;
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
      localViewGroup = (ViewGroup)this.mMenuView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.mMenuView);
      }
      this.mSplitView.addView(this.mMenuView, localLayoutParams);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional) {
      requestLayout();
    }
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean showOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */