package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqqi.R.styleable;

public class ActionMenuView
  extends LinearLayoutICS
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private int mMaxItemHeight;
  private int mMeasuredExtraWidth;
  private MenuBuilder mMenu;
  private int mMinCellSize;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(f * 4.0F));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c, 2130771979, 0);
    this.mMaxItemHeight = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), i);
      int j = paramView.getMeasuredWidth();
      paramInt3 = j / paramInt1;
      paramInt2 = paramInt3;
      if (j % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!localLayoutParams.isOverflowButton)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      localLayoutParams.expandable = bool1;
      localLayoutParams.cellsUsed = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), i);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i8 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int i5 = getPaddingTop() + getPaddingBottom();
    if (i8 == 1073741824) {}
    int i9;
    for (int i3 = View.MeasureSpec.makeMeasureSpec(i7 - i5, 1073741824);; i3 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mMaxItemHeight, i7 - i5), -2147483648))
    {
      i9 = paramInt1 - (i + paramInt2);
      paramInt1 = i9 / this.mMinCellSize;
      paramInt2 = this.mMinCellSize;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i9, 0);
      return;
    }
    int i10 = this.mMinCellSize + i9 % paramInt2 / paramInt1;
    i = 0;
    int i1 = 0;
    int n = 0;
    int i2 = 0;
    int m = 0;
    long l1 = 0L;
    int i11 = getChildCount();
    int k = 0;
    Object localObject;
    int j;
    boolean bool;
    ActionMenuView.LayoutParams localLayoutParams;
    label303:
    label320:
    int i6;
    for (;;)
    {
      if (k < i11)
      {
        localObject = getChildAt(k);
        if (((View)localObject).getVisibility() == 8)
        {
          paramInt2 = i1;
          j = paramInt1;
          paramInt1 = i2;
          k += 1;
          i2 = paramInt1;
          paramInt1 = j;
          i1 = paramInt2;
        }
        else
        {
          bool = localObject instanceof ActionMenuItemView;
          i2 += 1;
          if (bool) {
            ((View)localObject).setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
          }
          localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.expanded = false;
          localLayoutParams.extraPixels = 0;
          localLayoutParams.cellsUsed = 0;
          localLayoutParams.expandable = false;
          localLayoutParams.leftMargin = 0;
          localLayoutParams.rightMargin = 0;
          if ((bool) && (((ActionMenuItemView)localObject).hasText()))
          {
            bool = true;
            localLayoutParams.preventEdgeOffset = bool;
            if (!localLayoutParams.isOverflowButton) {
              break label431;
            }
            paramInt2 = 1;
            i6 = measureChildForCells((View)localObject, i10, paramInt2, i3, i5);
            i1 = Math.max(i1, i6);
            if (!localLayoutParams.expandable) {
              break label1271;
            }
          }
        }
      }
    }
    label431:
    label477:
    label626:
    label1271:
    for (paramInt2 = n + 1;; paramInt2 = n)
    {
      if (localLayoutParams.isOverflowButton) {}
      for (j = 1;; j = m)
      {
        int i4 = paramInt1 - i6;
        i = Math.max(i, ((View)localObject).getMeasuredHeight());
        if (i6 == 1)
        {
          long l2 = 1 << k;
          paramInt1 = i2;
          n = paramInt2;
          l1 = l2 | l1;
          paramInt2 = i1;
          m = j;
          j = i4;
          break;
          bool = false;
          break label303;
          paramInt2 = paramInt1;
          break label320;
          if ((m != 0) && (i2 == 2))
          {
            i4 = 1;
            j = 0;
            k = paramInt1;
            if ((n <= 0) || (k <= 0)) {
              break label1237;
            }
            paramInt1 = 2147483647;
            l2 = 0L;
            paramInt2 = 0;
            i5 = 0;
            if (i5 >= i11) {
              break label600;
            }
            localObject = (ActionMenuView.LayoutParams)getChildAt(i5).getLayoutParams();
            if (((ActionMenuView.LayoutParams)localObject).expandable) {
              break label541;
            }
            i6 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i6;
          }
          for (;;)
          {
            i6 = i5 + 1;
            i5 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i5;
            i5 = i6;
            break label477;
            i4 = 0;
            break;
            if (((ActionMenuView.LayoutParams)localObject).cellsUsed < paramInt1)
            {
              paramInt2 = ((ActionMenuView.LayoutParams)localObject).cellsUsed;
              l2 = 1 << i5;
              paramInt1 = 1;
            }
            else
            {
              if (((ActionMenuView.LayoutParams)localObject).cellsUsed != paramInt1) {
                break label1226;
              }
              l2 |= 1 << i5;
              i6 = paramInt2 + 1;
              paramInt2 = paramInt1;
              paramInt1 = i6;
            }
          }
          l1 |= l2;
          if (paramInt2 > k) {}
          for (;;)
          {
            float f2;
            float f1;
            if ((m == 0) && (i2 == 1))
            {
              paramInt1 = 1;
              if ((k <= 0) || (l1 == 0L) || ((k >= i2 - 1) && (paramInt1 == 0) && (i1 <= 1))) {
                break label1214;
              }
              float f3 = Long.bitCount(l1);
              f2 = f3;
              if (paramInt1 != 0) {
                break label1208;
              }
              f1 = f3;
              if ((1L & l1) != 0L)
              {
                f1 = f3;
                if (!((ActionMenuView.LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i11 - 1 & l1) == 0L) {
                break label1208;
              }
              f2 = f1;
              if (((ActionMenuView.LayoutParams)getChildAt(i11 - 1).getLayoutParams()).preventEdgeOffset) {
                break label1208;
              }
              f1 -= 0.5F;
              if (f1 <= 0.0F) {
                break label961;
              }
              paramInt2 = (int)(k * i10 / f1);
              k = 0;
              paramInt1 = j;
              j = k;
              for (;;)
              {
                if (j < i11) {
                  if ((1 << j & l1) == 0L)
                  {
                    j += 1;
                    continue;
                    j = 0;
                    paramInt2 = k;
                    if (j < i11)
                    {
                      localObject = getChildAt(j);
                      localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
                      if ((1 << j & l2) == 0L)
                      {
                        if (localLayoutParams.cellsUsed != paramInt1 + 1) {
                          break label1223;
                        }
                        l1 |= 1 << j;
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              j += 1;
              break label818;
              if ((i4 != 0) && (localLayoutParams.preventEdgeOffset) && (paramInt2 == 1)) {
                ((View)localObject).setPadding(this.mGeneratedItemPadding + i10, 0, this.mGeneratedItemPadding, 0);
              }
              localLayoutParams.cellsUsed += 1;
              localLayoutParams.expanded = true;
              paramInt2 -= 1;
              continue;
              j = 1;
              k = paramInt2;
              break;
              paramInt1 = 0;
              break label626;
              paramInt2 = 0;
              break label773;
              localObject = getChildAt(j);
              localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
              if ((localObject instanceof ActionMenuItemView))
              {
                localLayoutParams.extraPixels = paramInt2;
                localLayoutParams.expanded = true;
                if ((j == 0) && (!localLayoutParams.preventEdgeOffset)) {
                  localLayoutParams.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
                break label803;
              }
              if (localLayoutParams.isOverflowButton)
              {
                localLayoutParams.extraPixels = paramInt2;
                localLayoutParams.expanded = true;
                localLayoutParams.rightMargin = (-paramInt2 / 2);
                paramInt1 = 1;
                break label803;
              }
              if (j != 0) {
                localLayoutParams.leftMargin = (paramInt2 / 2);
              }
              if (j != i11 - 1) {
                localLayoutParams.rightMargin = (paramInt2 / 2);
              }
              break label803;
              for (paramInt2 = 0;; paramInt2 = k)
              {
                if (paramInt1 != 0)
                {
                  paramInt1 = 0;
                  if (paramInt1 < i11)
                  {
                    localObject = getChildAt(paramInt1);
                    localLayoutParams = (ActionMenuView.LayoutParams)((View)localObject).getLayoutParams();
                    if (!localLayoutParams.expanded) {}
                    for (;;)
                    {
                      paramInt1 += 1;
                      break;
                      j = localLayoutParams.cellsUsed;
                      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.extraPixels + j * i10, 1073741824), i3);
                    }
                  }
                }
                if (i8 != 1073741824) {}
                for (;;)
                {
                  setMeasuredDimension(i9, i);
                  this.mMeasuredExtraWidth = (paramInt2 * i10);
                  return;
                  i = i7;
                }
                f1 = f2;
                break;
                paramInt1 = j;
              }
            }
            i6 = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = i6;
            break label514;
          }
        }
        n = paramInt2;
        paramInt2 = i1;
        i1 = i4;
        paramInt1 = i2;
        m = j;
        j = i1;
        break;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof ActionMenuView.LayoutParams));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected ActionMenuView.LayoutParams generateDefaultLayoutParams()
  {
    ActionMenuView.LayoutParams localLayoutParams = new ActionMenuView.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public ActionMenuView.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionMenuView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ActionMenuView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ActionMenuView.LayoutParams))
    {
      paramLayoutParams = new ActionMenuView.LayoutParams((ActionMenuView.LayoutParams)paramLayoutParams);
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  public ActionMenuView.LayoutParams generateOverflowButtonLayoutParams()
  {
    ActionMenuView.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuView.ActionMenuChildView)) {
        bool1 = false | ((ActionMenuView.ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuView.ActionMenuChildView))) {
      return ((ActionMenuView.ActionMenuChildView)localView2).needsDividerBefore() | bool1;
    }
    return bool1;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  public boolean isExpandedFormat()
  {
    return this.mFormatItems;
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.mPresenter.updateMenuView(false);
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing()))
    {
      this.mPresenter.hideOverflowMenu();
      this.mPresenter.showOverflowMenu();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mPresenter.dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i2 = getChildCount();
    int i1 = (paramInt2 + paramInt4) / 2;
    int i3 = getSupportDividerWidth();
    paramInt4 = 0;
    paramInt2 = 0;
    int j = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int i = 0;
    int k = 0;
    View localView;
    ActionMenuView.LayoutParams localLayoutParams;
    if (k < i2)
    {
      localView = getChildAt(k);
      int m;
      int n;
      if (localView.getVisibility() == 8)
      {
        m = i;
        n = j;
        j = paramInt4;
        i = paramInt2;
        paramInt4 = n;
        paramInt2 = m;
      }
      for (;;)
      {
        n = k + 1;
        k = j;
        m = i;
        i = paramInt2;
        j = paramInt4;
        paramInt2 = m;
        paramInt4 = k;
        k = n;
        break;
        localLayoutParams = (ActionMenuView.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isOverflowButton)
        {
          m = localView.getMeasuredWidth();
          i = m;
          if (hasSupportDividerBeforeChildAt(k)) {
            i = m + i3;
          }
          m = localView.getMeasuredHeight();
          n = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
          int i4 = i1 - m / 2;
          localView.layout(n - i, i4, n, m + i4);
          m = j - i;
          n = 1;
          i = paramInt2;
          j = paramInt4;
          paramInt2 = n;
          paramInt4 = m;
        }
        else
        {
          n = localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          m = paramInt4 + n;
          paramInt4 = m;
          if (hasSupportDividerBeforeChildAt(k)) {
            paramInt4 = m + i3;
          }
          m = j - n;
          n = paramInt2 + 1;
          j = paramInt4;
          paramInt2 = i;
          paramInt4 = m;
          i = n;
        }
      }
    }
    if ((i2 == 1) && (i == 0))
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = i1 - paramInt4 / 2;
      localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
      return;
    }
    if (i != 0)
    {
      paramInt1 = 0;
      label423:
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 <= 0) {
        break label503;
      }
      paramInt1 = j / paramInt1;
      label436:
      paramInt3 = Math.max(0, paramInt1);
      paramInt1 = getPaddingLeft();
      paramInt2 = 0;
      label450:
      if (paramInt2 < i2)
      {
        localView = getChildAt(paramInt2);
        localLayoutParams = (ActionMenuView.LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8) {
          break label573;
        }
        if (!localLayoutParams.isOverflowButton) {
          break label508;
        }
      }
    }
    label573:
    for (;;)
    {
      paramInt2 += 1;
      break label450;
      break;
      paramInt1 = 1;
      break label423;
      label503:
      paramInt1 = 0;
      break label436;
      label508:
      paramInt1 += localLayoutParams.leftMargin;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      j = i1 - i / 2;
      localView.layout(paramInt1, j, paramInt1 + paramInt4, i + j);
      paramInt1 = localLayoutParams.rightMargin + paramInt4 + paramInt3 + paramInt1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mFormatItems = bool1;
      if (bool2 != this.mFormatItems) {
        this.mFormatItemsWidth = 0;
      }
      i = View.MeasureSpec.getMode(paramInt1);
      if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        this.mMenu.onItemsChanged(true);
      }
      if (!this.mFormatItems) {
        break;
      }
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ActionMenuView.LayoutParams localLayoutParams = (ActionMenuView.LayoutParams)getChildAt(i).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */