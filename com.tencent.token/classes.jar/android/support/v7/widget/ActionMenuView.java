package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
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
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.hasText())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), j);
      int k = paramView.getMeasuredWidth();
      int i = k / paramInt1;
      paramInt2 = i;
      if (k % paramInt1 != 0) {
        paramInt2 = i + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((localLayoutParams.isOverflowButton) || (paramInt3 == 0)) {
      bool = false;
    }
    localLayoutParams.expandable = bool;
    localLayoutParams.cellsUsed = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), j);
    return paramInt2;
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int i4 = getPaddingTop() + getPaddingBottom();
    int i10 = getChildMeasureSpec(paramInt2, i4, -2);
    int i6 = paramInt1 - (j + k);
    paramInt2 = this.mMinCellSize;
    paramInt1 = i6 / paramInt2;
    if (paramInt1 == 0)
    {
      setMeasuredDimension(i6, 0);
      return;
    }
    int i11 = paramInt2 + i6 % paramInt2 / paramInt1;
    int i12 = getChildCount();
    int n = 0;
    paramInt2 = 0;
    j = 0;
    int i2 = 0;
    int i1 = 0;
    k = 0;
    long l1 = 0L;
    Object localObject;
    LayoutParams localLayoutParams;
    while (n < i12)
    {
      localObject = getChildAt(n);
      if (((View)localObject).getVisibility() != 8)
      {
        boolean bool = localObject instanceof ActionMenuItemView;
        i2 += 1;
        if (bool)
        {
          m = this.mGeneratedItemPadding;
          ((View)localObject).setPadding(m, 0, m, 0);
        }
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.expanded = false;
        localLayoutParams.extraPixels = 0;
        localLayoutParams.cellsUsed = 0;
        localLayoutParams.expandable = false;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = 0;
        if ((bool) && (((ActionMenuItemView)localObject).hasText())) {
          bool = true;
        } else {
          bool = false;
        }
        localLayoutParams.preventEdgeOffset = bool;
        if (localLayoutParams.isOverflowButton) {
          m = 1;
        } else {
          m = paramInt1;
        }
        i5 = measureChildForCells((View)localObject, i11, m, i10, i4);
        i1 = Math.max(i1, i5);
        m = k;
        if (localLayoutParams.expandable) {
          m = k + 1;
        }
        if (localLayoutParams.isOverflowButton) {
          j = 1;
        }
        paramInt1 -= i5;
        paramInt2 = Math.max(paramInt2, ((View)localObject).getMeasuredHeight());
        if (i5 == 1) {
          l1 |= 1 << n;
        }
        k = m;
      }
      n += 1;
    }
    if ((j != 0) && (i2 == 2)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int m = 0;
    int i5 = paramInt1;
    paramInt1 = m;
    m = i6;
    while ((k > 0) && (i5 > 0))
    {
      i6 = 2147483647;
      int i7 = 0;
      int i8 = 0;
      long l2;
      for (long l3 = 0L; i7 < i12; l3 = l2)
      {
        localObject = (LayoutParams)getChildAt(i7).getLayoutParams();
        int i9;
        if (!((LayoutParams)localObject).expandable)
        {
          i9 = i6;
          n = i8;
          l2 = l3;
        }
        else if (((LayoutParams)localObject).cellsUsed < i6)
        {
          i9 = ((LayoutParams)localObject).cellsUsed;
          l2 = 1L << i7;
          n = 1;
        }
        else
        {
          i9 = i6;
          n = i8;
          l2 = l3;
          if (((LayoutParams)localObject).cellsUsed == i6)
          {
            l2 = l3 | 1L << i7;
            n = i8 + 1;
            i9 = i6;
          }
        }
        i7 += 1;
        i6 = i9;
        i8 = n;
      }
      l1 |= l3;
      if (i8 > i5) {
        break;
      }
      paramInt1 = i6 + 1;
      n = 0;
      while (n < i12)
      {
        localObject = getChildAt(n);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        long l4 = 1 << n;
        if ((l3 & l4) == 0L)
        {
          l2 = l1;
          if (localLayoutParams.cellsUsed == paramInt1) {
            l2 = l1 | l4;
          }
          l1 = l2;
        }
        else
        {
          if ((i4 != 0) && (localLayoutParams.preventEdgeOffset) && (i5 == 1))
          {
            i6 = this.mGeneratedItemPadding;
            ((View)localObject).setPadding(i6 + i11, 0, i6, 0);
          }
          localLayoutParams.cellsUsed += 1;
          localLayoutParams.expanded = true;
          i5 -= 1;
        }
        n += 1;
      }
      paramInt1 = 1;
    }
    n = m;
    if ((j == 0) && (i2 == 1)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i5 > 0) && (l1 != 0L) && ((i5 < i2 - 1) || (j != 0) || (i1 > 1)))
    {
      float f2 = Long.bitCount(l1);
      if (j == 0)
      {
        float f1;
        if ((l1 & 1L) != 0L)
        {
          f1 = f2;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
            f1 = f2 - 0.5F;
          }
        }
        else
        {
          f1 = f2;
        }
        j = i12 - 1;
        f2 = f1;
        if ((l1 & 1 << j) != 0L)
        {
          f2 = f1;
          if (!((LayoutParams)getChildAt(j).getLayoutParams()).preventEdgeOffset) {
            f2 = f1 - 0.5F;
          }
        }
      }
      if (f2 > 0.0F) {
        k = (int)(i5 * i11 / f2);
      } else {
        k = 0;
      }
      m = 0;
      for (;;)
      {
        j = paramInt1;
        if (m >= i12) {
          break;
        }
        if ((l1 & 1 << m) == 0L)
        {
          j = paramInt1;
        }
        else
        {
          localObject = getChildAt(m);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          if ((localObject instanceof ActionMenuItemView))
          {
            localLayoutParams.extraPixels = k;
            localLayoutParams.expanded = true;
            if ((m == 0) && (!localLayoutParams.preventEdgeOffset)) {
              localLayoutParams.leftMargin = (-k / 2);
            }
            j = 1;
          }
          else if (localLayoutParams.isOverflowButton)
          {
            localLayoutParams.extraPixels = k;
            localLayoutParams.expanded = true;
            localLayoutParams.rightMargin = (-k / 2);
            j = 1;
          }
          else
          {
            if (m != 0) {
              localLayoutParams.leftMargin = (k / 2);
            }
            j = paramInt1;
            if (m != i12 - 1)
            {
              localLayoutParams.rightMargin = (k / 2);
              j = paramInt1;
            }
          }
        }
        m += 1;
        paramInt1 = j;
      }
    }
    j = paramInt1;
    paramInt1 = 0;
    if (j != 0) {
      while (paramInt1 < i12)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.expanded) {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.cellsUsed * i11 + localLayoutParams.extraPixels, 1073741824), i10);
        }
        paramInt1 += 1;
      }
    }
    if (i3 == 1073741824) {
      paramInt2 = i;
    }
    setMeasuredDimension(n, paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    if (localActionMenuPresenter != null) {
      localActionMenuPresenter.dismissPopupMenus();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {
        paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public Menu getMenu()
  {
    if (this.mMenu == null)
    {
      Object localObject = getContext();
      this.mMenu = new MenuBuilder((Context)localObject);
      this.mMenu.setCallback(new MenuBuilderCallback());
      this.mPresenter = new ActionMenuPresenter((Context)localObject);
      this.mPresenter.setReserveOverflow(true);
      ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
      localObject = this.mActionMenuPresenterCallback;
      if (localObject == null) {
        localObject = new ActionMenuPresenterCallback();
      }
      localActionMenuPresenter.setCallback((MenuPresenter.Callback)localObject);
      this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
    }
    return this.mMenu;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    getMenu();
    return this.mPresenter.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getWindowAnimations()
  {
    return 0;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuChildView)) {
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if ((localView2 instanceof ActionMenuChildView)) {
        bool2 = bool1 | ((ActionMenuChildView)localView2).needsDividerBefore();
      }
    }
    return bool2;
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.hideOverflowMenu());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.isOverflowMenuShowing());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.mPresenter;
    if (paramConfiguration != null)
    {
      paramConfiguration.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing())
      {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int m = getChildCount();
    int k = (paramInt4 - paramInt2) / 2;
    int n = getDividerWidth();
    int i1 = paramInt3 - paramInt1;
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingLeft();
    paramBoolean = ViewUtils.isLayoutRtl(this);
    paramInt1 = i1 - paramInt1 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int j;
    while (paramInt2 < m)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isOverflowButton)
        {
          i = localView.getMeasuredWidth();
          paramInt4 = i;
          if (hasSupportDividerBeforeChildAt(paramInt2)) {
            paramInt4 = i + n;
          }
          int i2 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            j = getPaddingLeft() + localLayoutParams.leftMargin;
            i = j + paramInt4;
          }
          else
          {
            i = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            j = i - paramInt4;
          }
          int i3 = k - i2 / 2;
          localView.layout(j, i3, i, i2 + i3);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        }
        else
        {
          paramInt1 -= localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          hasSupportDividerBeforeChildAt(paramInt2);
          paramInt3 += 1;
        }
      }
      paramInt2 += 1;
    }
    if ((m == 1) && (paramInt4 == 0))
    {
      localView = getChildAt(0);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = i1 / 2 - paramInt1 / 2;
      paramInt4 = k - paramInt2 / 2;
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    paramInt2 = paramInt3 - (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = 0;
    paramInt3 = 0;
    int i = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = paramInt3;
      while (paramInt1 < m)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {
          if (localLayoutParams.isOverflowButton)
          {
            paramInt3 = paramInt2;
          }
          else
          {
            paramInt2 -= localLayoutParams.rightMargin;
            paramInt3 = localView.getMeasuredWidth();
            paramInt4 = localView.getMeasuredHeight();
            j = k - paramInt4 / 2;
            localView.layout(paramInt2 - paramInt3, j, paramInt2, paramInt4 + j);
            paramInt3 = paramInt2 - (paramInt3 + localLayoutParams.leftMargin + i);
          }
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
    }
    paramInt2 = getPaddingLeft();
    paramInt1 = paramInt4;
    while (paramInt1 < m)
    {
      localView = getChildAt(paramInt1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8) {
        if (localLayoutParams.isOverflowButton)
        {
          paramInt3 = paramInt2;
        }
        else
        {
          paramInt2 += localLayoutParams.leftMargin;
          paramInt3 = localView.getMeasuredWidth();
          paramInt4 = localView.getMeasuredHeight();
          j = k - paramInt4 / 2;
          localView.layout(paramInt2, j, paramInt2 + paramInt3, paramInt4 + j);
          paramInt3 = paramInt2 + (paramInt3 + localLayoutParams.rightMargin + i);
        }
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.mFormatItems;
    boolean bool1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mFormatItems = bool1;
    if (bool2 != this.mFormatItems) {
      this.mFormatItemsWidth = 0;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    Object localObject;
    if (this.mFormatItems)
    {
      localObject = this.mMenu;
      if ((localObject != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        ((MenuBuilder)localObject).onItemsChanged(true);
      }
    }
    int j = getChildCount();
    if ((this.mFormatItems) && (j > 0))
    {
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    i = 0;
    while (i < j)
    {
      localObject = (LayoutParams)getChildAt(i).getLayoutParams();
      ((LayoutParams)localObject).rightMargin = 0;
      ((LayoutParams)localObject).leftMargin = 0;
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public MenuBuilder peekMenu()
  {
    return this.mMenu;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    getMenu();
    this.mPresenter.setOverflowIcon(paramDrawable);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(@StyleRes int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
      {
        this.mPopupContext = getContext();
        return;
      }
      this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
    this.mPresenter.setMenuView(this);
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.showOverflowMenu());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  private static class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      return false;
    }
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }
    
    LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  private class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    MenuBuilderCallback() {}
    
    public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return (ActionMenuView.this.mOnMenuItemClickListener != null) && (ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
    }
    
    public void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (ActionMenuView.this.mMenuBuilderCallback != null) {
        ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
      }
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */