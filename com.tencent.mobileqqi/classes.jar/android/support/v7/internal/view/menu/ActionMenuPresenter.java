package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.internal.view.ActionBarPolicy;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  private ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  private View mOverflowButton;
  private ActionMenuPresenter.OverflowPopup mOverflowPopup;
  final ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback = new ActionMenuPresenter.PopupPresenterCallback(this, null);
  private ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, 2130903049, 2130903048);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    Object localObject;
    if (localViewGroup == null)
    {
      localObject = null;
      return localObject;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label74;
      }
      View localView = localViewGroup.getChildAt(i);
      if ((localView instanceof MenuView.ItemView))
      {
        localObject = localView;
        if (((MenuView.ItemView)localView).getItemData() == paramMenuItem) {
          break;
        }
      }
      i += 1;
    }
    label74:
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)this.mMenuView;
    ((ActionMenuItemView)paramItemView).setItemInvoker(paramMenuItemImpl);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    ArrayList localArrayList = this.mMenu.getVisibleItems();
    int i4 = localArrayList.size();
    int i = this.mMaxItems;
    int i3 = this.mActionItemWidthLimit;
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    Object localObject1;
    if (j < i4)
    {
      localObject1 = (MenuItemImpl)localArrayList.get(j);
      if (((MenuItemImpl)localObject1).requiresActionButton())
      {
        k += 1;
        label82:
        if ((!this.mExpandedActionViewsExclusive) || (!((MenuItemImpl)localObject1).isActionViewExpanded())) {
          break label814;
        }
        i = 0;
      }
    }
    label549:
    label814:
    for (;;)
    {
      j += 1;
      break;
      if (((MenuItemImpl)localObject1).requestsActionButton())
      {
        m += 1;
        break label82;
      }
      n = 1;
      break label82;
      j = i;
      if (this.mReserveOverflow) {
        if (n == 0)
        {
          j = i;
          if (k + m <= i) {}
        }
        else
        {
          j = i - 1;
        }
      }
      j -= k;
      localObject1 = this.mActionButtonGroups;
      ((SparseBooleanArray)localObject1).clear();
      i = 0;
      if (this.mStrictWidthLimit)
      {
        i = i3 / this.mMinCellSize;
        k = this.mMinCellSize;
        m = this.mMinCellSize;
      }
      for (int i1 = i3 % k / i + m;; i1 = 0)
      {
        int i2 = 0;
        n = 0;
        k = i;
        i = j;
        m = i3;
        j = n;
        MenuItemImpl localMenuItemImpl;
        Object localObject2;
        if (i2 < i4)
        {
          localMenuItemImpl = (MenuItemImpl)localArrayList.get(i2);
          if (localMenuItemImpl.requiresActionButton())
          {
            localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
            if (this.mScrapActionButtonView == null) {
              this.mScrapActionButtonView = ((View)localObject2);
            }
            if (this.mStrictWidthLimit)
            {
              n = k - ActionMenuView.measureChildForCells((View)localObject2, i1, k, i5, 0);
              label304:
              k = ((View)localObject2).getMeasuredWidth();
              if (j != 0) {
                break label805;
              }
              j = k;
            }
          }
        }
        for (;;)
        {
          i3 = localMenuItemImpl.getGroupId();
          if (i3 != 0) {
            ((SparseBooleanArray)localObject1).put(i3, true);
          }
          localMenuItemImpl.setIsActionButton(true);
          m -= k;
          k = i;
          i = m;
          for (;;)
          {
            i3 = i2 + 1;
            i2 = k;
            k = n;
            m = i;
            i = i2;
            i2 = i3;
            break;
            ((View)localObject2).measure(i5, i5);
            n = k;
            break label304;
            if (localMenuItemImpl.requestsActionButton())
            {
              int i6 = localMenuItemImpl.getGroupId();
              boolean bool = ((SparseBooleanArray)localObject1).get(i6);
              int i7;
              if (((i > 0) || (bool)) && (m > 0) && ((!this.mStrictWidthLimit) || (k > 0)))
              {
                i7 = 1;
                label445:
                if (i7 == 0) {
                  break label775;
                }
                localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
                if (this.mScrapActionButtonView == null) {
                  this.mScrapActionButtonView = ((View)localObject2);
                }
                if (!this.mStrictWidthLimit) {
                  break label632;
                }
                n = ActionMenuView.measureChildForCells((View)localObject2, i1, k, i5, 0);
                if (n != 0) {
                  break label772;
                }
                i7 = 0;
                label505:
                k -= n;
                label510:
                n = ((View)localObject2).getMeasuredWidth();
                i3 = m - n;
                m = j;
                if (j == 0) {
                  m = n;
                }
                if (!this.mStrictWidthLimit) {
                  break label649;
                }
                if (i3 < 0) {
                  break label644;
                }
                j = 1;
                i7 &= j;
                j = m;
                n = k;
                m = i3;
                k = j;
                j = n;
              }
              for (;;)
              {
                if ((i7 != 0) && (i6 != 0)) {
                  ((SparseBooleanArray)localObject1).put(i6, true);
                }
                for (;;)
                {
                  n = i;
                  if (i7 != 0) {
                    n = i - 1;
                  }
                  localMenuItemImpl.setIsActionButton(i7);
                  i = m;
                  m = n;
                  n = j;
                  j = k;
                  k = m;
                  break;
                  int i8 = 0;
                  break label445;
                  label632:
                  ((View)localObject2).measure(i5, i5);
                  break label510;
                  j = 0;
                  break label549;
                  if (i3 + m > 0) {}
                  for (j = 1;; j = 0)
                  {
                    i8 &= j;
                    j = k;
                    k = m;
                    m = i3;
                    break;
                  }
                  if (bool)
                  {
                    ((SparseBooleanArray)localObject1).put(i6, false);
                    i3 = 0;
                    while (i3 < i2)
                    {
                      localObject2 = (MenuItemImpl)localArrayList.get(i3);
                      n = i;
                      if (((MenuItemImpl)localObject2).getGroupId() == i6)
                      {
                        n = i;
                        if (((MenuItemImpl)localObject2).isActionButton()) {
                          n = i + 1;
                        }
                        ((MenuItemImpl)localObject2).setIsActionButton(false);
                      }
                      i3 += 1;
                      i = n;
                      continue;
                      return true;
                    }
                  }
                }
                break label505;
                n = j;
                j = k;
                k = n;
              }
            }
            n = m;
            m = i;
            i = n;
            n = k;
            k = m;
          }
        }
      }
    }
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView()))
    {
      localView = paramView;
      if (!(paramView instanceof ActionMenuItemView)) {
        localView = null;
      }
      localView = super.getItemView(paramMenuItemImpl, localView, paramViewGroup);
    }
    if (paramMenuItemImpl.isActionViewExpanded()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      paramMenuItemImpl = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
        localView.setLayoutParams(paramMenuItemImpl.generateLayoutParams(paramView));
      }
      return localView;
    }
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getMenuView(paramViewGroup);
    ((ActionMenuView)paramViewGroup).setPresenter(this);
    return paramViewGroup;
  }
  
  public boolean hideOverflowMenu()
  {
    if ((this.mPostedOpenRunnable != null) && (this.mMenuView != null))
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    }
    ActionMenuPresenter.OverflowPopup localOverflowPopup = this.mOverflowPopup;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    if (this.mActionButtonPopup != null)
    {
      this.mActionButtonPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    paramMenuBuilder = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = paramContext.showsOverflowMenuButton();
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = paramContext.getMaxActionButtons();
    }
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    for (;;)
    {
      this.mActionItemWidthLimit = i;
      this.mMinCellSize = ((int)(56.0F * paramMenuBuilder.getDisplayMetrics().density));
      this.mScrapActionButtonView = null;
      return;
      this.mOverflowButton = null;
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.mOverflowPopup != null) && (this.mOverflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet) {
      this.mMaxItems = this.mContext.getResources().getInteger(2131492864);
    }
    if (this.mMenu != null) {
      this.mMenu.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (ActionMenuPresenter.SavedState)paramParcelable;
    if (paramParcelable.openSubMenuId > 0)
    {
      paramParcelable = this.mMenu.findItem(paramParcelable.openSubMenuId);
      if (paramParcelable != null) {
        onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    ActionMenuPresenter.SavedState localSavedState = new ActionMenuPresenter.SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != this.mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
    if (findViewForItem(((SubMenuBuilder)localObject).getItem()) == null)
    {
      if (this.mOverflowButton == null) {
        return false;
      }
      localObject = this.mOverflowButton;
    }
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    this.mActionButtonPopup = new ActionMenuPresenter.ActionButtonSubmenu(this, paramSubMenuBuilder);
    this.mActionButtonPopup.show(null);
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
      return;
    }
    this.mMenu.close(false);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null))
    {
      this.mPostedOpenRunnable = new ActionMenuPresenter.OpenOverflowRunnable(this, new ActionMenuPresenter.OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    super.updateMenuView(paramBoolean);
    if (this.mMenuView == null) {
      return;
    }
    Object localObject;
    int i;
    if (this.mMenu != null)
    {
      localObject = this.mMenu.getActionItems();
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        ActionProvider localActionProvider = ((MenuItemImpl)((ArrayList)localObject).get(i)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
        i += 1;
      }
    }
    if (this.mMenu != null)
    {
      localObject = this.mMenu.getNonActionItems();
      i = k;
      if (this.mReserveOverflow)
      {
        i = k;
        if (localObject != null)
        {
          i = ((ArrayList)localObject).size();
          if (i != 1) {
            break label254;
          }
          if (((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label249;
          }
          i = 1;
        }
      }
      label143:
      if (i == 0) {
        break label268;
      }
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
      }
      localObject = (ViewGroup)this.mOverflowButton.getParent();
      if (localObject != this.mMenuView)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.mOverflowButton);
        }
        localObject = (ActionMenuView)this.mMenuView;
        ((ActionMenuView)localObject).addView(this.mOverflowButton, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
      return;
      localObject = null;
      break;
      label249:
      i = 0;
      break label143;
      label254:
      if (i > 0) {}
      for (i = j;; i = 0) {
        break;
      }
      label268:
      if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView)) {
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */