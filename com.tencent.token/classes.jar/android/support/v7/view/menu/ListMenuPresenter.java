package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R.layout;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ListMenuPresenter
  implements MenuPresenter, AdapterView.OnItemClickListener
{
  private static final String TAG = "ListMenuPresenter";
  public static final String VIEWS_TAG = "android:menu:list";
  MenuAdapter mAdapter;
  private MenuPresenter.Callback mCallback;
  Context mContext;
  private int mId;
  LayoutInflater mInflater;
  int mItemIndexOffset;
  int mItemLayoutRes;
  MenuBuilder mMenu;
  ExpandedMenuView mMenuView;
  int mThemeRes;
  
  public ListMenuPresenter(int paramInt1, int paramInt2)
  {
    this.mItemLayoutRes = paramInt1;
    this.mThemeRes = paramInt2;
  }
  
  public ListMenuPresenter(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListAdapter getAdapter()
  {
    if (this.mAdapter == null) {
      this.mAdapter = new MenuAdapter();
    }
    return this.mAdapter;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  int getItemIndexOffset()
  {
    return this.mItemIndexOffset;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = ((ExpandedMenuView)this.mInflater.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.mAdapter == null) {
        this.mAdapter = new MenuAdapter();
      }
      this.mMenuView.setAdapter(this.mAdapter);
      this.mMenuView.setOnItemClickListener(this);
    }
    return this.mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    int i = this.mThemeRes;
    if (i != 0)
    {
      this.mContext = new ContextThemeWrapper(paramContext, i);
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    else if (this.mContext != null)
    {
      this.mContext = paramContext;
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(this.mContext);
      }
    }
    this.mMenu = paramMenuBuilder;
    paramContext = this.mAdapter;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mMenu.performItemAction(this.mAdapter.getItem(paramInt), this, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    restoreHierarchyState((Bundle)paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mMenuView == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    saveHierarchyState(localBundle);
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    new MenuDialogHelper(paramSubMenuBuilder).show(null);
    MenuPresenter.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return true;
  }
  
  public void restoreHierarchyState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:list");
    if (paramBundle != null) {
      this.mMenuView.restoreHierarchyState(paramBundle);
    }
  }
  
  public void saveHierarchyState(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    ExpandedMenuView localExpandedMenuView = this.mMenuView;
    if (localExpandedMenuView != null) {
      localExpandedMenuView.saveHierarchyState(localSparseArray);
    }
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setItemIndexOffset(int paramInt)
  {
    this.mItemIndexOffset = paramInt;
    if (this.mMenuView != null) {
      updateMenuView(false);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    MenuAdapter localMenuAdapter = this.mAdapter;
    if (localMenuAdapter != null) {
      localMenuAdapter.notifyDataSetChanged();
    }
  }
  
  private class MenuAdapter
    extends BaseAdapter
  {
    private int mExpandedIndex = -1;
    
    public MenuAdapter()
    {
      findExpandedIndex();
    }
    
    void findExpandedIndex()
    {
      MenuItemImpl localMenuItemImpl = ListMenuPresenter.this.mMenu.getExpandedItem();
      if (localMenuItemImpl != null)
      {
        ArrayList localArrayList = ListMenuPresenter.this.mMenu.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
          {
            this.mExpandedIndex = i;
            return;
          }
          i += 1;
        }
      }
      this.mExpandedIndex = -1;
    }
    
    public int getCount()
    {
      int i = ListMenuPresenter.this.mMenu.getNonActionItems().size() - ListMenuPresenter.this.mItemIndexOffset;
      if (this.mExpandedIndex < 0) {
        return i;
      }
      return i - 1;
    }
    
    public MenuItemImpl getItem(int paramInt)
    {
      ArrayList localArrayList = ListMenuPresenter.this.mMenu.getNonActionItems();
      int i = paramInt + ListMenuPresenter.this.mItemIndexOffset;
      int j = this.mExpandedIndex;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = ListMenuPresenter.this.mInflater.inflate(ListMenuPresenter.this.mItemLayoutRes, paramViewGroup, false);
      }
      ((MenuView.ItemView)localView).initialize(getItem(paramInt), 0);
      return localView;
    }
    
    public void notifyDataSetChanged()
    {
      findExpandedIndex();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuPresenter
 * JD-Core Version:    0.7.0.1
 */