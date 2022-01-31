package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.layout;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;

class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  ActionMenuPresenter.OverflowMenuButton mOverflowButton;
  ActionMenuPresenter.OverflowPopup mOverflowPopup;
  private Drawable mPendingOverflowIcon;
  private boolean mPendingOverflowIconSet;
  private ActionMenuPresenter.ActionMenuPopupCallback mPopupCallback;
  final ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback = new ActionMenuPresenter.PopupPresenterCallback(this);
  ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
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
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (this.mPopupCallback == null) {
      this.mPopupCallback = new ActionMenuPresenter.ActionMenuPopupCallback(this);
    }
    paramItemView.setPopupCallback(this.mPopupCallback);
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
    ArrayList localArrayList;
    int i1;
    int i;
    int i4;
    int i5;
    ViewGroup localViewGroup;
    int k;
    int m;
    int n;
    int j;
    label60:
    Object localObject1;
    if (this.mMenu != null)
    {
      localArrayList = this.mMenu.getVisibleItems();
      i1 = localArrayList.size();
      i = this.mMaxItems;
      i4 = this.mActionItemWidthLimit;
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.mMenuView;
      k = 0;
      m = 0;
      n = 0;
      j = 0;
      if (j >= i1) {
        break label145;
      }
      localObject1 = (MenuItemImpl)localArrayList.get(j);
      if (!((MenuItemImpl)localObject1).requiresActionButton()) {
        break label122;
      }
      k += 1;
      label89:
      if ((!this.mExpandedActionViewsExclusive) || (!((MenuItemImpl)localObject1).isActionViewExpanded())) {
        break label836;
      }
      i = 0;
    }
    label145:
    label320:
    label836:
    for (;;)
    {
      j += 1;
      break label60;
      i1 = 0;
      localArrayList = null;
      break;
      label122:
      if (((MenuItemImpl)localObject1).requestsActionButton())
      {
        m += 1;
        break label89;
      }
      n = 1;
      break label89;
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
        i = i4 / this.mMinCellSize;
        k = this.mMinCellSize;
        m = this.mMinCellSize;
      }
      for (int i2 = i4 % k / i + m;; i2 = 0)
      {
        int i3 = 0;
        n = 0;
        k = i;
        i = j;
        m = i4;
        j = n;
        MenuItemImpl localMenuItemImpl;
        Object localObject2;
        if (i3 < i1)
        {
          localMenuItemImpl = (MenuItemImpl)localArrayList.get(i3);
          if (localMenuItemImpl.requiresActionButton())
          {
            localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
            if (this.mScrapActionButtonView == null) {
              this.mScrapActionButtonView = ((View)localObject2);
            }
            if (this.mStrictWidthLimit)
            {
              n = k - ActionMenuView.measureChildForCells((View)localObject2, i2, k, i5, 0);
              k = ((View)localObject2).getMeasuredWidth();
              if (j != 0) {
                break label827;
              }
              j = k;
            }
          }
        }
        for (;;)
        {
          i4 = localMenuItemImpl.getGroupId();
          if (i4 != 0) {
            ((SparseBooleanArray)localObject1).put(i4, true);
          }
          localMenuItemImpl.setIsActionButton(true);
          m -= k;
          k = i;
          i = m;
          i4 = i3 + 1;
          i3 = k;
          k = n;
          m = i;
          i = i3;
          i3 = i4;
          break;
          ((View)localObject2).measure(i5, i5);
          n = k;
          break label320;
          int i6;
          boolean bool;
          int i7;
          if (localMenuItemImpl.requestsActionButton())
          {
            i6 = localMenuItemImpl.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i6);
            if (((i > 0) || (bool)) && (m > 0) && ((!this.mStrictWidthLimit) || (k > 0)))
            {
              i7 = 1;
              label461:
              if (i7 == 0) {
                break label816;
              }
              localObject2 = getItemView(localMenuItemImpl, this.mScrapActionButtonView, localViewGroup);
              if (this.mScrapActionButtonView == null) {
                this.mScrapActionButtonView = ((View)localObject2);
              }
              if (!this.mStrictWidthLimit) {
                break label648;
              }
              n = ActionMenuView.measureChildForCells((View)localObject2, i2, k, i5, 0);
              if (n != 0) {
                break label813;
              }
              i7 = 0;
              k -= n;
              n = ((View)localObject2).getMeasuredWidth();
              i4 = m - n;
              m = j;
              if (j == 0) {
                m = n;
              }
              if (!this.mStrictWidthLimit) {
                break label665;
              }
              if (i4 < 0) {
                break label660;
              }
              j = 1;
              i7 &= j;
              j = m;
              n = k;
              m = i4;
              k = j;
              j = n;
            }
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
              break label461;
              ((View)localObject2).measure(i5, i5);
              break label526;
              j = 0;
              break label565;
              if (i4 + m > 0) {}
              for (j = 1;; j = 0)
              {
                i8 &= j;
                j = k;
                k = m;
                m = i4;
                break;
              }
              if (bool)
              {
                ((SparseBooleanArray)localObject1).put(i6, false);
                i4 = 0;
                for (;;)
                {
                  if (i4 < i3)
                  {
                    localObject2 = (MenuItemImpl)localArrayList.get(i4);
                    n = i;
                    if (((MenuItemImpl)localObject2).getGroupId() == i6)
                    {
                      n = i;
                      if (((MenuItemImpl)localObject2).isActionButton()) {
                        n = i + 1;
                      }
                      ((MenuItemImpl)localObject2).setIsActionButton(false);
                    }
                    i4 += 1;
                    i = n;
                    continue;
                    localMenuItemImpl.setIsActionButton(false);
                    n = m;
                    m = i;
                    i = n;
                    n = k;
                    k = m;
                    break;
                    return true;
                  }
                }
              }
            }
            break label521;
            n = j;
            j = k;
            k = n;
          }
        }
      }
    }
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
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
    MenuView localMenuView = this.mMenuView;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localMenuView != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    if (this.mOverflowButton != null) {
      return this.mOverflowButton.getDrawable();
    }
    if (this.mPendingOverflowIconSet) {
      return this.mPendingOverflowIcon;
    }
    return null;
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
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder)
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
        if (this.mPendingOverflowIconSet)
        {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        }
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
  
  public boolean isOverflowMenuShowPending()
  {
    return (this.mPostedOpenRunnable != null) || (isOverflowMenuShowing());
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
      this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    }
    if (this.mMenu != null) {
      this.mMenu.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ActionMenuPresenter.SavedState)) {}
    do
    {
      do
      {
        return;
        paramParcelable = (ActionMenuPresenter.SavedState)paramParcelable;
      } while (paramParcelable.openSubMenuId <= 0);
      paramParcelable = this.mMenu.findItem(paramParcelable.openSubMenuId);
    } while (paramParcelable == null);
    onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
  }
  
  public Parcelable onSaveInstanceState()
  {
    ActionMenuPresenter.SavedState localSavedState = new ActionMenuPresenter.SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {}
    Object localObject;
    do
    {
      return false;
      for (localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != this.mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
      localObject = findViewForItem(((SubMenuBuilder)localObject).getItem());
    } while (localObject == null);
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    int j = paramSubMenuBuilder.size();
    int i = 0;
    if (i < j)
    {
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.mActionButtonPopup = new ActionMenuPresenter.ActionButtonSubmenu(this, this.mContext, paramSubMenuBuilder, (View)localObject);
      this.mActionButtonPopup.setForceShowIcon(bool);
      this.mActionButtonPopup.show();
      super.onSubMenuSelected(paramSubMenuBuilder);
      return true;
      i += 1;
      break;
    }
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
    }
    while (this.mMenu == null) {
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
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    if (this.mOverflowButton != null)
    {
      this.mOverflowButton.setImageDrawable(paramDrawable);
      return;
    }
    this.mPendingOverflowIconSet = true;
    this.mPendingOverflowIcon = paramDrawable;
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
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null) && (!this.mMenu.getNonActionItems().isEmpty()))
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
    ((View)this.mMenuView).requestLayout();
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
            break label256;
          }
          if (((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label251;
          }
          i = 1;
        }
      }
      label145:
      if (i == 0) {
        break label270;
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
      label251:
      i = 0;
      break label145;
      label256:
      if (i > 0) {}
      for (i = j;; i = 0) {
        break;
      }
      label270:
      if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView)) {
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */